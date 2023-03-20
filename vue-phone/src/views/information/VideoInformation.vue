<template>
    <div>
        
        <!-- 搜索，暂时占个位置 -->
        <van-search 
        @search="onSearch"
        background="#20a0ff"
        placeholder="请输入搜索关键词" />
        
        <!-- <br> -->
        <!-- 视频类型筛选 -->
        <van-tabs v-model="videoType" @click="changeTypeName" >
            <van-tab v-for="index in typeNameList" :title="index.name" :name="index.name" :key="index.name">
            </van-tab> 
        </van-tabs>
        <!-- 视频区域筛选 -->
        <van-tabs v-model="areaType" @click="changeTypeName" >
            <van-tab v-for="index in areaNameList" :title="index.name" :name="index.name" :key="index.name">
            </van-tab> 
        </van-tabs>
        <br>
        <!-- 轮播图片 -->
        <van-swipe :autoplay="3000">
            <van-swipe-item v-for="(image, index) in images" :key="index">
              
                <img  class="bigImg" v-lazy="image"/>
                
            </van-swipe-item>
        </van-swipe>
        <br>
        <br>
        <h4>最新视频</h4>
        <!-- 滑动分页 -->
        <van-list v-model="loading" :finished="finished"  :immediate-check="false"  :offerset="offerset" finished-text="没有更多了" @load="onLoad">
            <!-- 电影信息列表页 -->
            <van-grid :border="false" :column-num="3">
                <van-grid-item  v-for="item in videoList" :key="item.id">
                    <van-image :src=item.videoImg @click="toDetail(item.id)"/>
                    <p class="videoName">{{ item.videoName }}</p>
                </van-grid-item>
            </van-grid>
        </van-list>
        
        
  </div>

</template>
<script>
    import {getDicAPI,listVideoAPI} from "@/api/information/videoInformation"
    export default {
        name:"VideoInformation",
        data(){
            return {
                // 视频类型
                videoType:"",
                // 视频区域类型
                areaType:"",
                // 视频类型tab标签汇总列表
                typeNameList:[],
                // 视频区域tab标签汇总列表
                areaNameList:[],
                // 轮播图url
                images: [
                'https://img01.yzcdn.cn/vant/apple-4.jpg',
                'https://img01.yzcdn.cn/vant/apple-2.jpg',
                'https://img01.yzcdn.cn/vant/apple-2.jpg',
                'https://img01.yzcdn.cn/vant/apple-2.jpg',
                ],
                // 返回的视频列表
                videoList:[],
                page:1,
                loading:false,
                finished:false,
                totalPage:0,
                // 滚动距离
                offset: 100,



                
            }
        },
        // created是需要带（）的
        created(){
            this.getTypeName();
            this.getAreaName();
            this.getVideoList();

        },
        
        methods:{
            // 搜索方法触发
            onSearch(){
                console.log("触发了搜索")
            },
            // 获取视频类型tab标签页
            async getTypeName(){
                const{data:res} =  await getDicAPI("VideoType");
                
                this.typeNameList=res.data.list;
                // console.log(res.data.list);

            },
            // 获取视频区域类型tab标签页
            async getAreaName(){
                const{data:res} =  await getDicAPI("VideoArea");
                this.areaNameList=res.data.list;
                // console.log(res.data.list);

            },
            // 切换视频类型tab标签页获取视频类型
            changeTypeName(){
                console.log(this.videoType)
            },
            // 切换视频区域tab标签页获取视频区域
            changeAreaName(){
                console.log(this.areaType)
            },
            // 获取视频列表
            async getVideoList(){
                const{data:res}=await listVideoAPI(this.page)
                this.totalPage=res.data.totalPage
                this.videoList= this.videoList.concat(res.data.list)
                if(this.page>this.totalPage){
                        this.finished=true
                        console.log("滑动到了最后，没有更多了")
                }
                
                
                // console.log(this.videoList);

            },
            // 跳转详情页
            toDetail(videoId){
                console.log(videoId)
            },
            onLoad(){
                this.loading=false
                console.log("上拉加载")
                this.page=this.page+1
                this.getVideoList()
                // console.log(this.page)
                // console.log(this.loading)

            },
            
            
        }
            
    }

</script>
<style scoped lang="less">
    .bigImg{
        height: 200px;
        text-align:center;
    }
    // 设置视频名称超过一定长度就省略号
    .videoName {
        width: 100px;
        display: block;
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
}
   
</style>
   
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
        <!-- 轮播图片 -->
        <van-swipe :autoplay="3000">
            <van-swipe-item v-for="(image, index) in images" :key="index">
                <img v-lazy="image" with="120" height="130" />
            </van-swipe-item>
        </van-swipe>
  </div>

</template>
<script>
    import {getDicAPI} from "@/api/information/videoInformation"
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
                images: [
                'https://img01.yzcdn.cn/vant/apple-4.jpg',
                'https://img01.yzcdn.cn/vant/apple-2.jpg',
                ]
                
            }
        },
        // created是需要带（）的
        created(){
            this.getTypeName();
            this.getAreaName();

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
                console.log(res.data.list);

            },
            // 获取视频区域类型tab标签页
            async getAreaName(){
                const{data:res} =  await getDicAPI("VideoArea");
                this.areaNameList=res.data.list;
                console.log(res.data.list);

            },
            // 切换视频类型tab标签页获取视频类型
            changeTypeName(){
                console.log(this.videoType)
            },
            // 切换视频区域tab标签页获取视频区域
            changeAreaName(){
                console.log(this.areaType)
            }

        }
    }
</script>
<style scoped lang="less">


</style>
   
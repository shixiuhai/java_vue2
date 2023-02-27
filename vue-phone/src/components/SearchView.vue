<!-- 搜索框插件 -->
<template>
    <div>
        <van-nav-bar
        title="首页"
        left-text="展开搜索框"
        right-text="搜索"
        @click-left="onClickLeft"
        @click-right="GetVideoInforamtion"
        />
        <!-- 搜索框 -->
        <van-search v-model="value" v-show="isSearch"   shape="round"  placeholder="请输入搜索关键词" />

        <!-- 通过区域和类型进行筛选 -->
        <van-tabs v-model="activeTypeName"  @click="GetVideoInforamtion">
            <van-tab title="美剧" name="美剧"></van-tab>
            <van-tab title="韩剧" name="韩剧"></van-tab>
            <van-tab title="综艺" name="综艺"></van-tab>
            <van-tab title="电影" name="电影"></van-tab>
            <van-tab title="动漫" name="动漫"></van-tab>
        </van-tabs>
        <!-- 视频区域 -->
        <van-tabs v-model="activeAreaName"  @click="GetVideoInforamtion">
            <van-tab title="内地" name="内地"></van-tab>
            <van-tab title="韩国" name="韩国"></van-tab>
            <van-tab title="欧美" name="欧美"></van-tab>
            <van-tab title="日本" name="日本"></van-tab>
            <van-tab title="共享" name="共享"></van-tab>
        </van-tabs>
        <!-- <h1>{{a}}</h1> -->
        <!--  {{isSearch 是父组件像子组件传递的数值}} -->
        
    </div>
    
</template>

<script>
    // 导入获取视频信息的接口
    import {getVideoInformationAPI} from '@/api/SearchAPI.js'
    // 实现子组件间共享数据
    import bus from './eventBus.js'
    export default{
        // 定义组件名称，这个名称随意命名，只有保证有两个大写字符
        name: 'SV',
        // 默认数据
        data() {
            return {
                value: "请输入关键字",
                isSearch: false,
                // 搜索筛选返回的结果res
                videoInforMationRes:{},
                // 标签数据
                activeTypeName: '美剧',
                activeAreaName: "内地"
            }
        },
        // 写方法
        methods:{
            // 点击搜索弹出搜索框
            onClickRight(){
                // this.isSearch = !this.isSearch
            },
            // 添加返回退出搜索框
            onClickLeft(){
                this.isSearch=!this.isSearch
            },
            // 数据共享给兄弟组件videoListView
            sendSearchData(){
                // 发送查询结果信息给兄弟组件VideoListView
                bus.$emit("videoInformation",this.videoInforMationRes)
            },
            

            // 获取视频详细数据
            // 默认调用接口获取网页信息
            async defaultGetInforamtion(){
                const{data:res}=await getVideoInformationAPI("电影","","","","美国")
                // 将结果赋值给局部变量 videoInforMationRes
                this.videoInforMationRes=res
                // console.log(videoInforMationRes)
                // 将结果发送给兄弟
                // 发送数据给兄弟
                this.sendSearchData()
                // console.log("发送信息给兄弟成功")

            },

            // 搜索和筛选调用接口进行查询
            async GetVideoInforamtion(){
                const{data:res}=await getVideoInformationAPI(this.value,"","",this.activeTypeName,this.activeAreaName,1)
                // 将结果赋值给局部变量 videoInforMationRes
                this.videoInforMationRes=res
                // console.log(videoInforMationRes)
                // 将结果发送给兄弟
                // 发送数据给兄弟
                this.sendSearchData()
                // console.log("发送信息给兄弟成功")

            },
            
            // 搜索和筛选调用接口进行查询
            async GetpageSize(page){
                const{data:res}=await getVideoInformationAPI(this.value,"","",this.activeTypeName,this.activeAreaName,page)
                // 将结果赋值给局部变量 videoInforMationRes
                this.videoInforMationRes=res
                // console.log(videoInforMationRes)
                // 将结果发送给兄弟
                // 发送数据给兄弟
                this.sendSearchData()
                // console.log("发送信息给兄弟成功")

            }


            


            // sonToFA(){
            //     this.$emit("aaa",this.b)
            //     console.log("点击共享数据给父组件成功")
            // }
            
        },
        created(){
            // 调用接口获取默认数据
            this.defaultGetInforamtion()
            // 接收发送过来的页码数据
            bus.$on("pageSize",val=>{
                let page=val
                console.log("page数据"+page)
                // 调用接口更新数据
                this.GetpageSize(page)
                

                // console.log("触发了")
                // console.log(this.res)
            })
            

        },
        // 父组件共享数据可以传递给变量a(父组件向子组件共享数据)
        // props:['a'],
    
    }
</script>


<template>
    <div>
        <!-- 详情页面
        {{a}} -->
        <iframe :src="videoSrc" scrolling="no" allowfullscreen='true' height="300px" width="100%" frameborder="0" sandbox="allow-same-origin allow-scripts allow-forms">
        </iframe>
        <!-- 播放源切换 -->
        <p>播放源切换</p>
        <van-tabs v-model="videoParse" @click="changeParseLink()">
            <van-tab v-for="item in videoParseObject.data" :key="item.id" :title="'播放源 '+item.parseName"> </van-tab>
        </van-tabs>
        <br>
        <!-- 视频集数切换 -->
        <p>视频集数切换</p>
        <van-tabs v-model="videoNumber" @click="changeVideoNumber()">
            <van-tab v-for="index in videoUrlObject.data.length" :key="index" :title="'第' +index+'集'"></van-tab>
        </van-tabs>
       

        
        <!-- <button @click="getVideoId"> 点击</button> -->
    </div>
</template>


<script>
    // 导入获取解析链接接口
    import {getParseLinkAPI} from '@/api/VideoDetailAPI'
    // 导入获取视频源链接结果
    import {getVideoUrlAPI}  from '@/api/VideoDetailAPI'

    export default{
        name:"VDV",
        data(){
            return {
                // 视频唯一id
                videoId: "",
                // 解析源选择
                videoParse:0,
                // 视频集数选择
                videoNumber:0,
                // 视频原始连接
                videoSourceLink:"http://www.iqiyi.com/v_19rr7p8s48.html",
                // 视频解析连接
                videoParseLink:"https://player.maqq.cn/?url=",
                // 视频播放连接
                videoSrc:"",
                // 解析链接对象
                videoParseObject:{},
                // 视频url链接对象
                videoUrlObject:{}

            }
        },
        methods:{
            // 获取视频唯一id
            getVideoId(){
                this.videoId=this.$route.params.videoId
                // 获取视频集数
               
                console.log(this.$route.params.videoId)
            },
            // 写一个获取视频解析源的方法
            async getParseLink(){
                const {data:res} = await getParseLinkAPI()
                this.videoParseObject=res
                // 调用一下默认解析接口
                this.changeParseLink()

            },
            // 写一个获取视频集数的方法
            async getVideoNumber(){
                const {data:res} = await getVideoUrlAPI(this.videoId)
                this.videoUrlObject=res
                console.log(this.videoUrlObject)
                // 调用一下默认解析接口
                this.changeVideoNumber()

                

            },
            // 写一个切换视频播放源的方法
            changeParseLink(){
                this.videoSrc=this.videoParseObject.data[this.videoParse].parseLink+this.videoUrlObject.data[this.videoNumber].videoUrl
                console.log('---')
                console.log(this.videoSrc) 

            },
            // 写一个切换视频集数的方法
            changeVideoNumber(){
                this.videoSrc=this.videoParseObject.data[this.videoParse].parseLink+this.videoUrlObject.data[this.videoNumber].videoUrl
                console.log('---')
                console.log(this.videoSrc)


            }



        },
        created(){
            // 获取videoId
            this.getVideoId()
            // 获取全部默认解析链接
            this.getParseLink()
            // 默认获取集数
            this.getVideoNumber()
            
            
            
        }
    }
</script>
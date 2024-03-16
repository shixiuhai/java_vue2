<template>
    <div >
      <!-- https://cloud.tencent.com/developer/article/1935303 双向绑定大法 -->
      <!-- <h1>{{ movie.title }}</h1> -->
      <VideoPlayer :type.sync="movie.videoType" :url.sync="movie.videoUrl"/>
      
      <!--播放源  -->
      <van-popover
        v-model="showPlasySource"
        trigger="click"
        :actions="playSource"
        
        @select="onSelectPlaySource"
        >
        <template #reference>
            <van-button type="primary">播放源</van-button>
        </template>
      </van-popover>
      <!--集数切换  -->
      <van-popover
        v-model="showVideoNumber"
        trigger="click"
        :actions="videoNumber"
        @select="onSelectVideoNumber"
        >
        <template #reference>
            <van-button type="primary">集数</van-button>
        </template>
      </van-popover>
    </div>
  </template>
  
  <script>
  // 导入videoPlayer
  import VideoPlayer from './VideoPlayer.vue'
  import {getVideoDetailAPI} from '@/api/detail/videoDetail'
  export default {
    name:"VideoDetail",
    data() {
      return {
        // videoId: this.getVideoId(),
        movie:{
            videoType:'iframe',
            videoUrl:''
            //videoUrl:"https://www.jiexila.com/?url=http://www.iqiyi.com/v_b13ju559og.html"
            //videoUrl:"http://www.iqiyi.com/v_b13ju559og.html"
            // videoUrl:"http://jhwenhua.shenke.group/static//video/2/2023-03-30/39356994/1680183014159.mp4"
            //videoUrl:"https://pili-live-hdl.qingyajiu.com/live/7630e2be8af17546b47245fbca34a540.flv"
            // https://pili-live-hdl.qingyajiu.com/live/7630e2be8af17546b47245fbca34a540.flv
        },
        // 切换源
        showPlasySource: false,
        showVideoNumber: false,
        // 通过 playSource 属性来定义菜单选项
        playSource : [{ text: '默认' }, { text: '源1' }, { text: '源2' }],
        videoNumber : [{ text: '1' }, { text: '2' }, { text: '3' }],
         
      }
    },
    created(){
        this.getVideoDetail()
        // location.reload()

    },
    
    computed: {
     
    },
    methods: {
        // 获取列表页传递过来的详情页id
        getVideoId(){
            // console.log(this.$route.params.id)
            return this.$route.params.id

        },
        // 获取视频详情信息
        async getVideoDetail(){
            const{data:res}= await getVideoDetailAPI(this.getVideoId())

            // 判断videoType类型
            if(res.data.list[0].url.endsWith("mp4")||res.data.list[0].url.endsWith("m3u8")||res.data.list[0].url.endsWith("flv"))
            {
              this.movie.videoType="video"
  
            }
            else{
              this.movie.videoType="iframe"
              
            }
            this.movie.videoUrl=res.data.list[0].url

            this.videoNumber=[{text:res.data.list[0].number}]
            console.log(this.movie.videoUrl)
            
           

        },
        // 切换播放源
        onSelectPlaySource(playSource) {
            console.log(playSource.text)
        },
        // 切换视频集数
        onSelectVideoNumber(videoNumber) {
            console.log(videoNumber.text)
            //this.movie.videoUrl="https://www.jiexila.com/?url=http://www.iqiyi.com/v_b13ju559og.html"

        },
        
        
        
      
    },
   
    mounted() {
   
      
    
     
    },
    components:{
        // 使用的播放子组件
        VideoPlayer
    }
  };
  </script>

<style scoped lang="less">


</style>
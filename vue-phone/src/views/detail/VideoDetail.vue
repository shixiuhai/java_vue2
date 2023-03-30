<template>
    <div >
      <!-- <h1>{{ movie.title }}</h1> -->
      <VideoPlayer :type="movie.videoType" :url="movie.videoUrl"/>
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
            title:'电影标题',
            videoType:'video',
            //videoUrl:"https://www.jiexila.com/?url=http://www.iqiyi.com/v_b13ju559og.html"
            //videoUrl:"http://www.iqiyi.com/v_b13ju559og.html"
            videoUrl:"http://jhwenhua.shenke.group/static//video/2/2023-03-30/39356994/1680183014159.mp4"
            //videoUrl:"https://pili-live-hdl.qingyajiu.com/live/7630e2be8af17546b47245fbca34a540.flv"
            // https://pili-live-hdl.qingyajiu.com/live/7630e2be8af17546b47245fbca34a540.flv
        }
        
      };
    },
    created(){
        this.getVideoDetail()

    },
    
    computed: {
     
    },
    methods: {
        // 获取列表页传递过来的详情页id
        getVideoId(){
            console.log(this.$route.params.id)
            return this.$route.params.id

        },
        // 获取视频详情信息
        async getVideoDetail(){
            const{data:res}= await getVideoDetailAPI(this.getVideoId())
            console.log(res.data.list)

        }
        
      
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
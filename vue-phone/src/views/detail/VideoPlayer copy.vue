<template>
    <div v-if="type === 'video'" class="video">
      <video ref="videoPlayer" controls></video>
    </div>
    <div v-else-if="type === 'iframe'" class="video">
      <iframe ref="videoPlayer" frameborder="0" allowfullscreen></iframe>
    </div>
    <div v-else>
      不支持的视频类型
    </div>
  </template>
  
  <script>
  export default {
    props: {
      type: {
        type: String,
        required: true
      },
      url: {
        type: String,
        required: true
      }
    },
  
    mounted() {
      const videoPlayer = this.$refs.videoPlayer
  
      if (this.type === 'video') {
        videoPlayer.src = this.url
        videoPlayer.load()
      } else if (this.type === 'iframe') {
        videoPlayer.src = this.url
      }
    }
  }
  </script>


<style scoped lang="less">
    .video{
        width: auto;

    }
</style>
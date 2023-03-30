<template>
    <div v-if="type === 'video'">
      <video ref="videoPlayer" controls></video>
    </div>
    <div v-else-if="type === 'iframe'">
      <iframe ref="videoPlayer" frameborder="0" allowfullscreen></iframe>
    </div>
    <div v-else>
      不支持的视频类型
    </div>
  </template>
  
  <script>
  import flvjs from 'flv.js'
  import videojs from 'video.js'
  import 'video.js/dist/video-js.min.css'
  //import 'videojs-contrib-hls/dist/videojs-contrib-hls.min.js'
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
        // 判断视频格式是否为FLV
        if (this.url.endsWith('.flv')) {
          const flvPlayer = flvjs.createPlayer({
            type: 'flv',
            url: this.url
          })
          flvPlayer.attachMediaElement(videoPlayer)
          flvPlayer.load()
          flvPlayer.play()
        } else if (this.url.endsWith('.m3u8')) {
          // 判断视频格式是否为M3U8
          videojs(videoPlayer, {
            techOrder: ['html5', 'flash'],
            plugins: {
              videoJsResolutionSwitcher: {
                default: 'high',
                dynamicLabel: true
              },
              videoJsHls: {
                withCredentials: true
              }
            }
          }, function() {
            console.log('video.js player is ready')
          })
        } else {
          // 普通视频格式，使用<video>标签播放
          videoPlayer.src = this.url
          videoPlayer.load()
        }
      } else if (this.type === 'iframe') {
        // 使用<iframe>标签播放
        videoPlayer.src = this.url
      }
    }
  }
  </script>
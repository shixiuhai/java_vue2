<template>
  <div>
    <!-- 搜索栏 -->
    <van-nav-bar
        title="首页"
        left-text="展开搜索框"
        right-text="搜索"
        @click-left="ifShowSearch()"
        @click-right="searchFunction()"
    />
    <!-- 搜索框 -->
    <van-search v-model="searchContent" v-show="isSearch"   shape="round"  placeholder="请输入搜索关键词" />

    <!-- 通过区域和类型进行筛选 -->
    <van-tabs v-model="activeTypeName"  @click="GetVideoInforamtion('','','',activeTypeName,activeAreaName,'','')">
        <van-tab title="美剧" name="美剧"></van-tab>
        <van-tab title="韩剧" name="韩剧"></van-tab>
        <van-tab title="综艺" name="综艺"></van-tab>
        <van-tab title="电影" name="电影"></van-tab>
        <van-tab title="动漫" name="动漫"></van-tab>
    </van-tabs>

    <!-- 视频区域 -->
    <van-tabs v-model="activeAreaName"  @click="GetVideoInforamtion('','','',activeTypeName,activeAreaName,'','')">
        <van-tab title="内地" name="内地"></van-tab>
        <van-tab title="韩国" name="韩国"></van-tab>
        <van-tab title="欧美" name="欧美"></van-tab>
        <van-tab title="日本" name="日本"></van-tab>
        <van-tab title="共享" name="共享"></van-tab>
    </van-tabs>

    <!-- 展示电影数据 -->
    <van-grid :column-num="2" square >
            <van-grid-item v-for="item in videoInformationResult.data.records" :key="item" >
                <!-- 实现图片对页面的跳转 -->
                <van-image @click="jumpDetail(item.id)" :src=item.videoImg  with="120" height="130" ></van-image>
                <!-- 进行链接跳转到新页面进行页面渲染 -->
                <div @click="jumpDetail(item.id)"  class="classLink" >{{item.videoName}}</div>
            </van-grid-item>   
    </van-grid>

    <!-- 翻页查询数据 -->
    <!-- 翻页实现 -->
    <van-pagination v-if="totalPage!=1" v-model="currentPage" :page-count="totalPage" mode="simple" @change="turnPage()" />
   
   

    
  </div>
</template>

<script>
// 导入homeVue获取
import { getVideoInformationAPI } from '@/api/HomeAPI';

export default {
  // 定义组件名称
  name: 'HomeView',
  data(){
        return {
          // 是否展开搜索框
          isSearch:true,
          // 接收调用接口的信息
          videoInformationResult:{},
          // 搜索框内容
          searchContent:"",
          // 视频类型
          activeTypeName:"电影",
          // 视频区域
          activeAreaName:"内地",
          // 当前页面
          currentPage:1,
          // 总页数
          totalPage:1,
          // 是否显示翻页栏目
          isShowPage:false
            
        }
  },
  // 写默认执行方法
  created(){
    // 默认调用一下接口
    this.GetVideoInforamtion('','','','电影','内地',1,'')
  },
  // 写方法
  methods:{
    // 跳转到详情页面方法
    jumpDetail(id){
      let videoId=id
      console.log("页面跳转"+id)
      // 推送给detail页面
      this.$router.push({
        name: "videoDetail", // ⚠️注：这里不能用path路径，只能用name【请对照router.js中的路由规则中的name项】，否则取不到传过去的数据
        params: {
            videoId:videoId
            
        }
      })
    },
    // 定义一个获取视频信息的接口
    async GetVideoInforamtion(videoName,startTime,endTime,type,area,page,pageSize){
      // 调用api接口 , await不能忘掉
      const{data:res}= await getVideoInformationAPI(videoName,startTime,endTime,type,area,page,pageSize)
      this.videoInformationResult=res
      // 更新总页面
      this.totalPage=parseInt( (this.videoInformationResult.data.total)/(this.videoInformationResult.data.size))+1
    },
    // 定义一个是否展开搜索框的方法
    ifShowSearch(){
      this.isSearch=!this.isSearch
    },
    // 定义一个翻页写法
    turnPage(){
      // 调用翻页方法
      this.GetVideoInforamtion(this.searchContent,'','',this.activeTypeName,this.activeAreaName,this.currentPage,'')
      


    },
    // 定义一个search方法
    searchFunction(){
      this.GetVideoInforamtion(this.searchContent,'','','','','','')
      // 定义当前页面为第一页
      this.currentPage=1

    }
   

  },
  // 加载子组件
  components: {
   
}

}
</script>

<style lang="less" scoped>
  // 设置电影标题样式，当字数超过一定数量就以省略号
  .classLink {
        width:100px;
        align-items: center;
        white-space:nowrap;
        text-overflow:ellipsis;
        -o-text-overflow:ellipsis;
        overflow: hidden;
        font-size: 15px;

    }
  // 组件外层容器的样式
  .home-container {
    padding-top: 46px;
    padding-bottom: 50px;
  }
  // logo 样式
  .logo {
    height: 80%;
}
</style>

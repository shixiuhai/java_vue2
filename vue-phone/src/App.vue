<template>
  <div>
      <!-- Home 和 User 的路由占位符 -->
      <router-view></router-view>
      <!-- 底部的 TabBar -->
      <!-- 底部的 TabBar -->
      <van-tabbar>
      <van-tabbar-item icon="home-o"  to="/">首页</van-tabbar-item>
      <van-tabbar-item icon="bar-chart-o" to="/hot">排行榜</van-tabbar-item>
      <van-tabbar-item icon="records" to="/records">求片</van-tabbar-item>
      <van-tabbar-item icon="user-o" to="/user">我的</van-tabbar-item>
      </van-tabbar>
</div>

</template>
<script>
  export default {
      name:"VideoHome"
  }
</script>
<style scoped lang="less">
</style>
<template>
  <div>
   <!-- Home 和 User 的路由占位符 -->
   <router-view></router-view>
    <!-- 底部的 TabBar
    <van-tabbar route>
      
        <van-tabbar-item icon="home-o"  to="/">首页</van-tabbar-item>
        <van-tabbar-item icon="user-o"  to="/user">我的</van-tabbar-item>
      
    </van-tabbar> -->


  </div>
</template>

<script>
  
  export default {
    name: 'App',
    data(){
      return {
       
        
      }
    },
    methods:{
     


    },
    components:{
   
}
  }
</script>

<style>

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>

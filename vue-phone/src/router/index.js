import Vue from 'vue'
import VueRouter from 'vue-router'
// .vue 和 .js后缀都可以省略
import Login from "@/views/user/UserLogin"
// 导入首页
import Home from "@/views/VideoHome"

Vue.use(VueRouter)

const routes = [
  // 带有 name 名称的路由规则，叫做“命名路由”
  {path:"/login",component:Login,name:"login"},
  {path:"/",component:Home,name:"home"}

  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

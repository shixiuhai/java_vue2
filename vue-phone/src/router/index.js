import Vue from 'vue'
import VueRouter from 'vue-router'
// .vue 和 .js后缀都可以省略
import Login from "@/views/user/UserLogin"
// 导入视频信息页面
import Information from "@/views/information/VideoInformation"
// 导入用户信息表
import UserInfo from "@/views/user/UserInfo"
// 导入store
import store from "@/store/index"
Vue.use(VueRouter)

const routes = [
  // 带有 name 名称的路由规则，叫做“命名路由”
  {path:"/login",component:Login,name:"login"},
  // 判断是否登陆 meta: { requiresAuth: true}
  {path:"/",component:Information,name:"information", meta: { requiresAuth: true}},
  {path:"/user",component:UserInfo,name:"userInfo", meta: { requiresAuth: true }}
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

// 在vue-router的全局前置守卫中检查用户是否已经登录，如果没有登录则重定向到登录页面
router.beforeEach((to, from, next) => {
  const requiresAuth = to.matched.some(record => record.meta.requiresAuth) // 获取当前路由是否需要登录才能访问
  const isLoggedIn = checkIfUserIsLoggedIn() // 自定义的判断用户是否已经登录的函数

  if (requiresAuth && !isLoggedIn) { // 需要登录且未登录，则重定向到登录页面
    next('/login')
  } else {
    next() // 否则放行
    
  }
})

// 自定义的判断用户是否已经登录的函数
function checkIfUserIsLoggedIn() {
  // 根据具体的业务逻辑来判断用户是否已经登录
  // 比如，可以检查本地存储中是否有用户登录信息、是否有登录凭证等
  // 返回true表示已经登录，返回false表示未登录
  if(store.state.authorization){
    // login()
    return true
  }
  else{
    return false
  }
  
}



export default router

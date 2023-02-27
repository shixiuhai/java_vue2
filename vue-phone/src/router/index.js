import Vue from 'vue'
import VueRouter from 'vue-router'
// 导入首页
import HomeView from '../views/HomeView.vue'
// 导入用户页面
import UserView from '../views/UserView.vue'
// 导入视频详情页面
import VideoDetailView from '../views/VideoDetailView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/user',
    name: 'user',
    component: UserView
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    // component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path:'/videoDetail',
    name: 'videoDetail',
    component: VideoDetailView
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

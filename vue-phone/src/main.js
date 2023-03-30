// main里需要配置比如app router store
import Vue from 'vue'
import App from './App.vue'
import router from './router'
// 引入store
// vue 安装vuex是3版本  npm install vuex@3 --save
import store from './store'
import VueLazyload from 'vue-lazyload'


// 导入 Vant 和 组件的样式表
import Vant from 'vant'
import 'vant/lib/index.css'

// 导入全局样式表
import './index.less'
// import EventTarget from 'event-target-polyfill'


// 注册全局插件
Vue.use(Vant)
Vue.use(VueLazyload)

Vue.config.productionTip = false

// // 将EventTarget添加到Vue原型中
// Vue.prototype.$EventTarget = EventTarget


new Vue({
  router,
  store,
  render: h => h(App)
})
.$mount('#app')







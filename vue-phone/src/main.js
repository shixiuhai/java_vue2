import Vue from 'vue'
import App from './App.vue'
import router from './router'

// 导入 Vant 和 组件的样式表
import Vant from 'vant'
import 'vant/lib/index.css'

// 导入全局样式表
import './index.less'

// 注册全局插件
Vue.use(Vant)

Vue.config.productionTip = false



new Vue({
  router,
  // store,
  render: h => h(App)
})
.$mount('#app')







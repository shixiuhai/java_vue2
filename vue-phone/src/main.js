import Vue from 'vue'
import App from './App.vue'
import router from './router'

// 导入vant组件
import Vant from 'vant'
import 'vant/lib/index.css'

// 使用Vant组件,一次导入所有的vant组件
Vue.use(Vant)
// import store from './store'

Vue.config.productionTip = false



new Vue({
  router,
  // store,
  render: h => h(App)
})
.$mount('#app')







import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  // https://blog.csdn.net/m0_55905001/article/details/123635191 state mutations actions区别
  state: {
    // 用来存储 authorization 信息，将来这个对象中会包含两个属性
    authorization: ""
  },
  getters: {
  },
  mutations: {
    // 更新 tokenInfo 数据的方法
    updateAuthorizationInfo(state, authorization) {
      
      // 把提交过来的 payload 对象，作为 tokenInfo 的值
      state.authorization = authorization
      // 测试 state 中是否有数据
      console.log(state)
    }
  },
  actions: {
  },
  modules: {
  }
})

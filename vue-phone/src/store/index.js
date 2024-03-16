import Vue from 'vue'
import Vuex from 'vuex'


Vue.use(Vuex)
// 初始化从storage读取数值到state
// 初始的 state 对象
let initState = {
  // token 的信息对象
  authorization: ""
}
const stateStr = localStorage.getItem('state')
if (stateStr) {
  // 加载本地的数据
  initState = JSON.parse(stateStr)
}


export default new Vuex.Store({
  
  // https://blog.csdn.net/m0_55905001/article/details/123635191 state mutations actions区别
  // state: {
  //   // 用来存储 authorization 信息，将来这个对象中会包含两个属性
  //   authorization: ""
  // },
  state:initState,
  getters: {
  },
  mutations: {
    // 更新 tokenInfo 数据的方法
    updateAuthorizationInfo(state, authorization) {
      
      // 把提交过来的 payload 对象，作为 tokenInfo 的值
      state.authorization = authorization
      // state.abc="3"
      // 测试 state 中是否有数据
      console.log("打印state中")
      console.log(state)
      // 存入本地中
      // 如果希望在 Mutation A 中调用 Mutation B，需要通过 this.commit() 方法来实现
      // this 表示当前的 new 出来的 store 实例对象
      this.commit('saveStateAuthToStorage')
    },
    // 将 state 持久化存储到本地 存储token
    saveStateAuthToStorage(state) {
      localStorage.setItem('authorization', JSON.stringify(state.authorization))
      // localStorage.setItem('abc', JSON.stringify(state.abc))
    }
  },
  actions: {
  },
  modules: {
  }
})

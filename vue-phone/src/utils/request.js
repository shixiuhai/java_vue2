// 1、export default 向外暴露的成员，可以使用任意变量来接收

// 2、在一个模块中，export default 只允许向外暴露一次

// 3、在一个模块中，可以同时使用export default 和export 向外暴露成员

// 4、使用export向外暴露的成员，只能使用{ }的形式来接收，这种形式，叫做【按需导出】

// 5、export可以向外暴露多个成员，同时，如果某些成员，在import导入时，不需要，可以不在{ }中定义

// 6、使用export导出的成员，必须严格按照导出时候的名称，来使用{ }按需接收

// 7、使用export导出的成员，如果想换个变量名称接收，可以使用as来起别名
import axios from 'axios'

// 调用 axios.create() 方法，创建 axios 的实例对象
const instance = axios.create({
  // 请求根路径
  baseURL: 'http://192.168.1.3:8081/api'
})

export default instance



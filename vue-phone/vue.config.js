const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,

});



//配置默认标题
// module.exports = {
//   pages: {
//     index: {
//       entry: "src/main.js",
//       title: "你",
//     },
//   },
// }

// 设置vue2代理，解决接口跨域问题
module.exports={
  devServer:{
      // host:'192.168.1.3',
      port:"8081", // 设置端口 默认8080
      https: false,
      // open:true, // 项目运行自动打开浏览器 偷懒一波
      // 在与port open 设置服务代理
      proxy:{
          // /api 自定义服务代理名字
          "/api":{
              target:"http://localhost:8080", //代理帮助你请求的具体服务
              changeOrign:true, // 开启代理
              pathRewrite:{  // 格式化path 
                  "^/api":""
              }
          }
      }
  }
}


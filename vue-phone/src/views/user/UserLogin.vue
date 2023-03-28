
<template>
    <div class="login-container">
      <!-- NavBar 组件：只需提供 title 标题 -->
      <van-nav-bar title="视频网站 - 登录" fixed />
      <br>
      <br>
      <br>

      <div class="img">
        <van-image
                    round
                    width="6rem"
                    height="6rem"
                    src="https://img01.yzcdn.cn/vant/cat.jpeg"
                    text-align: center
                
            />
        </div>
        <br>
        <br>
      <br>

        
      <!-- 登录的表单 -->
      <van-form @submit="login">
                <van-field v-model="form.username"   type="user" label="用户名" placeholder="请输入用户名"  :rules="[{ required: true, message: '请输入正确内容' }]"></van-field>
                <br>
                <van-field v-model="form.password"  type="password" label="登录密码" placeholder="请输入登录密码"  :rules="[{ required: true, message: '请填写密码' }]"></van-field>
                <br>
                <div style="margin: 16px;">
                    <van-button round block type="info" native-type="submit">提交</van-button>
                </div>
                <br>
        </van-form>
        <div class="reg" >
                    <div @click="toRegister" style="font-size: 14px;">没有账号？立即注册</div>
        </div> 
        

       
    </div>
        

</template>
<script>
// 导入vux里的相关
// https://blog.csdn.net/qq_41983641/article/details/113246418 mapMutations相关使用
// vue组件传值方式
import { mapMutations } from 'vuex'

// 导入登陆相关接口

import {captchaAPI,loginAPI} from "@/api/user/userLogin"
import router from "@/router/index"
export default {
    name:"UserLogin",
    data(){
        return {
            // 登录表单的数据，最终要双向绑定到 form 这个数据对象上
            form: {
                // 用户的手机号
                username: 'admin',
                // 登录的密码
                password: '111111',
                // 登陆平台
                code:"phone",
                // 获取jwt认证的toekn
                token:''
                
            },

            
        }
    },
    // 所有涉及调用接口的都必须 async + await
    methods:{
        // 2. 映射 mutations 中存储token的方法
        ...mapMutations(['updateAuthorizationInfo']),
        // getcaptcha是非异步接口
        // 获取验证码接口拿到token
        async getcaptcha(){
            // 接口没有传值括号是否可以省略需要验证一下
            // {data:res} 含义指将返回的结果data重命名为res
            const {data:res}= await captchaAPI()
            return res

        },
        // 用户登陆 所有调用js函数的方法都必须 async+await
        async login(){
            const captcha= await this.getcaptcha()
            // console.log("-----------")
            // console.log(captcha.data.token)
            // console.log("-----------")

            this.form.token= captcha.data.token
            // console.log(this.form.token)
            // console.log(this.token)
            // console.log(this.form.username,this.form.password,this.form.code,this.form.token)
           
            const loginResp =  await loginAPI(this.form)
            console.log(loginResp)
            // 判断是否登陆成功
            // loginResp.data 这个是vue前端默认返回的数据路经
            if(loginResp.data.code==200){
                // console.log(res)
                console.log("登陆成功")
                console.log(loginResp.headers["authorization"])
                // 3. 把获取到的authorization，存储到 vuex 中
                this.updateAuthorizationInfo(loginResp.headers["authorization"])
                // 跳转页面
                router.push("/")
                // 4. 登陆成功后调转到首页
                // https://zhuanlan.zhihu.com/p/86116684 跳转传值方案


            }
            

        },
        toRegister(){
            console.log("跳到注册页面")
        }

    }
}

</script>

<style lang="less" scoped>
    .login-container {
        padding-top: 46px;
    }
    // 设置标题居中
    .title {
        /* border-radius: 15px; */
        size:1px;
        height: 50px;
        line-height: 50px;
        background-color: #20a0ff;
        color: #fff;
        text-align: center;
    }
    // 设置注册居中
    .reg {
        text-align: center;
    }
    // 设置图片居中
    .img {
        text-align: center;
    }

</style>

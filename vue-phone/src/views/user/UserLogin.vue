
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

// 导入登陆相关接口
import {captchaAPI,loginAPI} from "@/api/user/userLogin";
export default {
    name:"UserLogin",
    data(){
        return {
            // 登录表单的数据，最终要双向绑定到 form 这个数据对象上
            form: {
                // 用户的手机号
                username: '',
                // 登录的密码
                password: '',
                // 登陆平台
                code:"phone",
                // 获取jwt认证的toekn
                token:''
                
            },

            
        }
    },
    methods:{
        // getcaptcha是非异步接口
        // 获取验证码接口拿到token
        getcaptcha(){
            // 接口没有传值括号是否可以省略需要验证一下
            // {data:res} 含义指将返回的结果data重命名为res
            const {data:res}=captchaAPI()
            return res

        },
        // 用户登陆
        async login(){
            this.form.token= (await captchaAPI()).data.data.token
            // console.log(this.token)
            console.log(this.form.username,this.form.password,this.form.code,this.form.token)
           
            const {data:res} =  await loginAPI(this.form)
            console.log(res)
            

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

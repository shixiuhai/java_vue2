<template>
    <div class="login-container">
        <van-form @submit="login">
            <van-field v-model="form.username" type="user" label="用户名" placeholder="请输入用户名" required></van-field>
            <van-field v-model="form.password" type="password" label="登录密码" placeholder="请输入登录密码" required></van-field>
            <div style="margin: 16px;">
                <van-button round block type="info" native-type="submit">提交</van-button>
            </div>
        </van-form>
        <van-nav-bar title="登录" fixed />
    
    </div>
       
</template>
<script>
// 导入登陆相关接口
import {captchaAPI,} from "@/api/user/userLogin";
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
                code:'phone',
                // 获取jwt认证的toekn
                token:''
                
            },

            
        }
    },
    methods:{
        // 获取验证码接口拿到token
        async getcaptcha(){
            // 接口没有传值括号是否可以省略需要验证一下
            // {data:res} 含义指将返回的结果data重命名为res
            const {data:res}=captchaAPI()
            return res

        },
        // 用户登陆
        login(){
            console.log("ok")

        }

    }
}

</script>

<style lang="less" scoped>
    .login-container {
        padding-top: 46px;
    }
    // 覆盖 NavBar 组件的默认样式
    .van-nav-bar {
        background-color: #007bff;
    .van-nav-bar__title {
        color: white;
        font-size: 14px;
    }
    }
</style>

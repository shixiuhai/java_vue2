import request from "@/utils/request.js"
// https://blog.csdn.net/weixin_46522411/article/details/112155522 request食用方法
// 调用获取验证码token接口
export const captchaAPI=()=>{
    return request.get("/captcha")
}
// 调用登陆接口
export const loginAPI =(username,password)=>{
    return request.post("/login",{
        username:username,
        password:password
        
    })
    
}

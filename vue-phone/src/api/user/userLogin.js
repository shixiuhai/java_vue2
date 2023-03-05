import request from "@/utils/request.js"
import qs from 'qs'
// https://blog.csdn.net/weixin_46522411/article/details/112155522 request食用方法
// https://blog.csdn.net/weixin_44463231/article/details/126352070 post body和query传值
// 调用获取验证码token接口
export const captchaAPI=()=>{
    //return request.get("/captcha")
    return request({
        method:"get",
        url:"/captcha"
    })
}
// 调用登陆接口
export const loginAPI =(form)=>{
    //return request.post("/login?"+qs.stringify(form))
    return request({
        method:"post",
        url:"/login?"+qs.stringify(form)
    })
    
}


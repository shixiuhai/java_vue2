import request from "@/utils/request.js"

// 获取解析链接接口
export const getParseLinkAPI=() => {
    return request.get("/videoParse")
}
// 获取视频链接
export const getVideoUrlAPI=(videoId) => {
    return request.get("/videoNumber",{
        params:{
            videoId:videoId
        }
    })
}
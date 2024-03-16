import request from "@/utils/request"
// 获取单个视频详细信息
export const getVideoDetailAPI=(videoId)=>{
    return request({
        method:"get",
        url:"/videoDetail",
        params:{
            informationId:videoId
        }
    })


}
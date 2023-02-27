import request from "@/utils/request.js"
// 方式二
//import request  from "@/utils/request"
// 获取视频信息接口
export const getVideoInformationAPI = (videoName,startTime,endTime,type,area,page,pageSize) => {
    return request.get('/videoInformation', {
      params: {
        videoName: videoName,
        startTime: startTime,
        endTime: endTime,
        type: type,
        area: area,
        page:page,
        pageSize:pageSize
      }
    })

  }
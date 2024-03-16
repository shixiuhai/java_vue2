import request from "@/utils/request"
// 获取字典的type和name的方法
export const getDicAPI=(dicName)=>{
    return request({
        method:"get",
        url:"/sysDict",
        params:{
            dicName:dicName
        }

    })

}

export const listVideoAPI=(page)=>{
    return request({
        method:"get",
        url:"/videoInformation",
        params:{
            page:page
        }

    })

}



<!-- 展示电影列表 -->
<template>
    <div>
        <!-- 这是电影列表展示组件 -->    
        <!-- 展示视频内容 -->
        <van-grid :column-num="2" square>
            <!-- 用在标签里的val不需要{{}} -->
            <van-grid-item v-for="item in res.data.records" :key="item.id"  v-model="videoInformation"  >
                <!-- 实现图片对页面的跳转 -->
                <van-image @click="jumpDetail(item.id)" :src=item.videoImg  with="120" height="130" ></van-image>
                <!-- 进行链接跳转到新页面进行页面渲染 -->
                <div @click="jumpDetail(item.id)"  class="classLink" >{{item.videoName}}</div>
                <!-- <div>描述 {{items[value-1]["src"]}}</div> -->
            </van-grid-item>   
        </van-grid>
        <!-- 翻页实现 -->
        <van-pagination v-model="currentPage" :page-count=totalPage mode="simple" />
    </div>
</template>
<!-- 写模板 -->
<style lang='less' scoped>
    // 设置超过宽度设置为涉略号
    .classLink {
        width:100px;
        align-items: center;
        white-space:nowrap;
        text-overflow:ellipsis;
        -o-text-overflow:ellipsis;
        overflow: hidden;
        font-size: 15px;

    }
</style>
<script>
    

    // 实现兄弟组件间共享数据
    // 实现子组件间共享数据
    import bus from './eventBus.js'
    export default{
        // 定义组件名称，这个名称随意命名，只有保证有两个大写字符
        name: 'VLV',
        // 定义数据
        data(){
            return {
                // 当前页面
                currentPage:1,
                totalPage:12,
                // 定义一个填充页面信息的对象
                videoInformation:{},
                // 接收到电影数据对象        
                res:{
                },
                // 分页查询数据
            }
        },
        
        // 写方法
        methods:{
            // 翻页方法
            setupPage() {
                this.currentPage = this.res.data.current
                this.totalPage= this.res.data.total
                // 翻页将数据发送给search
                bus.$emit("pageSize",this.currentPage)
                console.log("打印")
                
            },
            // 跳转到详情页面并带上参数
            jumpDetail(id){
                let videoId=id
                console.log("页面跳转"+id)
                this.$router.push({
                name: "videoDetail", // ⚠️注：这里不能用path路径，只能用name【请对照router.js中的路由规则中的name项】，否则取不到传过去的数据
                params: {
                    videoId:videoId
                    
                }
                })
            },
            

           

        },
        created() {
            // 接收来着SearchView兄弟组件的信息
            bus.$on("videoInformation",val=>{
                this.res=val
                // console.log("触发了")
                // console.log(this.res)
            }),
            this.setupPage()
            
        },
        // 将其他vue页面渲染到本页面
        components:{
  
}


        
    }
</script>


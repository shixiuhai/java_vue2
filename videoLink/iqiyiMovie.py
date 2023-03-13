
import requests
import time
# from OperateMysql.ClassModel import OperateMysql
def get_iqy():

    headers = {
        'authority': 'pcw-api.iqiyi.com',
        'method': 'GET',
        'path': '/search/recommend/list?channel_id=1&data_type=1&mode=11&page_id=3&ret_num=48&session=cc6d98d2721309e98c4a1159aa18dcf7&three_category_id=6;must',
        'scheme': 'https',
        'accept': '*/*',
        'accept-encoding': 'gzip, deflate, br',
        'accept-language': 'zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6',
        'content-type': 'application/x-www-form-urlencoded',
        'cookie': 'QC005=6546416f48123467d3d93e7f15ecb4b6; QC006=9c90c94a022c1bec273cb8cfd169069b; T00404=e8a234db2adc5496bbcff3ff0d20cced; P00004=.1661346683.0f138c97aa; QP0030=1; TQC030=1; QC160=%7B%22type%22%3A2%2C%22conformLoginType%22%3A0%7D; QC170=1; QC173=0; QP0034=%7B%22v%22%3A1%2C%22dm%22%3A%7B%22pr%22%3A1%2C%22wv%22%3A1%7D%2C%22m%22%3A%7B%22wm-vp9%22%3A1%7D%7D; QIYUECK=qy_pc_27b25d16840346e3ad37be633cc29e9e; QC175=%7B%22upd%22%3Atrue%2C%22ct%22%3A%22%22%7D; QP008=0; QP0035=2; QC142=80b7689706789f44; QC021=%5B%7B%22key%22%3A%22%E4%BD%A0%E5%A5%BD%22%7D%2C%7B%22key%22%3A%22%E8%8B%8D%E5%85%B0%E8%AF%80%22%7D%5D; QP0027=17; T00700=EgcI9L-tIRABEgcI58DtIRABEgcIq8HtIRABEgcIrcHtIRABEgcI8L-tIRABEgcIz7-tIRABEgcI67-tIRADEgcIkMDtIRABEgcIg8DtIRABEgcI0b-tIRABEgcI4b-tIRABEgcIhcDtIRABEgcIi8HtIRADEgcI87-tIRABEgcI7L-tIRABEgcImMDtIRABEgcI57-tIRABEgcIisHtIRAB; QC159=%7B%22color%22%3A%22FFFFFF%22%2C%22channelConfig%22%3A1%2C%22hideRoleTip%22%3A1%2C%22speed%22%3A10%2C%22density%22%3A40%2C%22opacity%22%3A86%2C%22isFilterColorFont%22%3A1%2C%22isOpenMask%22%3A0%2C%22proofShield%22%3A0%2C%22forcedFontSize%22%3A24%2C%22isFilterImage%22%3A1%2C%22defaultSwitch%22%3A0%2C%22isOpen%22%3A1%2C%22hadTip%22%3A1%7D; QP007=180; QP0036=202296%7C99.139; QC008=1661346681.1662466806.1662558810.9; QC189=5029_B%2C4580_B%2C1550_B%2C4861_B%2C4498_B%2C1707_B%2C4824_A%2C4863_B%2C4862_B%2C4864_B%2C5006_C; nu=0; QP0037=0; QC186=false; websocket=true; Hm_lvt_53b7374a63c37483e5dd97d78d9bb36e=1662392953,1662394570,1662558833; Hm_lpvt_53b7374a63c37483e5dd97d78d9bb36e=1662558833; QC010=267634698; IMS=IggQABj__-KYBioyCiAzZjVkODZiNDA1MjkyNWFjYTk3MmI0M2M5MGEyZDliZRAAIggI0AUQAhiwCSg8MAVyJAogM2Y1ZDg2YjQwNTI5MjVhY2E5NzJiNDNjOTBhMmQ5YmUQAIIBAIoBJAoiCiAzZjVkODZiNDA1MjkyNWFjYTk3MmI0M2M5MGEyZDliZQ; QC187=true; QC007=https%2525252525253A%2525252525252F%2525252525252Fcn.bing.com%2525252525252F; __dfp=a0235ece985ae14efe814de6122e536bc6b46c52e4546eb3b3ba856b228a5744c5@1662642681791@1661346682791',
        'origin': 'https://list.iqiyi.com',
        'referer': 'https://list.iqiyi.com/www/1/-6------------11-1-1-iqiyi--.html?s_source=PCW_SC',
        'sec-ch-ua': '"Microsoft Edge";v="105", " Not;A Brand";v="99", "Chromium";v="105"',
        
        'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36 Edg/105.0.1343.27'
    }
    """
    """
    for i in range(11, 500):         #循环1-136 第137 json 是空的 也就是全部爬完
        try:
            url_0 = "https://pcw-api.iqiyi.com/search/recommend/list?channel_id=1&data_type=1&mode=11&page_id="
            url_0 = url_0 + str(i) + "&ret_num=48&session=2e9d98658b8d4f1d54ef227b03019500"
            print(url_0)        #输出拼接好的url
            response = requests.get(url=url_0, headers=headers).json()
            # print(response)
            # print(response)
            if(response["code"]=='A00000'):
                responseMovieList=response['data']['list']
                # 遍历每页每部电影对象
                for item in responseMovieList:
                    try:
                        videoName=item["name"]
                        videoImg=item["imageUrl"]
                        releaseTime=item["period"]
                        # releaseTime="2022-08-27 18:01:20"
                        videoType=10
                        videoArea=1
                        videoEpisodes=1
                        videoDirector=""
                       
                        videoStarring=""
                        for people in item["people"]["main_charactor"]:
                            videoStarring= videoStarring+ people["name"]+","
                        videoStarring=videoStarring[:-1:]

                        videoIntroduction=item["description"]
                        try:
                            videoScore=item["score"]
                        except :
                            videoScore=0
                        videoUrl=item["playUrl"]
                        print(videoUrl,videoName,videoImg)

                        # #  插入前做个删除
                        # videoInformationIdList=OperateMysql(host=host,user=user,password=password,database=database).\
                        # selectData("select id from video_information where video_name='%s' order by id desc"%videoName)
                        # if len(videoInformationIdList)!=0:
                        #     videoInformationId=videoInformationIdList[0]
                        #     videoNumberId=OperateMysql(host=host,user=user,password=password,database=database).\
                        #     selectData("select id from video_number where video_information_id='%s' order by id desc"%videoInformationId)[0]


                        #     OperateMysql(host=host,user=user,password=password,database=database).\
                        #     insertData("delete from video_information where video_name='%s'"%videoName)
            
                        #     OperateMysql(host=host,user=user,password=password,database=database).\
                        #     insertData("delete from video_number where video_information_id='%s'"%videoInformationId)

                        #     OperateMysql(host=host,user=user,password=password,database=database).\
                        #     insertData("delete from video_information_url where video_number_id='%s'"%videoNumberId)
                        
                        
                        # # 对电影数据进行入库处理
                        # # 1. 先插入到videoInformation表中
                        # OperateMysql(host=host,user=user,password=password,database=database).\
                        # insertData("replace into video_information \
                        # (video_name,video_img,release_time,type,\
                        # area,episodes,director,starring,introduction,score) \
                        # values (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)"
                        # ,(videoName,videoImg,releaseTime,videoType,videoArea,
                        # videoEpisodes,videoDirector,videoStarring,videoIntroduction,videoScore))
                        # # print(videoStarring)
                        # # 2. 插入到集数表中
                        # # 插叙一下刚刚插入的id
                        # videoInformationId=OperateMysql(host=host,user=user,password=password,database=database).\
                        # selectData("select id from video_information where video_name='%s' order by id desc"%videoName)[0]

                        # # 插入
                        # OperateMysql(host=host,user=user,password=password,database=database).insertData("insert into video_number (video_information_id,video_number) values (%s,%s)",(videoInformationId,1))

                        # # 3. 插入到链接表中
                        # # 先查询一下number_id
                        # videoNumberId=OperateMysql(host=host,user=user,password=password,database=database).\
                        # selectData("select id from video_number where video_information_id='%s' order by id desc"%videoInformationId)[0]
                        # # 插入
                        # OperateMysql(host=host,user=user,password=password,database=database).insertData("insert into video_information_url(video_number_id,video_url) values (%s,%s)",(videoNumberId,videoUrl))
                        # time.sleep(3)
                        # print(videoName)
                    except:
                        continue
        except:
            time.sleep(10)
            continue


                

            #     print(videoName)
            # time.sleep(200)


if __name__ == "__main__":
    host="127.0.0.1"
    user="root"
    password="sxh.200008"
    database="video"
    get_iqy()
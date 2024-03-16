
import requests

# 纯净解析 https://z1.m1907.cn/?jx=，可以通过这个获取视频集数相关信息
def m1907Parse(videoLink):
    params={
        'z': 'e090d9a71dfabaeefd49ff1c6afcdfae',
        'jx': videoLink,
        's1ig': '11397'
    }
    res=requests.get(url='https://a1.m1907.cn:404/api/v/?', params=params,headers=headers).json()
    print(res)

# b站解析 https://jx.bozrc.com:4433/player/?url=

# vip解析 https://player.maqq.cn/?url=https://ukzy.ukubf3.com/20220801/HJ5rrqwg/index.m3u8

# m3u8解析 https://jx.m3u8.tv/jiexi/?url=
# 解析 https://api.jiexi.la/?url=
# 视频解析接口 https://www.nxflv.com/?url=
def test():
    print(requests.get("https://www.nxflv.com/?url=https://www.iqiyi.com/v_ik3832z0go.html?vfrm=pcw_home&vfrmblk=712211_cainizaizhui&vfrmrst=712211_cainizaizhui_image3").text)
if __name__ == '__main__':
    headers={
    'authority': 'a1.m1907.cn:404',
    'method': 'GET',
    'accept-encoding': 'gzip, deflate, br',
    'accept-language': 'zh-CN,zh;q=0.9',
    'origin': 'https://z2.m1907.cn:404',
    'referer': 'https://z2.m1907.cn:404/',
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36'
    }
    m1907Parse("https://www.iqiyi.com/v_2crptmjxnjo.html?vfrm=pcw_dianshiju&vfrmblk=G&vfrmrst=711219_dianshiju_iqyzzj_pic_play5")
    # getA()
    # test()
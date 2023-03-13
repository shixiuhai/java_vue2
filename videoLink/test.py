import requests
headers={
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36 Edg/105.0.1343.27'
}
r=requests.get(url="https://www.iqiyi.com/v_2ffkwsy3h6k.html?vfrm=pcw_category_lib_2&vfrmblk=D&vfrmrst=1_1",headers=headers).text.encode('utf-8')
with open('1.txt','w') as f:
    f.write(r)
    
    print(r)
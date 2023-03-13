import pymysql
"""封装对mysql进行处理的类"""
class  OperateMysql():
    # 定义一共初始化的函数
    # selectReturnType 默认返回一个字段，如果需要返回多个字段，则设置为list
    def __init__(self,host,user,password,database,selectReturnType='one') -> None:
        self.host=host
        self.user=user
        self.password=password
        self.database=database
        self.selectReturnType=selectReturnType
        # 创建对象连接
        self.db=pymysql.connect(host=self.host,user=self.user,password=self.password,database=self.database)
        # 创建连接数据库游标
        self.cursor=self.db.cursor()
        # print("mysql数据库连接成功")
    # 定义一个数据插入的方法
    def insertData(self,sql,data=None):
        # 插入数据的时候需要做提交到数据库的动作
        # 执行sql语句
        self.cursor.execute(sql,data)
        # 提交到数据库
        self.db.commit()
        # 关闭数据库连接
        self.closeConnect()
    # 定义一个查询数据的方法
    def selectData(self,sql):
        results_list=[]
        # 执行sql语句
        self.cursor.execute(sql)
        # 获取所有列表记录
        results=self.cursor.fetchall()
        if self.selectReturnType=='one':
            for row in results:
                # 添加实际上真正存在的元素
                results_list.append(row[0])
        elif self.selectReturnType=='list':
            for row in results:
                # 添加实际上真正存在的元素
                results_list.append(row)

        # 关闭数据库连接
        self.closeConnect()
        return results_list
    # 定义一个更新数据的方法
    def updateData(self,sql):
        # 执行sql语句
        self.cursor.execute(sql)
        # 提交到数据库
        self.db.commit()
        # 关闭连接
        self.closeConnect()
    # 定义一个关闭数据库连接的方法
    def closeConnect(self):
        self.cursor.close()
        self.db.close()


if __name__ == '__main__':
    pass
    # res=OperateMysql(host='10.8.0.42',user='root',password='Gttx@2020',database='push').selectData("select company_Id from  business_task_warning where id=60066")
    # print(res)
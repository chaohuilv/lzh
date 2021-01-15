# lzh
##外部接口地址
#1、接口地址:域名+/webservice/powerService?wsdl
1)、在pom.xml中添加: 
```xml
<dependency>
    <groupId>org.apache.cxf</groupId>
    <artifactId>cxf-spring-boot-starter-jaxws</artifactId>
    <version>3.2.4</version>
</dependency>
```


2、调用方式如:
```java
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
public class WebService{
    JaxWsDynamicClientFactory dcflient=JaxWsDynamicClientFactory.newInstance();
    Client client=dcflient.createClient("http://127.0.0.1:6702/webservice/powerService?wsdl");
    try{
        Object[] objects=client.invoke("GetDept","2020-03-18",1,10);
        System.out.println("getDept 调用结果："+objects[0].toString());
    }catch (Exception e){
        e.printStackTrace();
    }
}
```


#2部门接口地址: GetDept 
参数 | 备注 
---- | ---
update | 时间默认当前系统时间，如果需要查询所有数据可以将时间设置位1990-01-01
page | 当前页数,从1开始
size | 每页行数，默认10

返回值:

字段值 | 类型 | 备注
--- | --- | ---
code | Int | 状态码
msg	| String | 状态信息
total | Int | 总条数
Data | 数组 | 部门信息集合
    id | String | 主键
    parentid | String | 父键
    code | String | 部门编号
    name | String | 部门名称
    longcode | String | 长编码，记录二叉树信息
    sequ | Int | 序号
    upddate | Date | 时间
    epsprojid | String | 公司id
    ownprojname | String | 公司名称
```json
{
    "code": 0,
    "msg": "成功",
    "data": [
        {
            "id": "EA480EAC-0190-43FF-8333-C48B1546FB9D",
            "parentid": "D0B018F0-9EEF-4697-8272-6F5171867183",
            "code": "NMGCHE.BM.04",
            "name": "察哈尔-党群工作部",
            "longcode": "1.5",
            "sequ": "5",
            "upddate": "2020-05-11 02:17:57.0",
            "epsprojid": "00000000-0000-0000-0000-0000000000A4",
            "ownprojname": "内蒙古察哈尔新能源有限公司"
        }
    ],
    "total": 12
}
```


#3岗位接口地址: GetPosition
参数 | 备注 
---- | ---
update | 时间默认当前系统时间，如果需要查询所有数据可以将时间设置位1990-01-01
page | 当前页数,从1开始
size | 每页行数，默认10
  
返回值:

字段值 | 类型 | 备注
--- | --- | ---
code | Int | 状态码
msg	| String | 状态信息
total | Int | 总条数
Data | 数组 | 岗位信息集合
    id | String | 主键
    parentid | String | 父键
    code | String | 岗位编号
    name | String | 岗位名称
    longcode | String | 长编码，记录二叉树信息
    sequ | Int | 序号
    upddate | Date | 时间
    epsprojid | String | 公司id
    ownprojname | String | 公司名称

```json
{
  "code": 0,
  "msg": "成功",
  "data": [
      {
          "parentid": "9BB1E901-260A-4DD7-9C40-CABC4B54D149",
          "code": "NMGCHE.GW.08.03",
          "name": "察哈尔-工程二部电气一次管理专责",
          "longcode": "1.434.456",
          "deptid": "946184FA-EAAD-4FE2-AE12-194064FA1471",
          "upddate": "2020-05-26 10:31:35.0",
          "epsprojid": "00000000-0000-0000-0000-0000000000A4",
          "ownprojname": "内蒙古察哈尔新能源有限公司",
          "id": "AB5A1517-72E4-411E-9AD6-25665222FFE6"
      }
  ],
  "total": 80
}
```


#4 人员接口地址: GetUser
参数 | 备注 
---- | ---
update | 时间默认当前系统时间，如果需要查询所有数据可以将时间设置位1990-01-01
page | 当前页数,从1开始
size | 每页行数，默认10

返回值:

字段值 | 类型 | 备注
--- | --- | ---
code | Int | 状态码
msg	| String | 状态信息
total | Int | 总条数
Data | 数组 | 人员信息集合
    id | String | 主键
    code | String | 人员编号
    name | String | 人员名称
    deptid | String | 部门id
    posiid | String | 岗位id
    upddate | Date | 时间
    mobile | String | 手机号码
```json
{
   "code": 0,
   "msg": "成功",
   "data": [
       {
           "id": "6D9DF0F7-829C-4DC1-A45B-0913485A515A",
           "code": "15101617800",
           "name": "张适",
           "deptid": "5E58F9BB-1365-4968-BE8C-EB526949EFFF",
           "posiid": "D8EAA2D2-91E7-42B0-A933-FDC8741A9ABD",
           "upddate": "2020-06-15 08:42:14.0",
           "mobile": "15101617800"
       }
   ],
   "total": 264
}
```


##对内接口
#1单点登录接口:
1)、不重定向地址:接口地址:域名+/exam/login。接口类型为Get

参数 | 备注 
---- | ---
code | 人员编号

返回值:

字段值 | 类型 | 备注
---- | --- | ---
code | Int | 状态码
msg | String | 状态信息
total | Int | 总条数
data | String | 登录地址

```json
{
    "code": 0,
    "msg": "成功",
    "data": "https://api.kaoshixing.com/api/company/data/14343/?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1OTYwMjU5MjE4NTgsImFjdGlvbl9pZCI6IjIwMSJ9.yTqbfgWViM4emuQvXw8XcU7AgDgLFPQRA8NZYgCOfJ8",
    "total": null
}
```

2)、重定向地址:接口地址: 域名+/exam/authorize。接口类型为Get

备注：通过redirect自动重定向。

参数 | 备注 
---- | ---
code | 人员编号

#2、获取考试成绩接口
1)、接口地址: 域名+/exam/achievement。接口类型为Get

将数据直接写入到表WLCB_ExamResult中。

参数 | 备注 
---- | ---
code | 不传获取所有人员的考试结果信息，传递获取当前人员考试信息，code人员编号

参数 | 备注 
---- | ---
code | 人员编号

返回值:

字段值 | 类型 | 备注
---- | --- | ---
code | Int | 状态码
msg | String | 状态信息
total | Int | 总条数
data | String | 数据信息
```json
{
    "code": 0,
    "msg": "成功",
    "data": null,
    "total": null
}
```




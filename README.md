# douyin
抖音短视频无水印解析

使用前需要安装maven

```shell
在pom目录下执行 
mvn package
cd target/
java -jar douyin-0.0.1-SNAPSHOT.jar &
```
即可部署，默认端口为9600

example: 
```
POST localhost:9600/douyin/parser
param: url: https://www.iesdouyin.com/share/video/6557227448084204804/?region=CN&mid=6557227625809611523&titleType=title&utm_source=copy_link&utm_campaign=client_share&utm_medium=android&app=aweme&iid=33404473122&timestamp=1527213871
```
```json
result: {"msg":"success","data":{"brgUrl":"https://p9.pstatp.com/large/85020005f5a6746af4a7.jpg","playUrl":"https://aweme.snssdk.com/aweme/v1/play/?video_id=v0200ff50000bbvv77uue3mhdhd0tj1g&line=0"},"code":200}
```

已经搭建好的网站 <a href="https://douyin.blingfeng.cn"> https://douyin.blingfeng.cn</a>

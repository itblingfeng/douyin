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
POST localhost:9600/parser
param: url: http://v3-dy.ixigua.com/4ed18c7ba2fd917baaf3669e7fa9faa8/5b077d6c/video/m/220ee41c4c92516499889486e160918a09a11571c5f00006be6e7716028/
```
```json
result: {"msg":"success","data":{"brgUrl":"https://p9.pstatp.com/large/85020005f5a6746af4a7.jpg","playUrl":"https://aweme.snssdk.com/aweme/v1/play/?video_id=v0200ff50000bbvv77uue3mhdhd0tj1g&line=0"},"code":200}
```

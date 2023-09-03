# ordinaryroad-bilibili-live-example

## ⚠️⚠️⚠️ 项目已重构（API不变，v0.0.9为最后一个版本），已支持Bilibili、Douyu，传送门：[ordinaryroad-live-chat-client](https://github.com/OrdinaryRoad-Project/ordinaryroad-live-chat-client)，有问题欢迎[提交issuse](https://github.com/OrdinaryRoad-Project/ordinaryroad-live-chat-client/issues)，觉得有用的话可以点个小星星⭐️鼓励一下，感谢

## 1 配置

```yaml
tech:
  ordinaryroad:
    bilibili:
      live:
        client:
          config:
            # TODO 修改房间id
            roomId: 7777
            # TODO 修改Cookie
            cookie: ${cookie:}
```

## 2 LiveChatClientController

> 连接
> http://localhost:8080/client/connect

> 断开链接
> http://localhost:8080/client/disconnect/false
>
> 断开链接（取消此次的自动重连）
> http://localhost:8080/client/disconnect/true

> 修改房间id
> http://localhost:8080/client/roomId/{roomId}

> 禁用自动重新连接
> http://localhost:8080/client/autoReconnect/false
>
> 启用自动重新连接
> http://localhost:8080/client/autoReconnect/true

## 支持同时监听多个直播间

> http://localhost:8080/client/multiply/newClientAndStart/7777
> http://localhost:8080/client/multiply/newClientAndStart/6
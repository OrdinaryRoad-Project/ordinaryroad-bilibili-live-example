# ordinaryroad-bilibili-live-demo

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
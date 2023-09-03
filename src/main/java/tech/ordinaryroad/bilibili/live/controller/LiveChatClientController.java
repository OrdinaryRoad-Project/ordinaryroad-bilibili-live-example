package tech.ordinaryroad.bilibili.live.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ordinaryroad.live.chat.client.bilibili.client.BilibiliLiveChatClient;

/**
 * @author mjz
 * @date 2023/8/21
 */
@RestController
@RequestMapping("client")
public class LiveChatClientController {

    @Autowired
    private BilibiliLiveChatClient client;

    @GetMapping("connect")
    public void connect() {
        client.connect();
    }

    @GetMapping("autoReconnect/{autoReconnect}")
    public void autoReconnect(@PathVariable Boolean autoReconnect) {
        client.getConfig().setAutoReconnect(autoReconnect);
    }

    @GetMapping("roomId/{roomId}")
    public void roomId(@PathVariable Long roomId) {
        client.getConfig().setRoomId(roomId);
    }

    @GetMapping("disconnect/{cancelReconnect}")
    public void disconnect(@PathVariable Boolean cancelReconnect) {
        client.disconnect(cancelReconnect);
    }

}

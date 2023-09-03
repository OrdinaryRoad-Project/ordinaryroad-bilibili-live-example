package tech.ordinaryroad.bilibili.live.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ordinaryroad.live.chat.client.bilibili.client.BilibiliLiveChatClient;
import tech.ordinaryroad.live.chat.client.bilibili.config.BilibiliLiveChatClientConfig;
import tech.ordinaryroad.live.chat.client.bilibili.listener.IBilibiliConnectionListener;
import tech.ordinaryroad.live.chat.client.bilibili.listener.IBilibiliSendSmsReplyMsgListener;

/**
 * @author mjz
 * @date 2023/8/21
 */
@RestController
@RequestMapping("client/multiply")
public class MultiplyLiveChatClientController {

    @Autowired
    private IBilibiliSendSmsReplyMsgListener bilibiliSendSmsReplyMsgListener;
    @Autowired
    private IBilibiliConnectionListener bilibiliConnectionListener;

    @GetMapping("newClientAndStart/{roomId}")
    public void newClientAndStart(@PathVariable Long roomId) {
        BilibiliLiveChatClientConfig config = BilibiliLiveChatClientConfig.builder()
                .roomId(roomId)
                .build();
        new BilibiliLiveChatClient(config, bilibiliSendSmsReplyMsgListener, bilibiliConnectionListener)
                .connect();
    }

}

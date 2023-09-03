package tech.ordinaryroad.bilibili.live.config;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import tech.ordinaryroad.live.chat.client.bilibili.client.BilibiliLiveChatClient;
import tech.ordinaryroad.live.chat.client.bilibili.listener.IBilibiliConnectionListener;
import tech.ordinaryroad.live.chat.client.bilibili.listener.IBilibiliSendSmsReplyMsgListener;

/**
 * @author mjz
 * @date 2023/8/21
 */
@Component
public class BilibiliLiveChatClientConfiguration {

    @Resource
    private BilibiliLiveConfigurations configurations;

    @Resource
    private IBilibiliSendSmsReplyMsgListener bilibiliSendSmsReplyMsgListener;

    @Resource
    private IBilibiliConnectionListener bilibiliConnectionListener;

    @Bean
    public BilibiliLiveChatClient bilibiliLiveChatClient() {
        return new BilibiliLiveChatClient(configurations.getConfig(), bilibiliSendSmsReplyMsgListener, bilibiliConnectionListener);
    }

}

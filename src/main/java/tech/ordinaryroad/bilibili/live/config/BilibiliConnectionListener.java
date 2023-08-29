package tech.ordinaryroad.bilibili.live.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.ordinaryroad.bilibili.live.listener.IBilibiliConnectionListener;
import tech.ordinaryroad.bilibili.live.netty.handler.BilibiliConnectionHandler;

/**
 * @author mjz
 * @date 2023/8/21
 */
@Slf4j
@Service
public class BilibiliConnectionListener implements IBilibiliConnectionListener {

    @Override
    public void onConnected(BilibiliConnectionHandler connectionHandler) {
        log.info("{} onConnected", connectionHandler.getRoomId());
    }

    @Override
    public void onConnectFailed(BilibiliConnectionHandler connectionHandler) {
        log.info("{} onConnectFailed", connectionHandler.getRoomId());
    }

    @Override
    public void onDisconnected(BilibiliConnectionHandler connectionHandler) {
        log.info("{} onDisconnected", connectionHandler.getRoomId());
    }
}

package tech.ordinaryroad.bilibili.live.config;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.ordinaryroad.bilibili.live.constant.CmdEnum;
import tech.ordinaryroad.bilibili.live.listener.IBilibiliSendSmsReplyMsgListener;
import tech.ordinaryroad.bilibili.live.msg.SendSmsReplyMsg;
import tech.ordinaryroad.bilibili.live.netty.handler.BilibiliBinaryFrameHandler;

/**
 * @author mjz
 * @date 2023/8/21
 */
@Slf4j
@Service
public class BilibiliSendSmsReplyMsgListener implements IBilibiliSendSmsReplyMsgListener {

    @Override
    public void onDanmuMsg(BilibiliBinaryFrameHandler binaryFrameHandler, SendSmsReplyMsg msg) {
        IBilibiliSendSmsReplyMsgListener.super.onDanmuMsg(binaryFrameHandler, msg);

        JsonNode info = msg.getInfo();
        JsonNode jsonNode1 = info.get(1);
        String danmuText = jsonNode1.asText();
        JsonNode jsonNode2 = info.get(2);
        Long uid = jsonNode2.get(0).asLong();
        String uname = jsonNode2.get(1).asText();
        log.info("{} 收到弹幕 {}({})：{}", binaryFrameHandler.getRoomId(), uname, uid, danmuText);
    }

    @Override
    public void onOtherSendSmsReplyMsg(BilibiliBinaryFrameHandler binaryFrameHandler, CmdEnum cmd, SendSmsReplyMsg msg) {
        log.info("{} 收到其他消息 {} {}", binaryFrameHandler.getRoomId(), cmd, msg);
    }

    @Override
    public void onUnknownCmd(BilibiliBinaryFrameHandler binaryFrameHandler, String cmdString, SendSmsReplyMsg msg) {
        log.warn("{} 未知cmd: {} {}", binaryFrameHandler.getRoomId(), cmdString, msg);
    }
}

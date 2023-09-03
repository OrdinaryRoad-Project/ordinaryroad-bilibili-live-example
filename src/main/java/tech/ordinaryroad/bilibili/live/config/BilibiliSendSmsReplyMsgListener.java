package tech.ordinaryroad.bilibili.live.config;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tech.ordinaryroad.live.chat.client.bilibili.constant.BilibiliCmdEnum;
import tech.ordinaryroad.live.chat.client.bilibili.listener.IBilibiliSendSmsReplyMsgListener;
import tech.ordinaryroad.live.chat.client.bilibili.msg.SendSmsReplyMsg;
import tech.ordinaryroad.live.chat.client.bilibili.netty.handler.BilibiliBinaryFrameHandler;
import tech.ordinaryroad.live.chat.client.commons.base.msg.BaseCmdMsg;
import tech.ordinaryroad.live.chat.client.commons.base.msg.BaseMsg;

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
    public void onOtherCmdMsg(BilibiliBinaryFrameHandler binaryFrameHandler, BilibiliCmdEnum cmd, BaseCmdMsg<BilibiliCmdEnum> cmdMsg) {
        log.info("{} 收到其他消息 {} {}", binaryFrameHandler.getRoomId(), cmd, cmdMsg);
    }

    @Override
    public void onUnknownCmd(BilibiliBinaryFrameHandler binaryFrameHandler, String cmdString, BaseMsg msg) {
        log.warn("{} 未知cmd: {} {}", binaryFrameHandler.getRoomId(), cmdString, msg);
    }
}

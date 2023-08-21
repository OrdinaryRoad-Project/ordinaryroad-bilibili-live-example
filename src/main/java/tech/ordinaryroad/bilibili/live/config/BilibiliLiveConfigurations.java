package tech.ordinaryroad.bilibili.live.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author mjz
 * @date 2023/8/21
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "tech.ordinaryroad.bilibili.live.client")
public class BilibiliLiveConfigurations {

    private BilibiliLiveChatClientConfig config = new BilibiliLiveChatClientConfig();

}

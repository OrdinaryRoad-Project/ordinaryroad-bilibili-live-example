package tech.ordinaryroad.bilibili.live;

import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;
import tech.ordinaryroad.bilibili.live.client.BilibiliLiveChatClient;

/**
 * @author mjz
 * @date 2023/8/21
 */
@Slf4j
@SpringBootApplication
public class Run {

    @Resource
    private BilibiliLiveChatClient bilibiliLiveChatClient;

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("run");
        SpringApplication.run(Run.class, args);
        stopWatch.stop();
        log.info("run end！ {}", stopWatch.prettyPrint());
    }

    @PreDestroy
    public void preDestroy() {
        bilibiliLiveChatClient.destroy();
    }
}
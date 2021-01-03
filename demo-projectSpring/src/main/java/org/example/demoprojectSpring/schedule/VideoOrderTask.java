package org.example.demoprojectSpring.schedule;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 定时统计订单，金额
* */


@Component
public class VideoOrderTask {


    //固定两秒执行一次
    //@Scheduled(fixedRate = 2000)
    // 任务执行完毕之后几秒后再次执行
    @Scheduled(fixedDelay = 2000)
    //@Scheduled(cron = "")
    public void sum() {
        System.out.println(LocalDateTime.now());
    }
}

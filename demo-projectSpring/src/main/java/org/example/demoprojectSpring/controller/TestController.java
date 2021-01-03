package org.example.demoprojectSpring.controller;

import org.example.demoprojectSpring.config.WXConfig;
import org.example.demoprojectSpring.task.AsyncTest;
import org.example.demoprojectSpring.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("api/v1/pub/test")
@PropertySource({"classpath:pay.properties"})
public class TestController {

    //@Value("${test.name}")
    @Value("${wxpay.appid}")
    private String payAppid;

    @Value("${wxpay.sercret}")
    private String paySecret;

    @Autowired
    private WXConfig wxConfig;

    @Autowired
    private AsyncTest asyncTest;

    @GetMapping("asyc")
    public JsonData AsycTest() {
        long begin = System.currentTimeMillis();
//        asyncTest.task1();
//        asyncTest.task2();
//        asyncTest.task3();

        Future<String> task4 = asyncTest.task4();
        Future<String> task5 = asyncTest.task5();

        for (;;) {
            if(task4.isDone() && task5.isDone()) {
                try {
                    String task4Result = task4.get();
                    String task5Result = task5.get();
                    System.out.println(task4Result);
                    System.out.println(task5Result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } finally {
                    break;
                }
            }
        }

        long end = System.currentTimeMillis();
        return JsonData.buildSuccess(begin - end);
    }

    @GetMapping("list")
    public JsonData testEx() {
        int i = 1 / 0;

        return JsonData.buildSuccess(" ");
    }

    @GetMapping("get_config")
    public JsonData testConfig() {
        /*Map<String, String> map = new HashMap<>();
        map.put("appid", payAppid);
        map.put("secret", paySecret);
        return JsonData.buildSuccess(map);*/

        Map<String, String> map = new HashMap<>();
        map.put("appid", wxConfig.getPayAppid());
        map.put("secret", wxConfig.getPaySecret());
        map.put("mechid", wxConfig.getPayMechId());
        return JsonData.buildSuccess(map);
    }

}

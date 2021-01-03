package org.example.demoprojectSpring;


import junit.framework.TestCase;
import org.example.demoprojectSpring.domain.Video;
import org.example.demoprojectSpring.serivce.VideoService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;
import java.util.List;

// 底层是Junit SpringRunner专门用于我们Spring项目的单元测试
@RunWith(SpringRunner.class)
// 标记启动类，
@SpringBootTest(classes={DemoProjectSpringApplication.class})
@AutoConfigureMockMvc
// 相当于一个客户端 可以断言 可以发起请求和接受响应
// perform andExpect andReturn
/**
 * perform执⾏行行⼀一个RequestBuilder请求
 * andExpect：添加ResultMatcher->MockMvcResultMatchers验证规则
 * andReturn：最后返回相应的MvcResult->Response
 * */
public class VideoTest {

    /*// 一般用做资源的初始化
    @Before
    // 一般做测试
    @Test
    // 一般做资源的回收
    @After*/

    @Autowired
    private VideoService videoService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testVideoListApi() throws Exception {
        /**
         *  perform 获取http请求
         *  MockMvcRequestBuilders是一个构建器 构建多种http请求
         *  支持链式调用
         * .andExpect 看预期结果
         *  MockMvcResultMatchers.status 结果的状态码
         *  isOK 状态码 200
         *  andReturn 返回结果
         * */
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pub/video/list/"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        String str = mvcResult.getResponse().getContentAsString();
        int status = mvcResult.getResponse().getStatus();
        System.out.println(str);
        System.out.println(status);

        // 解决乱码问题
        String res = mvcResult.getResponse().getContentAsString(Charset.forName("utf-8"));
    }

    @Before
    public void testOne() {
        System.out.println("123");
    }

    @Test
   public void TestVideoList() {
       List<Video> videoList = videoService.listVideo();
       TestCase.assertTrue(videoList.size() > 0);
   }

    @After
    public void testThree() {
        System.out.println("xxx");
    }

}

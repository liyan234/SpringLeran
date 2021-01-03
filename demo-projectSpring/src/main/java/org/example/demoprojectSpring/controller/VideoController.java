package org.example.demoprojectSpring.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.demoprojectSpring.domain.Video;
import org.example.demoprojectSpring.serivce.VideoService;
import org.example.demoprojectSpring.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    //@RequestMapping(value = "list", method = RequestMethod.GET)
    @GetMapping("list")
    public Object print() throws JsonProcessingException {
        List<Video> list = videoService.listVideo();

        // 链表转成json字符串
        // 序列化操作
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(list);
        System.out.println(jsonStr);

        // json字符串转成链表
        // 反序列化操作
        List<Video> tmp = objectMapper.readValue(jsonStr, List.class);

        return JsonData.buildSuccess(tmp);
    }

    @PostMapping("save_video_chapter")
    public JsonData saveVideoChapter(@RequestBody Video video) {
        System.out.println(video.toString());
        return JsonData.buildSuccess(video);
    }
}

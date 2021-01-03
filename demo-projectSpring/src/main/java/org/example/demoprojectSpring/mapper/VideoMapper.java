package org.example.demoprojectSpring.mapper;

import org.example.demoprojectSpring.domain.Video;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
// 会自动new一个VideoMapper类
public class VideoMapper {
    private static Map<Integer, Video> videoMap = new HashMap<>();

    static {
        videoMap.put(1, new Video(1, "q"));
        videoMap.put(2, new Video(2, "w"));
        videoMap.put(3, new Video(3, "e"));
        videoMap.put(4, new Video(4, "r"));
        videoMap.put(5, new Video(5, "t"));
        videoMap.put(6, new Video(6, "y"));
        videoMap.put(7, new Video(7, "u"));
        videoMap.put(8, new Video(8, "i"));
    }

    public List<Video> listVideo() {
        List<Video> list = new ArrayList<>();
        // 链表添加所有的map的value值
        list.addAll(videoMap.values());
        return list;
    }

}

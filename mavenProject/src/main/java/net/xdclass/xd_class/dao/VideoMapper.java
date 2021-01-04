package net.xdclass.xd_class.dao;

import net.xdclass.xd_class.domain.Video;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface VideoMapper {

    /**
     * 根据视频id查找视频对象
     * */
    Video selectById(@Param("video_id") int videoId);

    /**
     * 查找所用的video对象
     * */
    Video selectAllVideo();

    /**
     * 模糊查询
     * */
    ArrayList<Video> selectByPointAndTitleLike (@Param("point") double point, @Param("title") String title);

    /**
     * 插入
     * @return*/
    int add(Video video);

     /**
      * 批量插入
      * */
     int addBatch(List<Video> list);

    /**
     * 修改
     */
    int updateVideoSelect(Map<String, Object> map);
}

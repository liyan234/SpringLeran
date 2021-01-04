package net.xdclass.xd_class;

import net.xdclass.xd_class.dao.VideoMapper;
import net.xdclass.xd_class.dao.VideoOrderMapper;
import net.xdclass.xd_class.domain.User;
import net.xdclass.xd_class.domain.VideoOrder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SqlSessionDemo {
    public static void main(String[] args) throws IOException {

        String resouces = "config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resouces);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 用 try 包裹  try中的语句执行完毕之后 ，就会自动关闭


        SqlSession sqlSession = sqlSessionFactory.openSession();
        VideoMapper videoMapper = sqlSession.getMapper(VideoMapper.class);
       /* ArrayList<Video> list = videoMapper.selectByPointAndTitleLike(8.9, "教");
        Video video = videoMapper.selectById(40);*/
        /*Video video = new Video();
        video.setTitle("xxxxxxxxxxx");
        video.setCoverImg("yyyyyyyyyyy");
        Video video1 = new Video();
        video.setTitle("1233123");
        video.setSummary("99999");
        List<Video> list = new ArrayList<Video>();
        list.add(video);
        list.add(video1);
        int rows = videoMapper.addBatch(list);
        System.out.println(list);*/

       /* Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 50);
        map.put("title", 23242);
        map.put("summary", "123");
        videoMapper.updateVideoSelect(map);*/

        VideoOrderMapper mapper = sqlSession.getMapper(VideoOrderMapper.class);

        sqlSession.commit();

        List<VideoOrder> list = mapper.queryVideoOrderList();
        List<User> users = mapper.queryUserList();

        System.out.println(users);
        sqlSession.close();


    }
}

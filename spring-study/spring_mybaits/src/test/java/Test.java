import com.li.pojo.User;
import com.li.pojo.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
   /* public static void main(String[] args) throws IOException {
        String resources = "MybatisConfig.xml";
        InputStream in = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        sqlSession.close();
        List<User> users = userMapper.selectUser();
        for (User u: users) {
            System.out.println(u);
        }
    }*/

    @org.junit.Test
    public void Test() {
     ApplicationContext c = new ClassPathXmlApplicationContext("spring-dao.xml");
     UserMapper userMapper = c.getBean("useMapper", UserMapper.class);
     List<User> list = userMapper.selectUser();
        System.out.println(list);
    }
}

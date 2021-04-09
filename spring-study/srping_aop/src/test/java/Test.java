import com.li.Demo1.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //动态代理的是接口
        UserService userService = (UserService) context.getBean("userServiceImp");
        userService.add();
    }
}

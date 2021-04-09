import com.li.pojo.Hello;
import com.li.pojo.Hello2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Hello o = (Hello) context.getBean("hello");
        System.out.println(o.getName());

        Hello2  o2 = (Hello2) context.getBean("hello2");
        System.out.println(o2.getName());

    }
}

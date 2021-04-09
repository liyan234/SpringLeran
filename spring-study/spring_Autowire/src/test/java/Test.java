import com.li.pojo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {


    @org.junit.Test
    public void test() {
        ApplicationContext context =  new ClassPathXmlApplicationContext("bean.xml");
        Person p =  context.getBean("person", Person.class);
        p.getDog().shout();
        p.getCat().shout();
    }

}

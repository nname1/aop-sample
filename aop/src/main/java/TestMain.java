/**
 * @Author: Longgui Wang
 * @Date: 2021/2/18 1:03 PM
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.service.AspectService;

public class TestMain {

    public static void main(String[] args) {

        // ClassPathXmlApplicationContext默认是加载src目录下的xml文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        AspectService aservice = context.getBean(AspectService.class);
        System.out.println("\n===========普通调用=============\n");

        aservice.sayHi("hd");

        System.out.println("\n===========异常调用=============\n");

        //aservice.excuteException();

        System.out.println("\n===========普通调用=============\n");

        aservice.sayHello("haha");

        System.out.println("\n========================\n");
    }

}

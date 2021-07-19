package quoters;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springMain.xml");
//        while (true) {
//            Thread.sleep(1000L);
//            context.getBean(Quoter.class).sayQuote();
//        }
    }
}

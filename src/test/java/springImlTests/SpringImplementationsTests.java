package springImlTests;

import baseTests.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import quoters.Quoter;

public class SpringImplementationsTests extends BaseTest {

    @Test
    public void simpleContextTest() {
        ClassPathXmlApplicationContext ctx = app.getXmlContext("simpleContext.xml");
        ctx.getBean(Quoter.class).sayQuote();
    }

    @Test
    public void simpleContextWithInitMethodTest() {
        ClassPathXmlApplicationContext ctx = app.getXmlContext("simpleContextWithInitMethod.xml");
        ctx.getBean(Quoter.class).sayQuote();
    }

    @Test
    public void simpleContextWithInjectRandomIntAnnotationBeanPostProcessorTest() {
        app.getXmlContext("simpleContextWithInjectRandomIntAnnotationBeanPostProcessor.xml")
                .getBean(Quoter.class)
                .sayQuote();
    }

    @Test
    public void contextWithPhases_1_2_3_Test() {
        ClassPathXmlApplicationContext ctx = app.getXmlContext("contextWithPhases_1_2_3.xml");
        ctx.getBean(Quoter.class).sayQuote();
    }

    @Test
    public void fullContextWithPostProxyTest() {
        app.getXmlContext("fullContextWithPostProxyInvokerListener.xml")
                .getBean(Quoter.class);
    }

    @Test
    public void fullContextWithPostProfilingTest() throws InterruptedException {
        //public static void main(String[] args) throws InterruptedException {
        Quoter quoter = app.getXmlContext("fullContextWithProfiling.xml")
                //new ClassPathXmlApplicationContext("fullContextWithProfiling.xml")
                .getBean(Quoter.class);

        while (true) {
            quoter.sayQuote();
            Thread.sleep(500L);
        }
    }
}

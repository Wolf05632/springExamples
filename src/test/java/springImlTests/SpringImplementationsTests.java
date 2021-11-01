package springImlTests;

import baseTests.BaseTest;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import quoters.Quoter;

class SpringImplementationsTests extends BaseTest {

    @Test
    void simpleContextTest() {
        ClassPathXmlApplicationContext ctx = app.getXmlContext("simpleContext.xml");
        ctx.getBean(Quoter.class).sayQuote();
    }

    @Test
    void simpleContextWithInitMethodTest() {
        ClassPathXmlApplicationContext ctx = app.getXmlContext("simpleContextWithInitMethod.xml");
        ctx.getBean(Quoter.class).sayQuote();
    }

    @Test
    void simpleContextWithInjectRandomIntAnnotationBeanPostProcessorTest() {
        app.getXmlContext("simpleContextWithInjectRandomIntAnnotationBeanPostProcessor.xml")
                .getBean(Quoter.class)
                .sayQuote();
    }

    @Test
    void contextWithPhases_1_2_3_Test() {
        ClassPathXmlApplicationContext ctx = app.getXmlContext("contextWithPhases_1_2_3.xml");
        ctx.getBean(Quoter.class).sayQuote();
    }

    @Test
    void fullContextWithPostProxyTest() {
        app.getXmlContext("fullContextWithPostProxyInvokerListener.xml").getBean(Quoter.class);
    }

    @Test
    void fullContextWithPostProfilingTest() throws InterruptedException {
        Quoter quoter = app.getXmlContext("fullContextWithProfiling.xml").getBean(Quoter.class);
        while (Thread.currentThread().isAlive()) {
            quoter.sayQuote();
            Thread.sleep(500L);
        }
    }

    @Test
    void contextWithDeprecatedTest() {
        app.getXmlContext("simpleContextWithDeprecated.xml")
                .getBean(Quoter.class)
                .sayQuote();
    }
}

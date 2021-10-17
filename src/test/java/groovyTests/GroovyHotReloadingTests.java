package groovyTests;

import baseTests.BaseTest;
import groovyHotReloading.Calc;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class GroovyHotReloadingTests extends BaseTest {

    @Test
    void groovyHotReloadingTest() throws InterruptedException {
        Calc calc = (Calc) new ClassPathXmlApplicationContext("groovyBeanHotReloading.xml").getBean("calc");
        int result;
        do {
            result = calc.sum(5, 6);
            System.out.println(result);
            Thread.sleep(1000L);
        }
        while (result != 10);
    }
}

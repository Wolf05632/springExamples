package lazySchwarzeneggersBlasterTests;

import lazySchwarzeneggersBlaster.Schwarzenegger;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class LazySchwarzeneggersBlasterTest {

    @Test
    synchronized void lazyBlasterTest() throws InterruptedException {
        new AnnotationConfigApplicationContext(Schwarzenegger.class);
        wait();
    }
}
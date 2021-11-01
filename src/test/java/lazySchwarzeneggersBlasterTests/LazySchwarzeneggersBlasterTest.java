package lazySchwarzeneggersBlasterTests;

import lazySchwarzeneggersBlaster.Schwarzenegger;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class LazySchwarzeneggersBlasterTest {

    @Test
    synchronized void lazyBlasterTest() throws InterruptedException {
        new AnnotationConfigApplicationContext(Schwarzenegger.class);
        wait();
    }

    @Test
    void lazyBlasterTestWithLock() throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        lock.lock();
        new AnnotationConfigApplicationContext(Schwarzenegger.class);
        try {
            while (Thread.currentThread().isAlive())
                condition.await();
        } finally {
            lock.unlock();
        }
    }
}
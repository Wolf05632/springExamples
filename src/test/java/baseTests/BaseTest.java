package baseTests;

import appImpl.ContextFactoryImpl;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseTest {

    private static ClassPathXmlApplicationContext ctx;
    protected ContextFactoryImpl app;

    @BeforeAll
    public static void initContext() {
        ctx = new ClassPathXmlApplicationContext();
    }

    @AfterAll
    public static void closeContext() {
        ctx.close();
    }

    @BeforeEach
    public void initSpringApp() {
        app = new ContextFactoryImpl(ctx);
    }

    @AfterEach
    public void closeStringApp() {
    }
}

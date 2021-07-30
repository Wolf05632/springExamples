package appImpl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public interface ContextFactory {
    ClassPathXmlApplicationContext getXmlContext(String pathFile);
}

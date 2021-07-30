package appImpl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextFactoryImpl implements ContextFactory {

    ClassPathXmlApplicationContext ctx;

    public ContextFactoryImpl(ClassPathXmlApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public ClassPathXmlApplicationContext getXmlContext(String filePath) {
        ctx.close();
        ctx.setConfigLocation(filePath);
        ctx.refresh();
        return ctx;
    }
}

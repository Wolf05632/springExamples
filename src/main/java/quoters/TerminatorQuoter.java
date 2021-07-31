package quoters;

import quoters.annotations.DeprecatedClass;
import quoters.annotations.InjectRandomInt;
import quoters.annotations.PostProxy;
import quoters.annotations.Profiling;

import javax.annotation.PostConstruct;

@Profiling
@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuoter implements Quoter {
    @InjectRandomInt(min = 2, max = 7)
    private int count;
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @PostConstruct // need to init CommonAnnotationBeanPostProcessor xml config file /
    // or via init-method /
    // or via implementation InitializingBean method name is afterPropertiesSet() - old way
    public void init() {
        System.out.println("Phase 2. In init method:");
        System.out.println("Count init " + count);
    }

    public TerminatorQuoter() {
        System.out.println("Phase 1. In Class constructor");
    }

    @Override
    @PostProxy
    public void sayQuote() {
        if (count <= 0)
            return;
        System.out.println("Phase 3. Post Proxy. In sayQuote method:");
        for (int i = 0; i < count; i++) {
            System.out.println(message);
        }
    }
}

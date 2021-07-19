package quoters;

import javax.annotation.PostConstruct;

@Profiling
public class TerminatorQuoter implements Quoter {
    @InjectRandomInt(min = 2, max = 7)
    private int count;
    private String message;

    @PostConstruct // и инициализировать в springMain.xml / или через init-method /
    // или через имплементацию InitializingBean метод afterPropertiesSet
    public void init() {
        System.out.println("Phase 2");
        System.out.println(count);
    }

    public TerminatorQuoter() {
        System.out.println("Phase 1");
    }

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("Phase 3");
        for (int i = 0; i < count; i++) {
            System.out.println(message);
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

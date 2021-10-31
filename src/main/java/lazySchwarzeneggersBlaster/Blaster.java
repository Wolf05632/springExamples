package lazySchwarzeneggersBlaster;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Lazy
public class Blaster {

    @PostConstruct
    private void init() {
        System.out.println("You payed 100500 for a blaster.");
    }

    public void fire() {
        System.out.println("Fiiiireeeeee!!!");
    }
}

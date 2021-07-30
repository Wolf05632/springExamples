package quoters.beanPostProcessors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;
import quoters.annotations.InjectRandomInt;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                if (max < min)
                    max = max ^ min ^ (min = max);
                if(min < 0)
                    min = 0;
                Random random = new Random();
                int i = random.nextInt(max - min) + min;
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, i);
            }

        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

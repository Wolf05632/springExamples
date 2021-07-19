package quoters;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProfilingHandlerBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Class<?>> map = new HashMap<>();
    private ProfilingController controller = new ProfilingController();

    public ProfilingHandlerBeanPostProcessor() {
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        try {
            platformMBeanServer.registerMBean(controller,
                    new ObjectName("profiling", "name", "controller"));
        } catch (InstanceAlreadyExistsException | MBeanRegistrationException |
                NotCompliantMBeanException | MalformedObjectNameException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(Profiling.class))
            map.put(beanName, beanClass);
        return bean;
    }

    private InvocationHandler getProfilingLogic(Object bean) {
        return (proxy, method, args) -> {
            if (!controller.isEnabled())
                return method.invoke(bean, args);
            System.out.println("Start profiling...");
            long start = System.nanoTime();
            Object retVal = method.invoke(bean, args);
            long end = System.nanoTime();
            System.out.println(end - start);
            System.out.println("End profiling...");
            return retVal;
        };
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = map.get(beanName);
        if (beanClass != null)
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), getProfilingLogic(bean));
        return bean;
    }
}

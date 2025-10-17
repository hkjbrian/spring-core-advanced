package advanced.core.proxyfactory;

import advanced.core.common.ConcreteService;
import advanced.core.common.ServiceImpl;
import advanced.core.common.ServiceInterface;
import advanced.core.common.advice.TimeAdvice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

public class ProxyFactoryTest {

    @Test
    @DisplayName("인터페이스가 있으면 JDK 동적 프록시 방식으로 프록시 객체 생성")
    void interfaceProxy() {
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        System.out.println(proxyFactory.getProxy().getClass());

        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        proxy.find();
    }

    @Test
    @DisplayName("구체 클래스만 있으면 CGLIB 방식으로 프록시 객체 생성")
    void concreteProxy() {
        ConcreteService target = new ConcreteService();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        System.out.println(proxyFactory.getProxy().getClass());

        ConcreteService proxy = (ConcreteService) proxyFactory.getProxy();
        proxy.find();
    }

    @Test
    @DisplayName("ProxyTargetClass 옵션을 사용하게 되면 인터페이스가 있어도 CGLIB 사용")
    void proxyTargetProxy() {
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.addAdvice(new TimeAdvice());
        System.out.println(proxyFactory.getProxy().getClass());

        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        proxy.find();
    }
}

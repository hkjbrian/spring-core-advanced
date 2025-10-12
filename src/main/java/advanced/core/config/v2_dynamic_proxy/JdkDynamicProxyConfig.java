package advanced.core.config.v2_dynamic_proxy;

import advanced.core.config.v1_proxy.interface_proxy.OrderControllerInterfaceProxy;
import advanced.core.config.v1_proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import advanced.core.config.v1_proxy.interface_proxy.OrderServiceInterfaceProxy;
import advanced.core.config.v2_dynamic_proxy.handler.LogInvocationHandler;
import advanced.core.sec5.app.v1.*;
import advanced.core.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class JdkDynamicProxyConfig {

    @Bean
    public OrderControllerV1 orderController(LogTrace logTrace) {
        OrderControllerV1 orderControllerImpl = new OrderControllerV1Impl(orderService(logTrace));
        LogInvocationHandler handler = new LogInvocationHandler(orderControllerImpl, logTrace);

        return (OrderControllerV1) Proxy.newProxyInstance(OrderControllerV1.class.getClassLoader(), new Class[]{OrderControllerV1.class}, handler);
    }

    @Bean
    public OrderServiceV1 orderService(LogTrace logTrace) {
        OrderServiceV1 orderServiceImpl = new OrderServiceV1Impl(orderRepository(logTrace));
        LogInvocationHandler handler = new LogInvocationHandler(orderServiceImpl, logTrace);

        return (OrderServiceV1) Proxy.newProxyInstance(OrderServiceV1.class.getClassLoader(), new Class[]{OrderServiceV1.class}, handler);
    }

    @Bean
    public OrderRepositoryV1 orderRepository(LogTrace logTrace) {
        OrderRepositoryV1 orderRepositoryImpl = new OrderRepositoryV1Impl();
        LogInvocationHandler handler = new LogInvocationHandler(orderRepositoryImpl, logTrace);

        return (OrderRepositoryV1) Proxy.newProxyInstance(OrderRepositoryV1.class.getClassLoader(), new Class[]{OrderRepositoryV1.class}, handler);
    }
}

package advanced.core.config.v2_dynamic_proxy;

import advanced.core.config.v2_dynamic_proxy.handler.LogFilterHandler;
import advanced.core.config.v2_dynamic_proxy.handler.LogFilterHandler;
import advanced.core.sec5.app.v1.*;
import advanced.core.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class JdkDynamicProxyFilterConfig {

    private static final String[] PATTERNS = {"request*", "order*", "save*"};

    @Bean
    public OrderControllerV1 orderController(LogTrace logTrace) {
        OrderControllerV1 orderControllerImpl = new OrderControllerV1Impl(orderService(logTrace));
        LogFilterHandler handler = new LogFilterHandler(orderControllerImpl, logTrace, PATTERNS);

        return (OrderControllerV1) Proxy.newProxyInstance(OrderControllerV1.class.getClassLoader(), new Class[]{OrderControllerV1.class}, handler);
    }

    @Bean
    public OrderServiceV1 orderService(LogTrace logTrace) {
        OrderServiceV1 orderServiceImpl = new OrderServiceV1Impl(orderRepository(logTrace));
        LogFilterHandler handler = new LogFilterHandler(orderServiceImpl, logTrace, PATTERNS);

        return (OrderServiceV1) Proxy.newProxyInstance(OrderServiceV1.class.getClassLoader(), new Class[]{OrderServiceV1.class}, handler);
    }

    @Bean
    public OrderRepositoryV1 orderRepository(LogTrace logTrace) {
        OrderRepositoryV1 orderRepositoryImpl = new OrderRepositoryV1Impl();
        LogFilterHandler handler = new LogFilterHandler(orderRepositoryImpl, logTrace, PATTERNS);

        return (OrderRepositoryV1) Proxy.newProxyInstance(OrderRepositoryV1.class.getClassLoader(), new Class[]{OrderRepositoryV1.class}, handler);
    }
}

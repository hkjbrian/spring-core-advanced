package advanced.core.config.v2_proxy;

import advanced.core.config.v2_proxy.concrete_proxy.OrderControllerConcreteProxy;
import advanced.core.config.v2_proxy.concrete_proxy.OrderRepositoryV2ConcreteProxy;
import advanced.core.config.v2_proxy.concrete_proxy.OrderServiceConcreteProxy;
import advanced.core.sec5.app.v2.OrderControllerV2;
import advanced.core.sec5.app.v2.OrderRepositoryV2;
import advanced.core.sec5.app.v2.OrderServiceV2;
import advanced.core.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConcreteProxyConfig {

    @Bean
    public OrderControllerV2 orderController(LogTrace logTrace) {
        OrderControllerV2 controllerImpl = new OrderControllerV2(orderService(logTrace));
        return new OrderControllerConcreteProxy(controllerImpl, logTrace);
    }

    @Bean
    public OrderServiceV2 orderService(LogTrace logTrace) {
        OrderServiceV2 serviceImpl = new OrderServiceV2(orderRepository(logTrace));
        return new OrderServiceConcreteProxy(serviceImpl, logTrace);
    }

    @Bean
    public OrderRepositoryV2 orderRepository(LogTrace logTrace) {
        OrderRepositoryV2 repositoryImpl = new OrderRepositoryV2();
        return new OrderRepositoryV2ConcreteProxy(repositoryImpl, logTrace);
    }
}

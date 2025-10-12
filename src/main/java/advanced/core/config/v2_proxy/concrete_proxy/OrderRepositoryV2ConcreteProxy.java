package advanced.core.config.v2_proxy.concrete_proxy;

import advanced.core.sec5.app.v2.OrderRepositoryV2;
import advanced.core.trace.TraceStatus;
import advanced.core.trace.logtrace.LogTrace;

public class OrderRepositoryV2ConcreteProxy extends OrderRepositoryV2 {

    private final OrderRepositoryV2 target;
    private final LogTrace logTrace;

    public OrderRepositoryV2ConcreteProxy(OrderRepositoryV2 orderRepository, LogTrace logTrace) {
        this.target = orderRepository;
        this.logTrace = logTrace;
    }

    @Override
    public void save(String itemId) {

        TraceStatus status = null;
        try {
            status = logTrace.begin("orderRepository.save()");
            target.save(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}

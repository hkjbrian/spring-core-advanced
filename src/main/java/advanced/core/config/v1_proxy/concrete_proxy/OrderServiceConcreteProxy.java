package advanced.core.config.v1_proxy.concrete_proxy;

import advanced.core.sec5.app.v2.OrderServiceV2;
import advanced.core.trace.TraceStatus;
import advanced.core.trace.logtrace.LogTrace;

public class OrderServiceConcreteProxy extends OrderServiceV2 {

    private OrderServiceV2 target;
    private LogTrace logTrace;

    public OrderServiceConcreteProxy(OrderServiceV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void orderItem(String itemId) {

        TraceStatus status = null;

        try{
            status = logTrace.begin("OrderService.request()");
            target.orderItem(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}

package advanced.core.sec5.app.v3;

import advanced.core.sec5.app.v2.OrderServiceV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV3 {

    private final OrderServiceV3 orderservice;

    public OrderControllerV3(OrderServiceV3 orderservice) {
        this.orderservice = orderservice;
    }

    @GetMapping("/v3/request")
    public String request(String itemId) {
        orderservice.orderItem(itemId);
        return "ok";
    }

    @GetMapping("/v3/no-log")
    public String noLog() {
        return "ok";
    }
}

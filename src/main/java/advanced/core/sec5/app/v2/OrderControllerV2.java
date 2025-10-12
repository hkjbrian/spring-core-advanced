package advanced.core.sec5.app.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderControllerV2 {

    private final OrderServiceV2 orderservice;

    public OrderControllerV2(OrderServiceV2 orderservice) {
        this.orderservice = orderservice;
    }

    @GetMapping("/v2/request")
    public String request(String itemId) {
        orderservice.orderItem(itemId);
        return "ok";
    }

    @GetMapping("/v2/no-log")
    public String noLog() {
        return "ok";
    }
}

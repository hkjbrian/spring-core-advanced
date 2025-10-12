package advanced.core.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator implements Component {

    private Component component;

    public MessageDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("MessageDecorator operation");
        String operationResult = component.operation();
        String decoResult = "****" + operationResult + "****";
        log.info("Deco 적용 전: {}, 적용 후: {}", operationResult, decoResult);

        return decoResult;
    }
}

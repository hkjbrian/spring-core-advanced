package advanced.core.pureproxy.decorator;

import advanced.core.pureproxy.decorator.code.*;
import org.junit.jupiter.api.Test;

public class DecoratorPatternTest {

    @Test
    void noDecorator() {
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);

        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void decorator1() {
        Component realComponent = new RealComponent();
        Component proxy = new MessageDecorator(realComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(proxy);

        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void decorator2() {
        Component realComponent = new RealComponent();
        Component messageDecorator = new MessageDecorator(realComponent);
        Component timeDecorator = new TimeDecorator(messageDecorator);
        DecoratorPatternClient client = new DecoratorPatternClient(timeDecorator);

        client.execute();
    }
}

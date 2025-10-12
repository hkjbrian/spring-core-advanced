package advanced.core.pureproxy;

import advanced.core.pureproxy.code.CacheProxy;
import advanced.core.pureproxy.code.ProxyPatternClient;
import advanced.core.pureproxy.code.RealSubject;
import advanced.core.pureproxy.code.Subject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);

        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void proxyTest() {
        RealSubject realSubject = new RealSubject();
        Subject subject = new CacheProxy(realSubject);
        ProxyPatternClient client = new ProxyPatternClient(subject);
        client.execute();
        client.execute();
        client.execute();
    }
}

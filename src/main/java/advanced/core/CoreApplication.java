package advanced.core;

import advanced.core.config.AppV1Config;
import advanced.core.config.AppV2Config;
import advanced.core.config.v1_proxy.InterfaceProxyConfig;
import advanced.core.config.v2_proxy.ConcreteProxyConfig;
import advanced.core.trace.logtrace.LogTrace;
import advanced.core.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.util.Arrays;


//@Import({AppV1Config.class, AppV2Config.class})
//@Import({InterfaceProxyConfig.class})
@Import({ConcreteProxyConfig.class})
@SpringBootApplication(scanBasePackages = "advanced.core.sec5.app.v3")
public class CoreApplication {

	public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(CoreApplication.class, args);

        Arrays.stream(ctx.getBeanDefinitionNames())
                .filter(name -> ctx.getBean(name).getClass().getPackageName().startsWith("advanced.core"))
                .sorted()
                .forEach(System.out::println);
	}

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}

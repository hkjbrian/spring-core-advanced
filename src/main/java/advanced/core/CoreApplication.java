package advanced.core;

import advanced.core.config.AppV1Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Arrays;


@Import(AppV1Config.class)
@SpringBootApplication(scanBasePackages = "advanced.core.sec5")
public class CoreApplication {


	public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(CoreApplication.class, args);

        Arrays.stream(ctx.getBeanDefinitionNames())
                .filter(name -> ctx.getBean(name).getClass().getPackageName().startsWith("advanced.core"))
                .sorted()
                .forEach(System.out::println);
	}

}

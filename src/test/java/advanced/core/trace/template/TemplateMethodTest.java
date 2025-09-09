package advanced.core.trace.template;

import advanced.core.trace.template.code.AbstractTemplate;
import advanced.core.trace.template.code.SubClassLogic1;
import advanced.core.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long start = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직 1 실행");
        //비즈니스 로직 종료
        long end = System.currentTimeMillis();
        long resultTime = end - start;
        log.info("resultTime = {} ", resultTime);
    }

    private void logic2() {
        long start = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직 2 실행");
        //비즈니스 로직 종료
        long end = System.currentTimeMillis();
        long resultTime = end - start;
        log.info("resultTime = {} ", resultTime);
    }

    @Test
    void templateMethodV1() {
        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();

        AbstractTemplate template2 = new SubClassLogic2();
        template2.execute();
    }

    @Test
    void templateMethodV2() {
        AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            public void call() {
                log.info("비즈니스 로직 실행 1");
            }
        };
        template1.execute();

        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            public void call() {
                log.info("비즈니스 로직 실행 2");
            }
        };
        template2.execute();
    }
}

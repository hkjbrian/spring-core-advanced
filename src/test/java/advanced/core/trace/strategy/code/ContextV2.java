package advanced.core.trace.strategy.code;

import lombok.extern.slf4j.Slf4j;

/**
 * 필드에 전략을 보관하는 방식을 사용한다.
 */
@Slf4j
public class ContextV2 {

    public void execute(Strategy strategy) {
        long start = System.currentTimeMillis();
        //비즈니스 로직 실행
        strategy.call();
        //비즈니스 로직 종료
        long end = System.currentTimeMillis();
        long resultTime = end - start;
        log.info("resultTime = {} ", resultTime);
    }
}

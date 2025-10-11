package advanced.core.trace.strategy.code.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {

    public void execute(Callback callback) {
        long start = System.currentTimeMillis();
        //비즈니스 로직 실행
        callback.call();
        //비즈니스 로직 종료
        long end = System.currentTimeMillis();
        long result = end - start;
        log.info("resultTime={}", result);
    }
}

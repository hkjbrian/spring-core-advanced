package advanced.core.jdkdynamic.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AImpl implements AInterface {

    @Override
    public String callA() {
        log.info("AImpl call");
        return "A";
    }
}

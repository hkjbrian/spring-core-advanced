package advanced.core.common;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceImpl implements ServiceInterface {

    @Override
    public void save() {
        log.info("Impl save 호출");
    }

    @Override
    public void find() {
        log.info("Impl find 호출");
    }
}

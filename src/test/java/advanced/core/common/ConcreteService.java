package advanced.core.common;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteService {

    public void save() {
        log.info("Concrete save");
    }

    public void find() {
        log.info("Concrete find");
    }
}

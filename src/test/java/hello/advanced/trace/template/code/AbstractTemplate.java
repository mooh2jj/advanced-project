package hello.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

    public void execute() {
        long startTime = System.currentTimeMillis();
        call();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);      // 여기만 바꾸면 되니 SRP 원칙이 잘 갖쳐지게 할 수 있는 거!
    }

    protected abstract void call();
}


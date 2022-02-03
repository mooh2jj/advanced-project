package hello.advanced.trace.strategy.code.strategy;

import hello.advanced.trace.strategy.code.Strategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV2 {

    /**
     * 전략을 파라미터로 전달 받는 방식
     * @param strategy
     */
    public void execute(Strategy strategy) {
        long startTime = System.currentTimeMillis();
        strategy.call(); // 위임
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }
}

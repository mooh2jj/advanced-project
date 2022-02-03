package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.Strategy;
import hello.advanced.trace.strategy.code.strategy.ContextV1;
import hello.advanced.trace.strategy.code.strategy.ContextV2;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {
    /**
     * 전략 패턴 사용 : 전략을 파라미터로 받는 방식 => Context를 실행 할 때마다 전략을 파라미터로 전달한다.
     */
    @Test
    void strategyV1() {
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());

    }

    /**
     * 익명 내부 클래스 적용
     */

    @Test
    void strategyV2() {
        ContextV2 context = new ContextV2();
        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스로직1 실행");
            }
        });

        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스로직2 실행");
            }
        });

    }

    /**
     * 익명 내부 클래스 -> 람다함수로
     */

    @Test
    void strategyV3() {
        ContextV2 context = new ContextV2();
        context.execute(() -> log.info("비즈니스로직1 실행"));

        context.execute(() -> log.info("비즈니스로직2 실행"));

    }

}

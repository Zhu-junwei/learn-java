package com.zjw;

import cn.hutool.core.thread.ThreadUtil;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @author 朱俊伟
 * @since 2024/02/23 12:18
 */
public class EventAwareTest {

    /**
     * 测试doOnComplete方法，当流结束时触发的方法。
     */
    @Test
    public void testDoOnComplete() {
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4, 5)
                .doOnComplete(() -> {
                    System.out.println("doOnComplete当流结束时触发的方法");
                });
        integerFlux.subscribe(System.out::println);
    }

    /**
     * 测试doOnXXX方法
     * doOnNext方法仅在每次流发出一个元素时被调用。
     * doOnEach方法更通用，它在流发出项（包括元素、错误信号和完成信号）时被调用。
     * doOnComplete方法当流结束时触发的方法
     * doOnCancel方法当流取消订阅触发的方法
     * doOnError方法当流中有错误时触发的方法
     */
    @Test
    public void testDoOn() {
        Flux<Integer> integerFlux = Flux.range(1, 5)
                //延迟一段时间后向流中放入数据
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(next -> System.out.println("doOnNext = " + next))
                .doOnEach(integerSignal -> System.out.println("doOnEach = " + integerSignal))
                .doOnComplete(() -> System.out.println("doOnComplete当流结束时触发的方法"))
                .doOnCancel(() -> System.out.println("doOnCancel当流取消订阅触发的方法"))
                .doOnRequest(value -> System.out.println("doOnRequest = " + value))
                .doOnError(throwable -> System.out.println("throwable = " + throwable));

        integerFlux.subscribe(System.out::println);
        ThreadUtil.sleep(10000);
    }

    /**
     * concat连接所以源
     */
    @Test
    public void testConcat() {
        Flux.concat(Flux.just(1, 2, 3), Flux.just(4, 5, 6))
                .subscribe(System.out::println);
    }

    /**
     * log测试执行日志
     */
    @Test
    public void testLog() {
          Flux.just(1, 2, 3, 4)
                .log()
                .subscribe(System.out::println);
    }
}

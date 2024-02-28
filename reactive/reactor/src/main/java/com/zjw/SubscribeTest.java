package com.zjw;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SignalType;

/**
 * @author 朱俊伟
 * @since 2024/02/23 16:22
 */
public class SubscribeTest {

    /**
     * 正常消费者
     */
    @Test
    public void subscribeTest1() {
        Flux.just(1, 2, 3, 4)
                .subscribe(System.out::println);
    }

    /**
     * 正常消费者
     * 异常消费者
     */
    @Test
    public void subscribeTest2() {
        Flux.just(1, 2, 3, 4)
                .subscribe(System.out::println,
                        throwable -> System.out.println("throwable = " + throwable));
    }

    /**
     * 正常消费者
     * 异常消费者
     * 结束消费者
     */
    @Test
    public void subscribeTest3() {
        Flux.just(1, 2, 3, 4)
                .subscribe(System.out::println,
                        throwable -> System.out.println("异常了 = " + throwable),
                        () -> System.out.println("流结束了。"));
    }

    /**
     * 自定义消费者
     */
    @Test
    public void subscribeTest4() {
        Flux.range(1,10)
                .subscribe(new BaseSubscriber<Integer>() {
                    @Override
                    protected void hookOnSubscribe(Subscription subscription) {
                        System.out.println("hookOnSubscribe = " + subscription);
                        // 要数据
                        request(1);
                    }

                    @Override
                    protected void hookOnNext(Integer value) {
                        System.out.println("hookOnNext = " + value);
                        // 要数据
//                        request(1);
                        // 要无限数据
                        requestUnbounded();
                        if (value.equals(5)) {
                            // 取消订阅
                            cancel();
                        }
                    }

                    @Override
                    protected void hookOnComplete() {
                        System.out.println("hookOnComplete");
                    }

                    @Override
                    protected void hookOnError(Throwable throwable) {
                        System.out.println("hookOnError = " + throwable);
                    }

                    @Override
                    protected void hookOnCancel() {
                        System.out.println("hookOnCancel");
                    }

                    @Override
                    protected void hookFinally(SignalType type) {
                        System.out.println("hookFinally = " + type);
                    }
                });
    }
}

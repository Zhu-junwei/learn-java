package com.zjw;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * FluxMonoTest
 * <p>
 *   Flux：发布者，可以发布多个数据。
 *   Mono：发布者，只发布一个数据。
 * @author 朱俊伟
 * @since 2024/02/23 12:06
 */
public class FluxMonoTest {

    /**
     * Mono是一个发布者，只发布一个数据。
     */
    @Test
    public void testMono() {
        Mono<String> stringMono = Mono.just("1");
        stringMono.subscribe(System.out::println);
    }

    /**
     * Flux是一个发布者，可以发布多个数据。
     */
    @Test
    public void testFlux() {
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4, 5);
        integerFlux.subscribe(System.out::println);
        integerFlux.subscribe(e -> {
            System.out.println("#:" + e);
        });
    }
}

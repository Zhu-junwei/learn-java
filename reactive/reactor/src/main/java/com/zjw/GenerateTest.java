package com.zjw;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

/**
 * @author 朱俊伟
 * @since 2024/02/23 19:43
 */
public class GenerateTest {

    /**
     * 生成响应式流
     */
    @Test
    public void testGenerate(){
        Flux<String> generate = Flux.generate(
                //初始状态提供器
                () -> 0,
                //生成器函数
                (state, sink) -> {
                    sink.next("3 x " + state + " = " + 3 * state);
                    if (state == 10) sink.complete();
                    return state + 1;
                });
        generate.subscribe(System.out::println);
    }
}

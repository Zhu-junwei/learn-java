package com.zjw;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

/**
 * @author 朱俊伟
 * @since 2024/02/23 17:45
 */
public class BufferTest {

    /**
     * 消费者一次消费bufferSize个元素
     */
    @Test
    public void bufferTest() {
        Flux.range(1,10)
                .buffer(3)
                .subscribe(ele -> {
                    System.out.println(ele.getClass() + " , " + ele);
                });
    }
}

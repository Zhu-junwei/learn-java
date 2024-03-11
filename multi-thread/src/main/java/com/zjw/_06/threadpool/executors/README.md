# 线程池的种类

## newFixedThreadPool

> 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待

## newSingleThreadPool

> 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序（FIFO）执行

## newCachedThreadPool

> 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程。

## newScheduledThreadPool

> 可以执行延迟任务的线程，支持定时及周期性任务执行

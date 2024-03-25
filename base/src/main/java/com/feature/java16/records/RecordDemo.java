package com.feature.java16.records;

/**
 * 测试记录
 * <p>
 * 在java16被添加<a href="https://openjdk.org/jeps/395">EJP395</a>
 *
 * @author 朱俊伟
 * @since 2024/03/20 0:59
 */
public class RecordDemo {
    public static void main(String[] args) {
        Movie movie = new Movie("title123", 10);
        // 只能获取记录的值，而无法再修改记录的值，和class还是不同，功能进行了限制
        // no setter method
        // 促进了不可变性的编程范式？？
        System.out.println("movie.title() = " + movie.title());
        System.out.println("movie.releaseYear() = " + movie.releaseYear());
        System.out.println("movie = " + movie);
    }
}

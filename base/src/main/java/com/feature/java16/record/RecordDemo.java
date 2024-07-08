package com.feature.java16.record;

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
        System.out.println("movie.title() = " + movie.title()); // 访问器
        System.out.println("movie.releaseYear() = " + movie.releaseYear()); // 访问器
        System.out.println("movie = " + movie); // toString()

        // 使用自定义的构造器
        Music music = new Music("Jack", "Summer");
        System.out.println("music = " + music);
    }
}

/**
 * Record 记录
 * <ul>
 * <li>超类 {@link java.lang.Record}</li>
 * <li>不能被extends、abstract的和隐含final</li>
 * <li>所有字段都是final字段（浅层不可变）</li>
 * <li>自动生成Constructor，Accessors, hashCode(), toString(), equals(),</li>
 * </ul>
 *
 * @author 朱俊伟
 * @since 2024/03/20 0:41
 */
record Movie(String title, int releaseYear) {
}

/**
 * 如果有必要，我们可以使用普通构造器语法替换掉规范构造器
 */
record Music(String author, String song) {
    // 自定义的构造器
    Music(String author, String song) {
        this.author = author;
        this.song = "<" + song + ">";
    }
}
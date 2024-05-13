package com.feature.java21;

/**
 *  Switch Enum <a href="https://openjdk.org/jeps/441">JEP441</a>
 *
 * @author 朱俊伟
 * @since 2024/03/24 17:07
 */
public class SwitchWithBetterEnumSupport {

    public static void main(String[] args) {
        exhaustiveSwitchWithBetterEnumSupport(Suit.CLUBS);
        exhaustiveSwitchWithBetterEnumSupport(new Tarot());
    }

    // As of Java 21
    static void exhaustiveSwitchWithBetterEnumSupport(CardClassification c) {
        switch (c) {
            case Suit.CLUBS -> {
                System.out.println("It's clubs");
            }
            case Suit.DIAMONDS -> {
                System.out.println("It's diamonds");
            }
            case Suit.HEARTS -> {
                System.out.println("It's hearts");
            }
            case Suit.SPADES -> {
                System.out.println("It's spades");
            }
            case Tarot t -> {
                System.out.println("It's a tarot");
            }
        }
    }
}

// 牌分类
// sealed密封接口，只有Suit，Tarot可以继承
sealed interface CardClassification permits Suit, Tarot {}
// 四种传统花色
enum Suit implements CardClassification { CLUBS, DIAMONDS, HEARTS, SPADES }
// 塔罗牌
final class Tarot implements CardClassification {}
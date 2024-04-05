package com.zjw;

/**
 * CardFlipper 类用于实现翻转牌的游戏逻辑。
 * 桌子上有七张牌，每次只能翻动相邻的三张，能不能将七张牌全部翻转朝上
 */
public class CardFlipper {
    /**
     * 程序的入口点。
     * 初始化牌的状态，并尝试通过递归翻转牌，以达到所有牌面朝上的状态。
     */
    public static void main(String[] args) {
        // 初始化牌的状态，0代表牌面朝下
        int[] cards = {0, 0, 0, 0, 0, 0, 0};
        // 打印初始状态
        printCards(cards);
        // 尝试翻转牌
        if (!flipCards(cards, 0)) {
            System.out.println("无法将所有牌翻转朝上");
        } else{
            System.out.println("所有牌已翻转朝上");
        }
    }

    /**
     * 尝试递归翻转牌。
     *
     * @param cards 牌的状态数组
     * @param index 当前尝试翻转的牌的索引
     * @return 如果成功将所有牌翻转朝上，返回true；否则返回false。
     */
    public static boolean flipCards(int[] cards, int index) {
        // 如果到达最后，检查是否所有牌都朝上
        if (index >= cards.length - 2) {
            if (isAllFlipped(cards)) {
                printCards(cards);
                return true;
            }
            return false;
        }
        // 尝试翻转当前和相邻的两张牌
        flip(cards, index);
        printCards(cards); // 打印翻转后的状态
        if (flipCards(cards, index + 1)) {
            return true;
        }
        // 回溯：如果当前翻转不成功，则恢复原状并尝试下一种可能
        flip(cards, index);
        System.out.println("回溯");
        printCards(cards); // 打印翻转后的状态
        return flipCards(cards, index + 1);
    }

    /**
     * 翻转指定索引位置的牌及其相邻的两张牌。
     *
     * @param cards 牌的状态数组
     * @param index 需要翻转的牌的索引
     */
    public static void flip(int[] cards, int index) {
        // 翻转当前和相邻的两张牌
        cards[index] ^= 1;
        if (index + 1 < cards.length) {
            cards[index + 1] ^= 1;
        }
        if (index + 2 < cards.length) {
            cards[index + 2] ^= 1;
        }
    }

    /**
     * 检查所有牌是否都朝上。
     *
     * @param cards 牌的状态数组
     * @return 如果所有牌都朝上，返回true；否则返回false。
     */
    public static boolean isAllFlipped(int[] cards) {
        // 检查所有牌是否都朝上
        for (int card : cards) {
            if (card == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印牌的状态。
     *
     * @param cards 牌的状态数组
     */
    public static void printCards(int[] cards) {
        // 打印牌的状态
        for (int card : cards) {
            System.out.print(card + " ");
        }
        System.out.println();
    }
}

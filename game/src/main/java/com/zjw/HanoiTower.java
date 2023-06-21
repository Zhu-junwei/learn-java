package com.zjw;

/**
 * 汉诺塔小游戏
 *
 * @author 朱俊伟
 */
public class HanoiTower {
    //统计需要走几步
    public long count = 0;
    //记录汉诺卡的层数
    private final int num;
    //初始位置
    private final char from;
    //临时位置
    private final char temp;
    //最后移动到的位置
    private final char to;

    public HanoiTower(int num, char from, char temp, char to) {
        this.num = num;
        this.from = from;
        this.temp = temp;
        this.to = to;
    }

    //开始游戏
    public void run() {
        run(num, from, temp, to);
    }

    private void run(int num, char from, char temp, char to) {
        if (num == 1) {
            move(num, from, to);
        } else {
            //如果有多个盘，可以看成两个，最下面的和最上面的所有盘（n-1）
            //1 先移动上面所有的盘到b
            run(num - 1, from, to, temp);//将上面的n-1个盘子移动到临时位置
            //2 把最下面的这个盘移动到c
            move(num, from, to);
            //3 把b上面的所有盘移动到c
            run(num - 1, temp, from, to);
        }
    }

    private void move(int num, char from, char to){
        System.out.println((++count) + "\t" + num + "号：" + from + "-->" + to);
    }

    public static void main(String[] args) {
        HanoiTower hanoiTower = new HanoiTower(1, 'A', 'B', 'C');
        hanoiTower.run();
        System.out.println("总共需要走 " + hanoiTower.count + " 步。");
    }
}

import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("员工工号：");
        String workerNo = sc.nextLine();
        System.out.println("工作时长：");
        double workTime = sc.nextDouble();

        System.out.println("员工:" + workerNo + ",实发工资："+getMoney(workTime));
    }

    public static double getMoney(double workTime){
        double money ;
        double hourMoney = 80;
        if (workTime >= 120){
            money =  120*hourMoney + (workTime-120)*hourMoney*0.15;
        } else if (workTime < 60){
            money = workTime*hourMoney - 700;
        } else {
            money = workTime*hourMoney;
        }
        return money;
    }
}

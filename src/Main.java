
import java.sql.SQLOutput;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner  scan = new Scanner(System.in);
        System.out.println(" Введите число:");
        float num1 =  scan.nextFloat();
        System.out.println(" Введите число:");
        float num2 =  scan.nextFloat();
        float action1 = num1 + num2;
        float action2 = num1 - num2;
        float action3 = num1 * num2;
        float action4 =  num1 / num2;
        System.out.println(" Результат:" + action1 +"\n" + action2 + "\n" + action3 +"\n" + action4);




    }
}
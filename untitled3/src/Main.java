import java.util.Scanner;
import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int action;
        do {
            System.out.print("""
                    Выберите действие:
                    1) сумма
                    2) разность
                    3) произведение
                    4) деление
                    0) выход
                    >\s""");

            action = scanner.nextInt();

            System.out.println("Введите длину массива:");
            int[] nums = new int[scanner.nextInt()];

            for (int i = 0; i < nums.length; i++) {
                System.out.println("Введите значение для массива");
                int value = scanner.nextInt();
                nums[i] = value;
            }

            int res;
            switch (action) {
                case 1:
                    res = 0;
                    for (int i = 0; i < nums.length; i++) {
                        res += nums[i];
                    }
                    System.out.println("Результат сложения: " + res);
                    break;

                case 2:
                    res = nums[0];
                    for (int i = 1; i < nums.length; i++) {
                        res -= nums[i];
                    }
                    System.out.println("Результат вычитания: " + res);
                    break;

                case 3:
                    res = 1;
                    for (int i = 0; i < nums.length; i++) {
                        res *= nums[i];
                    }
                    System.out.println("Результат умножения: " + res);
                    break;

                case 4:
                    res = nums[0];
                    for (int i = 1; i < nums.length; i++) {
                        res /= nums[i];}

                    System.out.println("Результат деления: " + res);
                    break;

                case 0:
                    System.out.println("Выход из системы...");
                    break;

                default:
                    System.out.println("Ошибка: введите значение от 0 до 4");

            }

        } while (action != 0);
    }
}

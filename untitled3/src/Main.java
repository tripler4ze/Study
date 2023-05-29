import java.util.Scanner;

public class Main {
      public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int action;
            int[] nums = null;

            while (true) {
                  System.out.print("""
                          Выберите действие:
                           1) ввести массив
                           2) сумма
                           3) разность
                           4) произведение
                           5) деление
                           6) вывод элемента массива по индексу
                           7) поиск индекса по элементу
                           8) вывод введенного массива
                           0) выход
                            >\s""");
                  action = scanner.nextInt();

                  switch (action) {
                        case 1:
                              System.out.println("Введите длину массива:");
                              int size = scanner.nextInt();
                              nums = new int[size];
                              System.out.println("Введите значения для  массива:");
                              for (int i = 0; i < size; i++) {
                                    nums[i] = scanner.nextInt();
                              }
                              System.out.println("Массив успешно введен.");
                              break;
                        case 2:
                              if (nums == null) {
                                    System.out.println("Ошибка: Массив не введен.");
                                    break;
                              }
                              int sum = 0;
                              for (int num : nums) {
                                    sum += num;
                              }
                              System.out.println("Результат сложения: " + sum);
                              break;
                        case 3:
                              if (nums == null) {
                                    System.out.println("Ошибка: Массив не введен.");
                                    break;
                              }
                              int diff = 0;
                              for (int num : nums) {
                                    diff -= num;
                              }
                              System.out.println("Результат вычитания: " + diff);
                              break;
                        case 4:
                              if (nums == null) {
                                    System.out.println("Ошибка: Массив не введен.");
                                    break;
                              }
                              int product = 1;
                              for (int num : nums) {
                                    product *= num;
                              }
                              System.out.println("Результат умножения: " + product);
                              break;
                        case 5:
                              if (nums == null) {
                                    System.out.println("Ошибка: Массив не введен.");
                                    break;
                              }
                              int division = 1;
                              for (int num : nums) {
                                    division /= num;
                              }
                              System.out.println("Результат деления: " + division);
                              break;
                        case 6:
                              if (nums == null) {
                                    System.out.println("Ошибка: Массив не введен.");
                                    break;
                              }
                              System.out.println("Введите индекс элемента:");
                              int index = scanner.nextInt();
                              if (index >= 0 && index < nums.length) {
                                    int element = nums[index];
                                    System.out.println("Элемент по индексу " + index + ": " + element);
                              } else {
                                    System.out.println("Ошибка: Недопустимый индекс.");
                              }
                              break;
                        case 7:
                              if (nums == null) {
                                    System.out.println("Ошибка: Массив не введен.");
                                    break;
                              }
                              System.out.println("Введите элемент для поиска:");
                              int searchNum = scanner.nextInt();
                              int searchIndex = -1;
                              for (int i = 0; i < nums.length; i++) {
                                    if (nums[i] == searchNum) {
                                          searchIndex = i;
                                          break;
                                    }
                              }
                              if (searchIndex != -1) {
                                    System.out.println("Индекс элемента " + searchNum + ": " + searchIndex);
                              } else {
                                    System.out.println("Элемент не найден.");
                              }
                              break;
                        case 8:
                              if (nums == null) {
                                    System.out.println("Ошибка: Массив не введен.");
                                    break;
                              }
                              System.out.println("Введенный массив:");
                              for (int num : nums) {
                                    System.out.print(num + " ");
                              }
                              System.out.println();
                              break;
                        case 0:
                              System.out.println("Программа завершена.");
                              return;
                        default:
                              System.out.println("Ошибка: Недопустимое действие.");
                              break;
                       }


                 }
           }
     }







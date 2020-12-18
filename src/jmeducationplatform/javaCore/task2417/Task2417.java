/*

Напишите метод printOddNumbers, который принимает массив и выводит в консоль только нечетные числа из него,
через запятую. Конец вывода должен перевести курсор на новую строку.

Пример ввода: [3,5,20,8,7,3,100]

Пример вывода: 3,5,7,3

 */

package jmeducationplatform.javaCore.task2417;

import java.util.Arrays;

public class Task2417 {

    public static void main(String[] args) {

        int[] arr = new int[]{3, 5, 20, 8, 7, 3, 100};
        printOddNumbers(arr);
    }

    public static void printOddNumbers(int[] arr) {

        String separator = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                System.out.print(separator);
                System.out.print(arr[i]);
                separator = ",";
            }

        }
        System.out.print("\n");

    }
}

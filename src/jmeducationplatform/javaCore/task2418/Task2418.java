/*

Реализуйте метод, сливающий два отсортированных по неубыванию массива чисел в один отсортированный в том же
порядке массив. Массивы могут быть любой длины, в том числе нулевой.

Предполагается, что вы реализуете алгоритм слияния, имеющий линейную сложность: он будет идти по двум исходным
массивам и сразу формировать отсортированный результирующий массив. Так, чтобы сортировка полученного массива при
помощи Arrays.sort() уже не требовалась.

К сожалению, автоматически это не проверить, так что это остается на вашей совести :)

Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит
проверяющая система.

Пример ввода: {0, 2, 2} и {1, 3}
Пример вывода: {0, 1, 2, 2, 3}

Требования:
Cигнатура метода должна быть: mergeArrays(int[] a1, int[] a2)

 */

package jmeducationplatform.javaCore.task2418;

import java.util.Arrays;

public class Task2418 {

    public static void main(String[] args) {

        int[] a1 = new int[]{0, 2, 2};            //подставляем значения массивов в метод для проверки
        int[] a2 = new int[]{1, 3};

        mergeArrays(a1, a2);                      //вызов метода
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {     //сам метод

        int[] a3 = new int[a1.length + a2.length];            //задаем макс.длину результ.массива

        int i = 0, j = 0;                                     //создаем переменные,начиная с 0, для if-ов
        for (int k = 0; k < a3.length; k++) {                 //проверка на переполнение длины результ.массива

            if (i > a1.length - 1) {          //условие,проверка по длине массива 1, -1 элемент т.к начало индексов с 0
                int a = a2[j];                                //создаем буферную переменную
                a3[k] = a;                                    //кладем значение в а3 под индексом равным k
                j++;                                          //увеличиваем j на 1
            } else if (j > a2.length - 1) {   //условие,проверка по длине массива 2, -1 элемент т.к начало индексов с 0
                int b = a1[i];
                a3[k] = b;
                i++;
            } else if (a1[i] < a2[j]) {      //сравниваем значения 2-х элементов, под идексами i и j 2-х массивов
                int a = a1[i];                                //меньшее кладем в буфер int a
                a3[k] = a;                                    //значение int a кладем в рез.массив под индуксом k
                i++;                                          //увеличиваем i на 1
            } else {
                int b = a2[j];
                a3[k] = b;
                j++;
            }

        }
        System.out.print(Arrays.toString(a3));                //распечатка массива а3
        return a3;                                            //возврат а3 нужен т.к метод не void а int[]
    }
}

/*
        int[] a3 = new int[a1.length + a2.length];

        int i = 0, j = 0;


        while (i < a1.length && j < a2.length) {      // через while не получилось, т.к если i == a1.length - выходит из
                                                      // всего while, не переходя на else.
            if (a1[i] < a2[j]) {
                a3[i + j] = a1[i];
                i++;
            }

        } else {
            a3[i + j] = a2[j];
            j++;

        }
        System.out.print(Arrays.toString(a3));
        return a3;
    }


}

      /*
        for (int m = 1; m < a1.length; m++) {                //сортировка массивов методом пузырька.
            for (int k = 0; k < a1.length - m; k++) {
                if (a1[k] > a1[k + 1]) {
                    int result1 = a1[k];
                    a1[k] = a1[k + 1];
                    a1[k + 1] = result1;
                    // return a1;

                }
            }
        }

        for (int m = 1; m < a2.length; m++) {
            for (int k = 0; k < a2.length - m; k++) {
                if (a2[k] > a2[k + 1]) {
                    int result2 = a2[k];
                    a2[k] = a2[k + 1];
                    a2[k + 1] = result2;
                    // return a2;

                }

            }
        }
        int[] a3 = new int[a1.length + a2.length];
        for (int m = 1; m < a1.length; m++) {   //как теперь слить 2 в один сразу сортируя?


        }
        */



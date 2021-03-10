/*

Напишите программу, читающую текст из System.in и выводящую в System.out сумму всех встреченных в тексте вещественных
чисел с точностью до шестого знака после запятой. Числом считается последовательность символов, отделенная от
окружающего текста пробелами или переводами строк и успешно разбираемая методом Double.parseDouble.

На этот раз вам надо написать программу полностью, т.е. объявить  публичный класс с именем Main  и точку входа в
программу — метод  main. И добавить все необходимые импорты

import java.io.*;
import java.nio.*;
import java.util.*;

Пример ввода 1: 1 2 3
Пример вывода 1: 6.000000


Пример ввода 2: a1 b2 c3
Пример вывода 2: 0.000000


Пример ввода 3:  -1e3 18 .111 11bbb
Пример вывода 3: -981.889000


Требования:
1. Программа должна читать текст из System.in
2. Программа должна выводить число с точностью до 6 знака после запятой.

 */


package jmeducationplatform.javaCore.block5.task5312;

import java.util.*;
import java.util.Scanner;                                   // сами импортируем библиотеку сканер

public class Task5312 {

    public static void main(String[] args) throws Exception {

                                                            // создаем сканер для введенного с клавиатуры...
        Scanner scanner = new Scanner(System.in);           // Обязательно нажать Ctrl D после ввода и интера!
        scanner.useLocale(Locale.US);                       // распознование 0.0 вместо 0,0
        System.out.println("Введите символы");

        double sum = 0.0;                                   // инициализируем вне цикла
                                                            // разбиваем то что ввели на токены по пробелу...
        while (scanner.hasNext()) {                         // вернет true если есть еще токен,false если кончились все
            if (scanner.hasNextDouble()) {                  // если токен может стать даблом...
                sum = sum + scanner.nextDouble();           // берем его и суем в double sum.

            } else {                                        // если нет - переходим к следующему
                scanner.next();
            }
        }

        System.out.printf("%.6f%n",sum);                    // вывод sum в формате 0.000000 а не 0.0   printf !
        System.out.println(String.format("%.6f",sum));      // или так. тоже самое.
        scanner.close();                                    // закрываем сканер

    }
}


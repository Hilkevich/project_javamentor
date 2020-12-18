/*

Реализуйте предыдущую задачу с использованием рекурсии.

Пример ввода 1: 1
Пример возвращаемого значения 1: 1

Пример ввода 2: 3
Пример возвращаемого значения 2: 6

Требования:
1. Метод должен быть public.
1. Метод должен быть static.
3. Передаваемый параметр должен иметь тип int.
4. Реализация метода должна быть через рекурсию.

 */

package jmeducationplatform.javaCore.task2414;

import java.math.BigInteger;

public class Task2414 {


    public static void main(String[] args) {

        factorial(3);
    }

    public static BigInteger factorial(int value) {

        if( value <= 1 ) {
           return BigInteger.ONE;                  // ONE - это константа, короткая запись вместо valueOf(1).
        } else {
            return BigInteger.valueOf(value).multiply(factorial(value - 1));
        }
    }
}

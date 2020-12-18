/*
Реализуйте метод, возвращающий ответ на вопрос: правда ли, что a + b = c ?
Допустимая погрешность – 0.0001 (1E-4)
Можно использовать класс Math и его методы. Класс Math доступен всегда, импортировать его не надо.
В качестве примера написано заведомо неправильное выражение. Исправьте его.

Требования:
Метод должен иметь сигнатуру: doubleExpression(double a, double b, double c)

 */

package jmeducationplatform.javaCore.task2110;

public class Task2110 {



    public static void main(String[] args) {


        doubleExpression(5.0, 3.0, 9.0);

    }


    public static boolean doubleExpression(double a, double b, double c) {

        double e = 0.0001;
        double x = (a + b);                       // переделка в (решение в 1 строку) в задаче 21102.

        if ( Math.abs (c-x) < e ) {
            return true;
          //  System.out.println("равны");

        }
        else
            return false;
           // System.out.println("не равны");

    }

}

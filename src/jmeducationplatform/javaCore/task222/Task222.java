/*

Реализуйте метод, который возвращает букву, стоящую в таблице UNICODE после символа "\" (обратный слэш) на расстоянии a.
В качестве примера написано заведомо неправильное выражение. Исправьте его.

Требования:
1. Сигнатура метода должна быть: charExpression(int a)

 */

package jmeducationplatform.javaCore.task222;

public class Task222 {

    public static void main(String[] args) {

        charExpression(4);
    }

    private static char charExpression(int a) {

       // char z = '\\';     // почему нельзя поставить '\'? - это экранирование символов!  первый слэш \ становится
                                                           //  экраном т.е как бы щитом для второго слэша и кавычки.
                                                           // иначе компилятор не поймет,что это символ!
      //  int x = z;
        // int x = '\\';      // можно и так, вместо 2-х строк выше.
       // int sum = x + a;
       // char unicode = (char) sum;     // unicode- просто название переменной, можно как угодно.
       // return unicode;

        return (char) ('\\' + a);

    }
}

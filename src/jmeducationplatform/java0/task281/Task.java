/*
Создайте метод public static int getMinFromTwo(int x, int y), который принимает два целочисленных параметра и
возвращает наименьший из них.

Создайте метод public static int getMinFromFour(int x, int y, int m, int n), который принимает четыре целочисленных
параметра и возвращает наименьший из них.

При том  второй метод должен использовать первый.

Требования:
1. Оба метода должны принимать целочисленные параметры
2. Оба метода должны возвращать целочисленные параметры
3. Второй метод должен использовать первый
4. Методы не должны ничего выводить в консоль

 */

package jmeducationplatform.java0.task281;

/**
 * Класс который вычисляет результат задачи.
 */
public class Task {

    /**
     * Точка входа в программу.
     * Вызывает методы для вычисления результата.
     *
     * @param args Параметры.
     */
    public static void main(String[] args) {
        int result = getMinFromFour(3, 3, 5, 6);
        System.out.println(result);
    }

    /**
     * Получает наименьшее значение из четырех параметров.
     *
     * @param a Первое значение.
     * @param b Второе значение.
     * @param c Третее значение.
     * @param d Четвертое значение.
     * @return Наименьшее значение.
     */
    public static int getMinFromFour(int a, int b, int c, int d) {
        int resAB = getMinFromTwo(a, b);
        int resCD = getMinFromTwo(c, d);
        return getMinFromTwo(resAB, resCD);
    }

    /**
     * Получает наименьшее значение из двух параметров.
     *
     * @param x Первое значение.
     * @param y Второе значение.
     * @return Наименьшее значение.
     */
    public static int getMinFromTwo(int x, int y) {
        if (x < y) {
            return x;
        } else return y;
    }
}

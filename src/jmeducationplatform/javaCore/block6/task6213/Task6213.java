/*

Реализуйте метод symmetricDifference, вычисляющий симметрическую разность двух множеств. Метод должен возвращать
результат в виде нового множества. Изменять переданные в него множества не допускается.

Пример ввода: [1, 2, 3} и {0, 1, 2]
Пример вывода: [0, 3]

Требования:
1. должен быть метод public static Set symmetricDifference(Set set1, Set set2)
2. метод symmetricDifference не должен изменять исходные множества
3. метод symmetricDifference должен возвращать корректный результат

 */

package jmeducationplatform.javaCore.block6.task6213;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Task6213 {

    public static void main(String[] args) {

        Set<Integer> a = new HashSet<Integer>();                // 1 коллекция.
        a.addAll(Arrays.asList(new Integer[]{1,3,5}));
        System.out.println("a - " + a);

        Set<Integer> b = new HashSet<Integer>();                // 2 коллекция.
        b.addAll(Arrays.asList(new Integer[]{0,2,5,6}));
        System.out.println("b - " + b);

        symmetricDifference(a,b);                               // вызываем наш метод, подставив в него a(для set1) и b(для set2).
    }


    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {


        Set<T> dif = new HashSet<>(set1);                       // помещаем в dif то, что есть в a(set1) но нет в b(set2)
        dif.removeAll(set2);
        System.out.println("dif = " + dif);

        Set<T> dif2 = new HashSet<>(set2);                      // помещаем в dif2 то, что есть в b(set2) но нет в a(set1)
        dif2.removeAll(set1);
        System.out.println("dif2 = " + dif2);

        dif2.addAll(dif);                                       // и в dif2 добавляем всё из ПОЛУЧИВШЕГОСЯ(!) dif, упорядочивая,..
        System.out.println("finish - " + dif2);                 // ... тем самым получаем список элементов, которые присутствуют...
                                                                // ... лишь в одной из двух коллекций, исключая те, которые...
        System.out.println("set1 - " + set1);                   // ... есть и в первой и во второй.
        System.out.println("set2 - " + set2);                   //     т.е симметрическую РАЗНОСТЬ двух множеств.

        return dif2;

    }
}

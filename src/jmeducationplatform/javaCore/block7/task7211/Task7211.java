/*

Напишите метод, находящий в стриме минимальный и максимальный элементы в соответствии с порядком, заданным Comparator'ом.

Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:
minMaxConsumer.accept(min, max);

Если стрим не содержит элементов, то вызовите:
minMaxConsumer.accept(null, null);

Требования:
1. Должен быть метод public <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer)
2. Метод должен находить минимум и максимум в потоке, с помощью order.
3. Полученные данные должны быть записаны minMaxConsumer, согласно условию.

 */

package jmeducationplatform.javaCore.block7.task7211;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task7211 {

    public static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<? extends T> streamToList = stream.collect(Collectors.toList()); // стрим переводим в List.

        if (streamToList.isEmpty()) {                                         // если пуст...
            minMaxConsumer.accept(null, null);                          // вызываем по условию задачи
            System.out.println("null");

        } else {

            streamToList.sort(order);                                         // иначе сортируем по компаратору order (от мин к макс)
            T min = streamToList.get(0);                                      // у List берем (после сортировки) 1-й элемент (индекс 0)
            T max = streamToList.get(streamToList.size() - 1);                // и последний элемент.
            minMaxConsumer.accept(min, max);                                  // найденные элементы передаем в minMaxConsumer (по условию)
            System.out.println(min + " | " + max);
        }
    }

    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(3, 6, 2, 4, 8);                    // создаем пример стрима
        Comparator<Integer> order = Integer::compareTo;                       // создаем компаратор
        BiConsumer<Integer, Integer> minMaxConsumer = new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer integer, Integer integer2) {
            }
        };
        findMinMax(stream, order, minMaxConsumer);                            // вызываем метод, подставляя созданное.
    }
}

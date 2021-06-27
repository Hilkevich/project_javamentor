package jmeducationplatform.javaCore.block7.task7212c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;


public class Task7212c {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        Arrays.stream(reader
                // Arrays.stream - возвращает последовательный поток с указанным массивом в качестве источника


                .lines()
                // Возвращает Stream, элементами которого являются строки, прочитанные из этого BufferedReader.
                // Stream заполняется лениво, т.е. только чтение происходит во время операции терминального потока.


                .collect(Collectors.joining())
                // collect - выполняет изменяемую операцию сокращения для элементов этого потока с помощью Collector.
                // Терминальная операция.

                // joining - возвращает Collector, который объединяет входные элементы в String в порядке встречи.


                .toLowerCase()
                // Преобразует все символы в этой строке в нижний регистр, используя правила локали по умолчанию.


                .split("[^a-zA-Zа-яА-Я0-9]"))
                // Разбивает эту строку вокруг совпадений с заданным регулярным выражением.


                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                // collect - выполняет изменяемую операцию сокращения для элементов этого потока с помощью Collector.
                // Терминальная операция.

                // groupingBy - возвращает Collector, реализующий каскадную операцию «group by» для входных элементов типа T,
                // группируя элементы в соответствии с функцией классификации, а затем выполняя операцию сокращения
                // для значений, связанных с данным ключом, с использованием указанного нижестоящего Collector.
                // Функция классификации сопоставляет элементы с некоторым ключевым типом K.
                // Последующий сборщик работает с элементами типа T и выдает результат типа D.
                // Результирующий сборщик создает Map <K, D>.

                // counting - возвращает Collector, принимающий элементы типа T, который подсчитывает количество входных
                // элементов. Если элементы отсутствуют, результатом будет 0.


                .entrySet()
                // Возвращает набор отображений, содержащихся на этой карте.


                .stream()
                // Возвращает последовательный Stream с этой коллекцией в качестве источника.


                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()).thenComparing(Map.Entry::getKey))
                // sorted - возвращает поток, состоящий из элементов этого потока, отсортированных в соответствии с
                // предоставленным Comparator.

                // comparingByValue - возвращает компаратор, который сравнивает Map.Entry по значению с использованием
                // данного компаратора.

                // reverseOrder - возвращает компаратор, который устанавливает обратный естественный порядок.

                // thenComparing - возвращает компаратор лексикографического порядка с функцией, которая извлекает ключ
                // сортировки Comparable


                .map(Map.Entry::getKey)
                // map - возвращает поток, состоящий из результатов применения данной функции к элементам этого потока.


                .limit(10)
                // Возвращает поток, состоящий из элементов этого потока, усеченных, чтобы их длина не превышала maxSize.


                .forEach(System.out::println);
                // Выполняет действие для каждого элемента этого потока. Это терминальная операция.

    }
}

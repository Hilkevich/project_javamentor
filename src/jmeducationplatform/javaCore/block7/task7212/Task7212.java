/*

Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов, и
в конце выводящую 10 наиболее часто встречающихся слов.

Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр. Например,
в строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".

Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово.
Выводите слова в нижнем регистре.

Если в тексте меньше 10 уникальных слов, то выводите сколько есть.

Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте,
то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.

Задача имеет красивое решение через стримы без циклов и условных операторов. Попробуйте придумать его.


Пример ввода  1:

Мама мыла-мыла-мыла раму!
Пример вывода  1:

мыла
мама
раму


Пример ввода 2:

Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam,
tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus
imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur
adipiscing elit. Integer vel odio nec mi tempor dignissim.

Пример вывода 2:

consectetur
faucibus
ipsum
lorem
adipiscing
amet
dolor
eget
elit
mi


Требования:

1. Должен быть метод public static void main(String[] args)
2. Программа должна читать данные с консоли
2. Программа должна писать данные в консоль

 */

package jmeducationplatform.javaCore.block7.task7212;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;


public class Task7212 {


    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

//        Map<String, Long> st1 = reader.lines()
//                .flatMap(n -> Arrays.stream(n.split(" ")))
//                .flatMap(n -> Arrays.stream(n.split("-")))
//                .flatMap(n -> Arrays.stream(new String[]{n.replaceAll("[^a-zA-Zа-яА-Я0-9]", "")}))
//                .map(String::toLowerCase)
//                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));       //терминальная

        Arrays.stream(reader.lines()
                .collect(Collectors.joining())
                .toLowerCase()
                .split("[^a-zA-Zа-яА-Я0-9]"))
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()).thenComparing(Map.Entry::getKey))
                .map(Map.Entry::getKey)
                .limit(10)
                .forEach(System.out::println);

//        Map<String, Long> st2 = st1.entrySet().stream()
//                .sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry::getKey))
//                .limit(10)
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
//
//        List<String> list = new LinkedList(st2.keySet());
//
//        list.forEach(System.out::println);

    }
}


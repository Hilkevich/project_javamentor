package jmeducationplatform.javaCore.block7.task7212b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;


public class Task7212b {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
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

    }
}

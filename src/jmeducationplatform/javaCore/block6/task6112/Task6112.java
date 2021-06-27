/*

Реализуйте generic-класс Pair, похожий на Optional, но содержащий ПАРУ элементов разных типов и НЕ запрещающий
элементам принимать значение null.

Реализуйте методы getFirst(), getSecond(), equals() и hashCode(), а также статический фабричный метод of().
Конструктор должен быть закрытым (private).

С корректно реализованным классом Pair должен компилироваться и успешно работать следующий код:


Pair<Integer, String> pair = Pair.of(1, "hello");
Integer i = pair.getFirst(); // 1
String s = pair.getSecond(); // "hello"
Pair<Integer, String> pair2 = Pair.of(1, "hello");
boolean mustBeTrue = pair.equals(pair2); // true!
boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!

Пожалуйста, не меняйте модификатор доступа класса Pair. Для корректной проверки класс должен иметь пакетную видимость.

 */

package jmeducationplatform.javaCore.block6.task6112;

import java.util.Objects;
import java.util.Optional;


public class Task6112 {

    public static class Pair<Integer, String> {      // параматризованный класс


        private Integer i;                           // поля
        private String s;

        private Pair(Integer i, String s) {           // конструктор (автосгенерированный Alt+Insert)
            this.i = i;
            this.s = s;
        }

        public Integer getFirst() {                   // геттер для Integer (автосгенерированный Alt+Insert)
            return i;
        }

        public String getSecond() {                   // геттер для String (автосгенерированный Alt+Insert)
            return s;
        }

        public static <T> Pair of(T i, T s) {         // изменили метод of из Optional (держим Ctrl и наводим на Optional)

            return new Pair<>(i, s);
        }

        @Override
        public boolean equals(Object o) {             // автосгенерированный (Alt+Insert)
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(i, pair.i) && Objects.equals(s, pair.s);
        }

        @Override
        public int hashCode() {                       // автосгенерированный (Alt+Insert)
            return Objects.hash(i, s);

        }
    }

    public static void main(String[] args) {

        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!

    }
}

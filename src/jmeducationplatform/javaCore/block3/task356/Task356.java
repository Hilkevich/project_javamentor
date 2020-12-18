/*

Напишите статический класс AsciiCharSequence, реализующий компактное хранение последовательности ASCII-символов
 (их коды влезают в один байт) в массиве байт. По сравнению с классом String, хранящим каждый символ как char,
  AsciiCharSequence будет занимать в два раза меньше памяти.

Класс AsciiCharSequence должен:

реализовывать интерфейс java.lang.CharSequence;
иметь конструктор, принимающий массив байт;
определять методы length(), charAt(), subSequence() и toString()

Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса java.lang.CharSequence
 (JavaDoc или исходники).

В данном задании методам charAt() и subSequence() всегда будут подаваться корректные входные параметры, поэтому
 их проверкой и обработкой ошибок заниматься не нужно. Тем более мы еще не проходили исключения.

 */

package jmeducationplatform.javaCore.block3.task356;

import java.util.Arrays;

public class Task356 {

    interface CharSequence {

        int length();

        char charAt(int index);

        CharSequence subSequence(int start, int end);

        String toString();

    }

    public static class AsciiCharSequence implements CharSequence {

       private byte[] example;


        public AsciiCharSequence(byte[] example) {           //конструктор класса AsciiCharSequence.

            this.example = example;

        }


        @Override

        public int length() {

            return example.length;

        }

        @Override

        public char charAt(int index) {

            return (char) example[index];
        }

        @Override

        public CharSequence subSequence(int start, int end) {

            return new AsciiCharSequence(Arrays.copyOfRange(example, start, end));

        }

        @Override

        public String toString() {

           // StringBuilder x = new StringBuilder();

           // for (int i = 0; i < example.length; i++) {

              //  x.append((char) example[i]);
           // String s = new String(example);

              return new String(example);           // исправил!!! в 4 слова! ппц!

        }
           // return x.toString();
        }
    //}

    public static void main(String[] args) {

        byte[] example = {72, 101, 108, 108, 111, 33};



        AsciiCharSequence answer = new AsciiCharSequence(example);

        System.out.println("последовательность = " + answer.toString());
        System.out.println("размер её = " + answer.length());
        System.out.println("символ под №1 = " + answer.charAt(1));
        System.out.println("подпоследовательность = " + answer.subSequence(1, 5));
        example[0] = 74; // 74 в таблице = J
        System.out.println("обновленная последовательность = " + answer.toString());

    }
}


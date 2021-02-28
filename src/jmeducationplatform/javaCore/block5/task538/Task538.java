package jmeducationplatform.javaCore.block5.task538;/*

Какими байтами представляется символ 'Ы' в кодировке UTF-8?
Введите десятичные беззнаковые значения байт через пробел, например, 10 34 254.

 */

public class Task538 {

    public static void main(String[] args) {

        String s = "Ы";
        byte [] b = s.getBytes();
        for (int i = 0; i < b.length; i++) {
            System.out.print(((int)b[i] ^ -1 << 8) + " ");
        }
    }
}

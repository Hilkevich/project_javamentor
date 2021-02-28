/*

Напишите метод int sumOfStream(InputStream inputStream), который принимает InputStream и возвращает сумму всех его
элементов.

Пример ввода: 1, 2, 4, 10

Пример вывода: 17

Требования:
1. Метод должен быть публичным.
2. Параметр должен иметь тип InputStream.
3. Сигнатура метода должна быть: sumOfStream(InputStream inputStream)

 */

package jmeducationplatform.javaCore.block5.task527;

import java.io.*;

public class Task527 {

    public static void main(String[] args) {


        try {
            InputStream input = new FileInputStream("E:/1.txt");    // создаем объект,проверяя его на исключения. Путь к реальному файлу на диске.

            try {
                sumOfStream(input);       // вызываем метод (подставив в него созданный объект),проверяя на исключения.

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static int sumOfStream(InputStream inputStream) throws IOException {

        int buf;
        int result = 0;

        try {
            while ((buf = inputStream.read()) != -1) {   // засовываем в b то, что вычитали из inputStream, но пока в нем есть что-то.(т.е не -1).
                result = result + (byte) buf;            // приводим к byte, т.к в потоке могут быть отрицат. числа.(иначе выдает ошибку на платформе)
                System.out.print("|" + result);
            }

        } catch (IOException ignore) {

        } finally {

            try {
                inputStream.close();

            } catch (IOException ignore) {

            }
        }
        System.out.println("\nрезультат: " + result);
        return result;

    }

}



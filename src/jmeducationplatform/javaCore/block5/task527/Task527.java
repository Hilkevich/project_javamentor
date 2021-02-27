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

//        InputStream input = null;
//
//        try {
//            input = new FileInputStream("C:/1.txt");
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        System.out.print("input: " + input);

    }

    public int sumOfStream(InputStream inputStream) throws IOException {


        int buf;
        int result = 0;

     //   try {
            while ((buf = inputStream.read()) != -1) {   // засовываем в b то, что вычитали из inputStream, но пока в нем есть что-то.(т.е не -1).
                result = result + (byte)buf;             // приводим к byte, т.к в потоке могут быть отрицат. числа.(иначе выдает ошибку на платформе)
                System.out.println("result:" + result);
            }

       // } catch (IOException ignore) {

       // } finally {

           // try {
              //  inputStream.close();

           // } catch (IOException ignore) {

           // }
       // }

        return result;

    }

}



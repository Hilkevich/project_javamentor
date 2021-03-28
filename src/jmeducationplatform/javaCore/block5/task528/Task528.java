/*

Напишите метод void print(InputStream inputStream, OutputStream outputStream) который принимает InputStream
и OutputStream, считывает все байты из inputStream и записывает в OutputStream только четные.

Пример ввода: 3, 10, 4, 5, 7

Пример вывода: 10, 4

Требования:
1. Метод должен быть публичным.
2. Параметры должны иметь тип InputStream inputStream и OutputStream outputStream.
3. Сигнатура метода должна быть: print(InputStream inputStream, OutputStream outputStream)

 */

package jmeducationplatform.javaCore.block5.task528;

import java.io.*;                                                     // импортируем библиотеку (автоматически при создании потоков).

public class Task528 {

    public static void main(String[] args) throws IOException {       // лучше еще обработать объекты в main!


        InputStream inp= new FileInputStream("E:/1.txt");       // создаем объект откуда читаем. путь на реальный файл на диске E:
        OutputStream outp = new FileOutputStream("E:/2.txt");   // создаем объект куда пишем. путь на реальный файл на диске E:
        print(inp,outp);                                              // вызываем метод подставив в него эти объекты.
    }


               // сюда подставятся объект   inp            а сюда      outp
    public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {
                                      // inputStream       и       outputStream - произвольные имена, видны только внутри метода.

        int inByte;                                          // переменная для сохранения байтов, доставаемых из потока inputStream (он же inp).

       // try {     // удаляем все try/catch нет в условии этого.

            while ((inByte = inputStream.read()) != -1) {   // читаем поток по 1 байту, записывая каждый в inByte, пока поток не == -1.(т.е пусто)
                System.out.print(" | " + inByte);
                if ( inByte % 2 == 0){                     // если остаток от деления байта == 0 (т.е четный)...


                    outputStream.write(inByte);            // ...пишем в поток outputStream по 1 байту из переменной, куда каждый сохраняется.
                    System.out.print(" четное");

                }
                outputStream.flush();                  // добавил, на платформе прошла, но после ментора перестала проходить без flush().
                System.out.print(" ЧЕТНОЕ");

            }

       // } catch (FileNotFoundException f) {               // ловим возможные ошибки. Сначала мелкие...
           // f.printStackTrace();

      //  } catch (IOException e) {                         // ...потом крупнее, что б не пропали мелкие.
           // e.printStackTrace();

      //  } finally {                                       // сюда заходим в любом случае (что бы полюбому закрыть потоки).

           // try {
               // inputStream.close();                      // закрываем входной поток.
               // outputStream.close();                     // закрываем выходной поток.

           // } catch (IOException ignore) {                // ловим возможные ошибки при закрытии. Игнорируем.
                      // пусто
            }
        }
   // }
// }

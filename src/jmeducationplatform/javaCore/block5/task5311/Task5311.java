/*

Реализуйте метод, который зачитает данные из InputStream и преобразует их в строку, используя заданную кодировку.

Пример:
InputStream последовательно возвращает четыре байта: 48 49 50 51.
Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть строку: "0123".

Требования:
1. Метод должен быть публичным.
2. Сигнатура метода должна быть: readAsString(InputStream inputStream, Charset charset)

 */

package jmeducationplatform.javaCore.block5.task5311;

import java.io.*;
import java.nio.charset.Charset;


public class Task5311 {

    public static void main(String[] args) throws IOException {

        InputStream inp = new FileInputStream("E:/1.txt");          // откуда читаем.
        readAsString(inp, Charset.forName("ASCII"));                      // вызывам метод подставляя в него данные так.

    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {  //убрать try/catch не закрывать потоки!


        Reader reader = new InputStreamReader(inputStream, charset);     // как бы оборачиваем читалкой наверно?
        Writer writer = new CharArrayWriter();                              // писалка)? лучше так, но и = new StringWriter() тоже катит!
        int inByte;                                                      // переменная для вычитаных байтов, но сама она int!

       // try {
            while ((inByte = reader.read()) != -1) {                     // читаем уже reader! а не inputStream. Засовываем по 1 байту в inByte, проверяя на конец данных в потоке.
                System.out.println("до " + inByte);
                writer.write(inByte);                                    // у переменной ( т.е объекта) с именем write вызываем метод write, подставив в него- от куда?, из inByte...
                System.out.println("после " + writer);                   // ...т.е в inByte падает по 1 байт (т.е число) а writer.write() это число переделывает в символ и записывает себе!
            }

       // } catch (IOException ioe) {
           // ioe.printStackTrace();

       // } //finally {

           // try {
               // reader.close();                                          // закрываем поток.

           // } catch (IOException ignore) {
                   // пусто
           // }
            System.out.println(writer);                                 // напечатает то нормальное "Hello Java!" что засунули в inputStream...
            return writer.toString();                                   // ..но все равно приводим к String, иначе не вернет. ( тип то Writer а не String).
        }
    }
//}

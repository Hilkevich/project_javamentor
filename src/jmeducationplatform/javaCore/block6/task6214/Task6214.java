/*

Напишите программу, которая прочитает из System.in последовательность целых чисел, разделенных пробелами, затем
удалит из них все числа, стоящие на четных позициях, и затем выведет получившуюся последовательность в обратном
порядке в System.out.

Все числа влезают в int. Позиции чисел в последовательности нумеруются с нуля.

Все import объявлены за вас.

Пример ввода: 1 2 3 4 5 6 7 8 9 10
Пример вывода: 10 8 6 4 2

Требования:
1. Необходимо наличие метода public static void main(String[] args)
2. Программа должна читать данные из консоли
3. Программа должна выводить текст в консоль

 */

package jmeducationplatform.javaCore.block6.task6214;

import java.util.*;

public class Task6214 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);         // объявляем сканнер.
        ArrayDeque<String> deque = new ArrayDeque();      // объявляем коллекцию.
        System.out.println("Введите целые числа...");

        while (scanner.hasNext()) {                       // вернет true, если и только если у этого сканера есть другой токен.
            scanner.next();                               // находит и возвращает СЛЕДУЮЩИЙ полный токен из этого сканера.
            if (scanner.hasNext()) {                      // вернет true, если и только если у этого сканера есть другой токен.
                deque.addFirst(scanner.next());           // добавить в НАЧАЛО коллекции (с именем deque) следующий полный токен из этого сканера.
            }
        }
        System.out.println(deque);                        // пока готовый deque выглядит как массив - [10, 8, 6, 4, 2], но далее..

        System.out.print(String.join(" ", deque));// String.join вернет новую СТРОКУ,состоящую из элементов deque,с разделителем "пробел".

    }
}



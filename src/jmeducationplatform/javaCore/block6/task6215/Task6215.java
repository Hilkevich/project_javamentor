/*

Магазину нужно сохранять информацию о продажах для каждого сотрудника. Напишите метод Map getSalesMap(Reader reader)
который принимает Reader содержащий строки вида:

Алексей 3000
Дмитрий 9000
Антон 3000
Алексей 7000
Антон 8000

Метод должен получить все строки из Readera и заполнить и вернуть карту где ключом будет имя сотрудника, а значением
сумма всех его продаж.

Пример ввода:

Алексей 3000
Дмитрий 9000
Антон 3000
Алексей 7000
Антон 8000

Пример вывода:
{Алексей=[10000], Дмитрий=[9000], Антон=[11000]}

Требования:
1. Должен быть метод public static Map<String, Long> getSalesMap(Reader reader)
2. Работа метода getSalesMap должна удовлетворять условию

 */

package jmeducationplatform.javaCore.block6.task6215;

import java.io.*;
import java.util.*;

public class Task6215 {

    public static void main(String[] args) throws FileNotFoundException {

        String s = "Алексей 3000\n" +                                                  // копируем из примера ввода.
                "Дмитрий 9000\n" +
                "Антон 3000\n" +
                "Алексей 7000\n" +
                "Антон 8000";

        Reader reader = new StringReader(s);                        // создаем Reader, читающий строки.
        // Reader reader = new FileReader("E:\\3.txt");             // или с путем к файлу, в котором лежат эти строки.

        getSalesMap(reader);                                 // вызываем метод, подставив в него reader со строками(s).

    }

    public static Map<String, Long> getSalesMap(Reader reader) {

        Map<String, Long> SalesMan = new HashMap<String,Long>();                                  // создаем Map.
        Scanner scanner = new Scanner(reader);                                                     // создаем Scanner.

        while (scanner.hasNext()) {                                                    // если в сканере что то есть...
            SalesMan.merge(scanner.next(), scanner.nextLong(), (a, b) -> b + a);       // в мапу сначала идет строка - это ключ,
            // потом число - это значение. к значению(это b) ключа(это a), встретившегося повторно, прибавляем это новое значение!
        }
        System.out.println(SalesMan);                                    // {Алексей=10000, Антон=11000, Дмитрий=9000}
                                               // т.е Алексей=10000 это Алексей 3000 + снова тот же Алексей 7000 и т.д
        return SalesMan;
    }
}

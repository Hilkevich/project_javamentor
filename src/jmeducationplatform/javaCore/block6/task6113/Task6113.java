/*

Массивы в Java имеют фиксированную длину. Попробуем обойти это ограничение. Создайте класс DynamicArray, который хранит
в себе массив, и имеет методы для добавления void add(T el), void remove(int index) удаления
и извлечения T get(int index) из него элементов, при переполнении текущего массива, должен создаваться новый,
большего размера.

Для возможности работы с различными классами DynamicArray должен быть дженериком. Для решения задачи можно
воспользоваться методами из класса java.util.Arrays. Импорт этого класса уже объявлен в тестирующей системе.
Добавлять его явно не нужно

Требования:
1. должен быть класс public static class DynamicArray
2. класс DynamicArray должен иметь методы публичные void add(T el), void remove(int index) и T get(int index)
3. класс DynamicArray должен  иметь публичный конструктор по умолчанию
3. работа методов должна соответствовать условию

 */

package jmeducationplatform.javaCore.block6.task6113;

import java.util.Arrays;
public class Task6113 {

    public static class DynamicArray<T> {

        private T[] arr = (T[]) new Object[10];           // массив для хранения чегото.
        int index = 0;                                    // поле-счетчик, кол-во элементов в массиве.


        public void add(T el) {                           // метод для добавления элементов в массив.
            if (index >= arr.length) {
                arr = Arrays.copyOf(arr, index * 2);    // а было так - newLength: arr.length + 10
            }
            arr[index++] = el;
        }

        public void remove(int index) {                   // метод для удаления элементов из массива.

            T[] arr2 = (T[]) new Object[arr.length - 1];
            System.arraycopy(arr, 0, arr2, 0, index);
            System.arraycopy(arr, index + 1, arr2, index, arr.length - index - 1);
            arr = arr2;
            System.out.println(Arrays.toString(arr));

        }

        public T get(int index) {                         // метод для извлечения элементов из массива.

            return arr[index];
        }
    }

    public static void main(String[] args) {

        DynamicArray<Integer> a = new DynamicArray<>();

        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        a.add(9);
        a.add(10);
        a.add(11);
        a.add(12);

        System.out.println(a.get(2));
        a.remove(2);
        System.out.println(a.get(2));

    }
}

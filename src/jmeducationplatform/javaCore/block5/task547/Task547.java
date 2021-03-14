/*

Дан сериализуемый класс Animal:

class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }
}

Реализуйте метод, который из переданного массива байт восстановит массив объектов Animal. Массив байт устроен следующим
образом. Сначала идет число типа int, записанное при помощи ObjectOutputStream.writeInt(size). Далее подряд записано
указанное количество объектов типа Animal, сериализованных при помощи ObjectOutputStream.writeObject(animal).

Если вдруг массив байт не является корректным представлением массива экземпляров Animal, то метод должен бросить
исключение java.lang.IllegalArgumentException.

Причины некорректности могут быть разные. Попробуйте подать на вход методу разные некорректные данные и посмотрите,
какие исключения будут возникать. Вот их-то и нужно превратить в IllegalArgumentException и выбросить. Если что-то
забудете, то проверяющая система подскажет. Главное не глотать никаких исключений, т.е. не оставлять нигде пустой catch.

Требования:
1. Метод должен быть публичным.
2. Сигнатура метода должна быть: Animal[] deserializeAnimalArray(byte[] data)

 */

package jmeducationplatform.javaCore.block5.task547;

import java.io.*;
import java.util.Arrays;

public class Task547 {

    public static void main(String[] args) {

        byte[] intermediate = null;

        try (
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(output)) {

            oos.writeInt(3);
            oos.writeObject(new Animal("Dog"));
            oos.writeObject(new Animal("Cat"));
            oos.writeObject(new Animal("Mouse"));

            output.flush();
            intermediate = output.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();

        }

        System.out.println(Arrays.toString(intermediate));
        Animal[] animals = deserializeAnimalArray(intermediate);
        System.out.println(Arrays.toString(animals));

    }

    public static Animal[] deserializeAnimalArray(byte[] data) {

        Animal[] animals;                      // объявляем ссылку animals, типа Animal[] (и инициализируем ее null.)

        try (ByteArrayInputStream bis = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(bis)) {

            int animalCount = ois.readInt();   // читаем сколько в массиве объектов, складываем в animalCount.
            System.out.println("в массиве: " + animalCount);
            animals = new Animal[animalCount]; // создаем массив размерностью заданной длины и присваиваем его ссылке animals.

            for (int i = 0; i < animalCount; i++) {

                try {
                    animals[i] = (Animal) ois.readObject();  // прочитываем объекты, даункастим к типу Animal, засовываем Animal[] animals
                    System.out.println(animals[i]);

                } catch (ClassCastException | ClassNotFoundException e) {
                    throw new IllegalArgumentException();
                }
            }

        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

        return animals; // возвращаем ссылку на объект.
    }
}


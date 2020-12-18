/*

Создайте класс Cat и класс Dog. В классе Cat должен быть метод sayHello(), который выводит в консоль "Мяу!",
 аналогично с собакой, но выводит "Гав!". Так же, у собаки должен быть метод catchCat (поймать кошку), который
 принимает кошку и дальше делает следующее:


1) выводит в консоль сообщение "Кошка поймана"
2) У собаки, которая поймала кошку должен быть вызван метод sayHello()
3) У кошки, которую поймала собака должен быть вызван метод sayHello()

Требования:
1. Должен быть класс public static class Cat
2. Должен быть класс public static class Dog
3. Все методы должны быть public
4. Кошка должна говорить “Мяу!”
5. Собака должна говорить “Гав!”
6. Собака должна ловить кошку

 */

package jmeducationplatform.javaCore.block3.task3311;

public class Task3311 {


    public static void main(String[] args) {
        Cat cat = new Cat();                          // создаем экземпляр класса (он же объект) Cat с именем cat.
        Dog dog = new Dog();                          // создаем экземпляр класса (он же объект) Dog с именем dog.
        dog.catchCat(cat);                            // вызываем у класса Dog метод.
    }


    public static class Cat {                          // создаем класс Cat

        public void sayHello() {                       // метод класса Cat
            System.out.println("Мяу!");                // чё делает
        }
    }

    public static class Dog {

        public void sayHello() {
            System.out.println("Гав!");
        }

        public void catchCat(Cat cat) {                // метод класса Dog принимает объект(экземпляр) cat класса Cat.

            System.out.println("Кошка поймана");       // чё делает метод - пишет Кошка поймана
            sayHello();                                // свой метод - пишет (Гав!)
            cat.sayHello();                            // кошкин метод - пишет (Мяу!)
        }
    }
}


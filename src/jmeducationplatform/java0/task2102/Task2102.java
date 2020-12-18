/*      Cоздайте public static (мы делаем класс статическим исключительно для корректной работы проверяющей системы)
        класс Human, содержащий поля String name и int age.

        У класса Human должен быть метод public void sayHello(), который выводит в консоль,
        “Привет, меня зовут {name}, мне {age} лет.”.

        В методе main создайте объект класса Human, заполните его поля и вызовите метод sayHello().

        Требования:
        1. Класс Human должен иметь поля String name и int age
        2. В классе Human должен быть публичный конструктор конструирующий поля String name и int age
        3. Метод sayHello() не должен ничего возвращать
        4. В методе main должен быть создан объект класса Human
        5. Поля объекта должны быть заполнены
        6. У объекта класса Human должен быть вызван метод sayHello()
        7. Класс Human должен быть статическим, метод main находится вне этого класса

 */

        package jmeducationplatform.java0.task2102;


        public  class Task2102 {

            public static class Human {

                String name;         //обЪявленные поля
                int age;

                public Human(String name,int age) {        //  КОНСТРУКТОР
                    this.name = name;                      //обращение видно по цветам,-
                                              // что к чему относится: фиолетовый this.name к фиолет String name..
                    this.age = age;
                }

                /**
                 * метод, выводящий в кансоль строку с подставляемыми параметрами
                 */

                public void sayHello() {
                    System.out.println("Привет, меня зовут " + name + "," + " мне " + age + " лет.");
                }
            }

            public static void main(String[] args) {

                Human tom = new Human("Михаил", 35);    //создание обЪекта с инициализироваными параметрами
                tom.sayHello();                                   // вызов метода

            }


        }


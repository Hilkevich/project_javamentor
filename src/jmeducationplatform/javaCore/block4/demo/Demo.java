package jmeducationplatform.javaCore.block4.demo;



public class Demo {

    public static void main(String[] args) {

        System.out.println(Car.getCount());                        // сколько создано машин.
        Car car1 = new Car("жига", "красный");
        Car car2 = new Car("жига", "красный");
        Car car3 = new Car("иж", "зеленый");
        Car car4 = new Car("нива","хаки");
        System.out.println(Car.getCount());                        //  сколько теперь создано машин?

        System.out.println(car1.getColor());                       // car1 получить цвет
        System.out.println(car2.getModel());                       // car2 получить модель
        car1.setColor("синий");                                    // car1 заменить цвет на синий
        System.out.println(car1.getColor());                       // car1 получить цвет
        car2.setModel("бмв");                                      // car2 заменить модель на бмв
        car2.setColor("в крапинку");                               // car2 заменить цвет на в крапинку
        System.out.println(car2.getModel() + " " + car2.getColor());    // car2 распечатать модель и цвет
        System.out.println(car3.getModel() + " " + car3.getColor());    // car3 распечатать модель и цвет
        System.out.println(Car.getCount());                             // car счетчик сколько произвели

        System.out.println(car1.getModel() + " " + car1.getColor());
        System.out.println(" ");
        System.out.println(car1 == car2);                        // почему не равны. выяснить!
        System.out.println(car1.equals(car2));                   // почему?
        System.out.println(car1.getClass());
        System.out.println(car1.toString());
        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
        System.out.println(car4.getModel() + " " + car4.getColor());

    }
}

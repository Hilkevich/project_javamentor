package jmeducationplatform.javaCore.block4.demo;

public class Car {

    private String model;
    private String color;
    private static int count;     //относится только к классу, общая переменная.

    public Car(String model, String color) {           // создали нужный нам конструктор с 2 мя параметрами

        this.model = model;
        this.color = color;
        count = count + 1;                            // переменная счетчик, если все (т.е 2) поля проинициализированы
    }                                                 // (т.е заполнены,созданы) присвоить count +1
    public String getColor() {                        // геттер ( получить ) цвет

         return color;
    }
    public String getModel() {

         return model;
    }
    public void setColor(String color) {              // сеттер ( установить ) цвет

        this.color = color;
    }

    public void setModel(String model) {

        this.model = model;
    }
    public static int getCount() {                     // получить (посмотреть) count (сколько создали машин)


        return count;
    }
}

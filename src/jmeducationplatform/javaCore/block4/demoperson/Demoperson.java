package jmeducationplatform.javaCore.block4.demoperson;

public class Demoperson {

    public static void main(String[] args) {

        Person John = new Person("male",23);
        John.sayHello();
        System.out.println("");
        Person Kat = new Person("kat","smith",20,"female");
        Kat.sayHello();

    }
}

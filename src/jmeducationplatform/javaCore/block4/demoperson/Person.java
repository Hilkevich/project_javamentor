package jmeducationplatform.javaCore.block4.demoperson;

public class Person {

    private String name;
    private int age;
    private String surname;
    private String gender;


    public Person(String name, String surname, int age, String gender){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public Person(String gender, int age) {
        this.gender = gender;
        this.age = age;
    }

    public Person(){
    }

    public void sayHello(){
        System.out.println("Hello,my name is " + name + "!");
    }
}

package jmeducationplatform.javaCore.block4.demoperson;

public class Person {

    private String name;
    private int age;                        // поля
    private String surname;
    private String gender;




    public Person(String name, String surname, int age, String gender){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public Person(String gender, int age) {                          // конструкторы
        this.gender = gender;
        this.age = age;
    }

    public Person(){
    }



    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;                              // сеттеры\геттеры
    }
    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }




    public void sayHello(){                                                    // методы.
        System.out.println("Hello,my name is " + name + "!");
    }

    public void sayOllAboutYourSelf(){
        System.out.println("Hello, my name is " + name + " " + surname + "!" + "\nI'm " + age + " ears old and my gender " + gender + ".");
    }

    public void sayAge(){
        System.out.println("Hello, my age is " + age);
    }
}

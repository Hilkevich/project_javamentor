package jmeducationplatform.javaCore.block4.demoperson;

public class Demoperson {

    public static void main(String[] args) {

        Person John = new Person("John","Deer",23,"male");
        Person Kat = new Person("Kat","Smith",20,"female");
        Person Bob = new Person("male",45);
        Person Nik = new Person();
        Person[] ollPerson = new Person[]{John,Kat,Bob,Nik};
        Nik.setName("Nik");
        Nik.setSurname("Dow");


        John.sayOllAboutYourSelf();
        System.out.println(" ");

        Kat.sayOllAboutYourSelf();
        System.out.println(" ");

        Bob.sayAge();
        System.out.println("");

        Nik.sayOllAboutYourSelf();
        System.out.println("Nik surname: " + Nik.getSurname() + "!");


    }

    public Person createPerson(Person[] ollPerson){


         return new Person();

    }
}

package jmeducationplatform.javaCore.block5.inputstreamdemo;

public class Mixer {

   private Cement cement;

    public Mixer(Cement cement) {
        this.cement = cement;
    }
    public Concrete getConcrete(int count){
        System.out.println("мешаю цемент...");

        if (count > cement.getCount()){
            System.out.println("Извините,такого количества цемента нет");
        }else {
            System.out.println("Выгружаем " + count + " кг.");
        }

        return new Concrete(count);
    }
}

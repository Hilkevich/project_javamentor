package jmeducationplatform.javaCore.block5.inputstreamdemo;

public class Main {

    public static void main(String[] args) {
        Mixer mixer = new Mixer(new Cement("M500", 1000));

       mixer.getConcrete(2000);
    }
}

package jmeducationplatform.javaCore.block3.task356test;


import jmeducationplatform.javaCore.block3.task356.Task356;

public class Task356test {                                    // по приколу. посмотреть распечатку массива!)
    
    public static class Test{
        
        private byte[] x;

        public Test(byte[] x) {
            this.x = x;
        }

        
        public String toString() {
            
            return new String(x);                             // приводим byte[] x  к String!!!
        }
    }
    public static void main(String [] args) {

        byte[] x = {112, 101, 103, 97, 115};                     //подставляем числа и читаем) pegas!

        Test answer = new Test(x);

        System.out.println(x);
        System.out.println (answer.toString());
    }
    
}

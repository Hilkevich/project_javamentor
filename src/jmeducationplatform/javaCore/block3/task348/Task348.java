/*

Дан класс ComplexNumber. Переопределите в нем методы equals() и hashCode() так, чтобы equals() сравнивал экземпляры
 ComplexNumber по содержимому полей re и im, а hashCode() был бы согласованным с реализацией equals().

Реализация hashCode(), возвращающая константу или не учитывающая дробную часть re и im, засчитана не будет

Пример

ComplexNumber a = new ComplexNumber(1, 1);
ComplexNumber b = new ComplexNumber(1, 1);
// a.equals(b) must return true
// a.hashCode() must be equal to b.hashCode()

Подсказка 1. Поищите в классе java.lang.Double статический метод, который поможет в решении задачи.

Подсказка 2. Если задача никак не решается, можно позвать на помощь среду разработки, которая умеет сама генерировать
 equals() и hashCode(). Если вы воспользовались помощью IDE, то разберитесь, что было сгенерировано и почему оно
 выглядит именно так. Когда вас на собеседовании попросят на бумажке реализовать equals() и hashCode() для
  какого-нибудь простого класса, то среда разработки помочь не сможет.

Требования:
1. Должен быть класс public static class ComplexNumber
2. Класс ComplexNumber должен иметь поля re и im типа double
3. Класс ComplexNumber должен переопределять public boolean equals(Object o) и public int hashCode()
4. equals и hashcode должны корректно работать

 */

package jmeducationplatform.javaCore.block3.task348;

import java.util.Objects;

public class Task348 {

    public static class ComplexNumber {
        private double re;
        private double im;

        public ComplexNumber() {
        }

        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }

        @Override                             //анотация override,подскажет если будет ошибка в переопределении.

        public boolean equals(Object o) {    //автосгенерированые методы. (правой кнопкой->generate->equals & hashCode.
            if (this == o) {                 // или просто alt + insert..
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ComplexNumber that = (ComplexNumber) o;
            return Double.compare(that.re, re) == 0 && Double.compare(that.im, im) == 0;
        }

        @Override

        public int hashCode() {

            final int prime = 31;
            double result = 1;
            long temp;
            temp = Double.doubleToLongBits(re);
            result = prime * result + (int) (temp ^ (temp >>> 3));
            temp = Double.doubleToLongBits(im);
            result = prime * result + (int) (temp ^ (temp >>> 3));
            return (int) result;

            //  return java.util.Objects.hash(re, im);

        }

        //return Objects.hash(re, im);//на платформе требует полное имя пакета: return java.util.Objects.hash(re, im);

    }


    public static void main(String[] args) {

        ComplexNumber a = new ComplexNumber(5.2d, 6.3d);
        ComplexNumber b = new ComplexNumber(5.2d, 6.3d);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }

}

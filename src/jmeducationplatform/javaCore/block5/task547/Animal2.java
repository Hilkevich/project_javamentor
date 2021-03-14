package jmeducationplatform.javaCore.block5.task547;

import java.io.Serializable;
import java.util.Objects;

public class Animal2 implements Serializable{

        private final String name;
       // private final int age;

        public Animal2 (String name
                        //int age
                        ) {
            this.name = name;
            //this.age = age;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof jmeducationplatform.javaCore.block5.task547.Animal) {
                return Objects.equals(name, ((jmeducationplatform.javaCore.block5.task547.Animal2) obj).name);
            }
            return false;
        }
    }


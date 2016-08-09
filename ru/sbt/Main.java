package ru.sbt;

import ru.sbt.beanutils.BeanUtils;
import ru.sbt.classesfortest.Dog;
import ru.sbt.classesfortest.Person;

/**
 * Created by Артем on 09.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person("Artyom", 21);
        Dog dog = new Dog("Nessi", 3);
        BeanUtils.assign(person, dog);

        System.out.println(person.getName() + " " + person.getAge());
    }
}

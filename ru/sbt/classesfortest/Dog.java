package ru.sbt.classesfortest;

/**
 * Created by Артем on 09.08.2016.
 */
public class Dog {
    private String name;
    private int age;
    private int dogAge;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
        this.dogAge = age * 5;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void setDogAge(int dogAge) {
        this.dogAge = dogAge;
    }

    public String getName() {

        return name;
    }

    public int getAge() {
        return age;
    }


    public int getDogAge() {
        return dogAge;
    }
}

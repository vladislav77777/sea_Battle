package com.Animal;

import java.util.Arrays;
import java.math.*;

public abstract class Animal {
    protected String name;
    protected int height;
    protected int weight;
    protected String colour;
    private int check = 5;
    String sound;

    public Animal(String name, int height, int weight, String colour, String sound) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.colour = colour;
        this.sound = sound;
    }

    abstract public void eat();

    // public void MakeSound(){
//        System.out.println("It says some sounds");
//    }
    void MakeSound() {
        System.out.println(name + " says : " + sound);
    }

    public int getCheck() {
        return check;
    }

    public static void main(String[] args) {

        Animal obj1 = new Dog("Robin", 123, 45, "red", "Gav");
        Animal obj2 = new Cow("Murka", 500, 800, "white", 25, "Moo");
        Cow obj3 = new Cow("Murka", 500, 800, "white", 25, "Moo");

//        Animal[] animals = new Animal[2];
//        animals[0] = new Dog("Robin", 123, 45, "red");
//        animals[1] = new Cow("Murka", 500, 800, "white", 25);
//
//
//        System.out.println(Arrays.toString(animals));
        obj1.eat();
        obj1.MakeSound();
        obj2.eat();
        obj3.getSize_of_horns();
        System.out.println(((Cow) obj2).getSize_of_horns());
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", colour='" + colour + '\'' +
                ", check=" + check +
                '}';
    }


}

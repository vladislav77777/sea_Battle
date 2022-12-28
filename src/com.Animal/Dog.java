package com.Animal;

public class Dog extends Animal{

    public Dog(String name, int height, int weight, String colour, String sound) {
        super(name, height, weight, colour, sound);
    }

    @Override
    public void eat() {
        Cow obj4 = new Cow("Murka", 500, 800, "white", 25, "Moo");
        System.out.println("The dog eats meat");
    }
}

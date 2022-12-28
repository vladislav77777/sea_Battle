package com.Animal;

public class Cow extends Animal{
    private int Size_of_horns;

    public Cow(String name, int height, int weight, String colour, int Size_of_horns, String sound) {
        super(name, height, weight, colour, sound);
        this.Size_of_horns = Size_of_horns;
    }

    @Override
    public void eat() {
        System.out.println("The cow eats grass");
    }

    public int getSize_of_horns() {
        return Size_of_horns;
    }
}


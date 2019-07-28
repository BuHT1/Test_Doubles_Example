package com.company.examplefortests.firstexample;

import java.util.Random;

public class Example {
    Random random;

    public Example(Random random) {
        this.random = random;
    }

    public int getRandomIntInPower(int pow) {
        return (int) Math.pow(random.nextInt(), pow);
    }

    public String getStringUpperCase(String input) {
        return input.toUpperCase();
    }
}

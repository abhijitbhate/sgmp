package com.ab.structural.decorator;

public class PatternTester {

    public static void main(String[] args) {
        Beverage expressoCoffeeWithChocolate = new ChocolateDecorator(new ExpressoCoffee());

        expressoCoffeeWithChocolate.makeBeverage();
    }
}

package com.ab.structural.decorator;

public class ChocolateDecorator extends BeverageDecorator{

    public ChocolateDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    protected void decorateBeverage() {
        System.out.println("Adding chocolate on top of it!!!");
    }

    @Override
    public void makeBeverage() {
        super.makeBeverage();
        decorateBeverage();
    }
}

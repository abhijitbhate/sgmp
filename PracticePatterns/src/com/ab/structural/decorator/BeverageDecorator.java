package com.ab.structural.decorator;

public abstract class BeverageDecorator implements Beverage {

    Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public void makeBeverage() {
        beverage.makeBeverage();
    }

    protected abstract void decorateBeverage();
}

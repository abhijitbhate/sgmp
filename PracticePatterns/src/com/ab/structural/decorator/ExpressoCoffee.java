package com.ab.structural.decorator;

public class ExpressoCoffee implements Beverage{

    @Override
    public void makeBeverage() {
        System.out.println("Making Expresso Coffee for you!!!");
    }
}

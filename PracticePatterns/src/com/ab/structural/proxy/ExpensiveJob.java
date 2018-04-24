package com.ab.structural.proxy;

public class ExpensiveJob implements ExpensiveWork{

    public ExpensiveJob() {
        System.out.println("Instance Creation takes lots of time");
    }

    @Override
    public void perform() {
        System.out.println("Instance is now ready now performing work");
    }
}

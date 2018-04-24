package com.ab.structural.proxy;

public class PatternTester {

    public static void main(String[] args) {
        ExpensiveWork expensiveWork = ExpensiveJobProxy.getInstance();

        expensiveWork.perform();
        expensiveWork.perform();
    }
}

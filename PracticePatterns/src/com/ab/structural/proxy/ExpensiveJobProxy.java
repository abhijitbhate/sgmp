package com.ab.structural.proxy;

public class ExpensiveJobProxy implements ExpensiveWork{

    private static ExpensiveJobProxy instance = null;

    private ExpensiveWork expensiveWork;

    private ExpensiveJobProxy(){}

    public static ExpensiveJobProxy getInstance() {
        if(instance == null) {
            instance = new ExpensiveJobProxy();
        }

        return instance;
    }

    @Override
    public void perform() {
        if(expensiveWork == null) {
            expensiveWork = new ExpensiveJob();
        }

        expensiveWork.perform();
    }
}

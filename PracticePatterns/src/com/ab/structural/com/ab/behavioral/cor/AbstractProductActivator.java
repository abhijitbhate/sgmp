package com.ab.structural.com.ab.behavioral.cor;

public abstract class AbstractProductActivator implements IProduct{

    private AbstractProductActivator next;

    protected final void setNextAbstractActivator(AbstractProductActivator next) {
        this.next = next;
    }

    protected void handleNext(Product product) {
        if(next != null) {
            next.handleWork(product);
        }
    }
    abstract void handleWork(Product product);

    @Override
    public final void process(Product product) {
        handleWork(product);
    }
}

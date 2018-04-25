package com.ab.structural.com.ab.behavioral.cor;

public class ProductNameActivator extends AbstractProductActivator{

    @Override
    void handleWork(Product product) {
        product.setName("My Name is Exellent Product");

        handleNext(product);
    }
}

package com.ab.structural.com.ab.behavioral.cor;

public class ProductCostActivator extends AbstractProductActivator{

    @Override
    void handleWork(Product product) {
        product.setCost("$500");

        handleNext(product);
    }
}

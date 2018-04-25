package com.ab.structural.com.ab.behavioral.cor;

public class ProductPipeline {

    public ProductPipeline() {
        setPipeline();
    }

    ProductNameActivator productNameActivator = new ProductNameActivator();
    ProductCostActivator productCostActivator = new ProductCostActivator();

    private void setPipeline(){
        productNameActivator.setNextAbstractActivator(productCostActivator);
    }

    public AbstractProductActivator getAbstractProductActivator() {
        return productNameActivator;
    }
}

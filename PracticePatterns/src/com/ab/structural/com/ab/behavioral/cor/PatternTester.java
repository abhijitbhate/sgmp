package com.ab.structural.com.ab.behavioral.cor;

public class PatternTester {

    public static void main(String[] args) {
        Product product = new Product();
        System.out.println("Product before putting in pipeline\n"+product);

        AbstractProductActivator abstractProductActivator = new ProductPipeline().getAbstractProductActivator();
        abstractProductActivator.process(product);

        System.out.println("Product after putting in pipeline\n"+product);
    }
}

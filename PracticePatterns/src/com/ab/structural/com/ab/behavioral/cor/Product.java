package com.ab.structural.com.ab.behavioral.cor;

public class Product {

    String name;
    String cost;

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }
}

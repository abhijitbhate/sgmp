package com.ab.structural.adapter;

public class USCable implements ElectricalAppliance{

    @Override
    public void plugIt() {
        System.out.println("Appliance having US cable");
    }
}

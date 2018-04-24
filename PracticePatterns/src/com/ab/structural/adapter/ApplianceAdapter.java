package com.ab.structural.adapter;

public class ApplianceAdapter implements IndianSocket{

    ElectricalAppliance electricalAppliance;

    public ApplianceAdapter(ElectricalAppliance electricalAppliance) {
        this.electricalAppliance = electricalAppliance;
    }

    @Override
    public void plugInIndianSocket() {
        electricalAppliance.plugIt();
        System.out.println("plugging in to indian socket");
    }
}

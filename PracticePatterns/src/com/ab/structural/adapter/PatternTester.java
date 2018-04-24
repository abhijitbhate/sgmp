package com.ab.structural.adapter;

public class PatternTester {

    public static void main(String[] args) {
        ElectricalAppliance electricalAppliance = new USCable();
        IndianSocket indianSocket = new ApplianceAdapter(electricalAppliance);

        indianSocket.plugInIndianSocket();
    }
}

package com.europoint.poc.modules.poc.domain.entities;

public class PocEntity {
    private String name = "Europoint";
    private String address = "Dobracina 62";

    public PocEntity(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}

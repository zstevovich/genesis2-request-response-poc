package com.europoint.poc.modules.poc.api.appservicecontracts.dtos;

public class PocDto {
    public String name;
    public String address;
    public String threadId;

    public PocDto(String name, String address, String threadId) {
        this.name = name;
        this.address = address;
        this.threadId=threadId;
    }
}

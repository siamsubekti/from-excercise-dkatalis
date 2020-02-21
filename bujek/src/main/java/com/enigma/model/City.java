package com.enigma.model;

public class City {
    private String name;
    private Integer location;

    public City(String name, Integer location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public String[] split(String s) {
        return new String[0];
    }
}

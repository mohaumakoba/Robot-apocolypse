package com.robotapplication.jar.Survivor.DTO;

import com.robotapplication.jar.Survivor.Entities.Inventory;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

public class SurvivorDTO {
    private String name;
    private Integer age;
    private String gender;

    private String ID;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String location;
    private Boolean isInfected;
    private List<Inventory> inventories = new ArrayList<>();

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }

    public Boolean getInfected() {
        return isInfected;
    }

    public void setInfected(Boolean infected) {
        isInfected = infected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}

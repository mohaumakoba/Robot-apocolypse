package com.robotapplication.jar.Survivor.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Survivor {
//    name, age, gender, ID and last location
    private String name;
    private Integer age;
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer ID;
    private String location;
    private Boolean isInfected;
    private Integer numberOfReports = 0;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "survivor_Inventories",
            joinColumns = @JoinColumn(name = "survivor_Id"),
            inverseJoinColumns = @JoinColumn(name = "inventory_Id"))
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

    public Integer getNumberOfReports() {
        return numberOfReports;
    }

    public void setNumberOfReports(Integer numberOfReports) {
        this.numberOfReports = numberOfReports;
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

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

package com.robotapplication.jar.Survivor.DTO;

public class UpdateLocationDTO {
    Integer survivorId;
    String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getSurvivorId() {
        return survivorId;
    }

    public void setSurvivorId(Integer survivorId) {
        this.survivorId = survivorId;
    }
}

package com.robotapplication.jar.Survivor.DTO;

import com.robotapplication.jar.Survivor.Entities.Survivor;

import java.util.ArrayList;
import java.util.List;

public class SuccessDTO {
    private String message;
    private String statusCode;
    private Survivor survivor;
    private List<Survivor> survivors = new ArrayList<>();

    public List<Survivor> getSurvivors() {
        return survivors;
    }

    public void setSurvivors(List<Survivor> survivors) {
        this.survivors = survivors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Survivor getSurvivor() {
        return survivor;
    }

    public void setSurvivor(Survivor survivor) {
        this.survivor = survivor;
    }
}

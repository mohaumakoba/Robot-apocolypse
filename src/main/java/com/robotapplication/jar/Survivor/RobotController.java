package com.robotapplication.jar.Survivor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("https://robotstakeover20210903110417.azurewebsites.net/robotcpu")

public class RobotController {
    @Autowired
    public SurvivorBusinesslogic survivorBusinesslogic;

//  Get all robot and their categories


}

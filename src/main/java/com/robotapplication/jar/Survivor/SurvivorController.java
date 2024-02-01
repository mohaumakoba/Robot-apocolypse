package com.robotapplication.jar.Survivor;
import com.robotapplication.jar.Survivor.DTO.GenderDTO;
import com.robotapplication.jar.Survivor.DTO.ReportSuspectDTO;
import com.robotapplication.jar.Survivor.DTO.SurvivorDTO;
import com.robotapplication.jar.Survivor.DTO.UpdateLocationDTO;
import com.robotapplication.jar.Survivor.SurvivorBusinesslogic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/survivor")
public class SurvivorController {
    @Autowired
    public SurvivorBusinesslogic survivorBusinesslogic;

    //    Create survivor
    @PostMapping("/createSurvivor")
    public ResponseEntity<?> createSurvivor(@RequestBody SurvivorDTO survivorDTO) {
        return survivorBusinesslogic.createSurvivor(survivorDTO);

    }

    //    Get all Survivors
    @GetMapping("/getAllSurvivors")
    public ResponseEntity<?> getAllSurvivors() {
        return survivorBusinesslogic.getAllSurvivors();
    }

    //    Report suspect
    @PostMapping("/reportSuspect")
    public ResponseEntity<?> reportSuspect(@RequestBody ReportSuspectDTO reportSuspectDTO) {
        return survivorBusinesslogic.reportSuspect(reportSuspectDTO);

    }

    // Update location
    @PostMapping("/updateLocation")
    public ResponseEntity<?> updateLocation(@RequestBody UpdateLocationDTO updateLocationDTO) {
        return survivorBusinesslogic.updateLocation(updateLocationDTO);
    }
   //  Update Gender
    @PostMapping("/updateGender")
    public ResponseEntity<?> gender(@RequestBody GenderDTO genderDTO) {
        return survivorBusinesslogic.gender(genderDTO);
    }
}


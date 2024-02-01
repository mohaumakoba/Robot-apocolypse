package com.robotapplication.jar.Survivor;

import com.robotapplication.jar.Survivor.DTO.*;
import com.robotapplication.jar.Survivor.Entities.Inventory;
import com.robotapplication.jar.Survivor.Entities.Survivor;
import com.robotapplication.jar.Survivor.Repositories.InventoryRepository;
import com.robotapplication.jar.Survivor.Repositories.SurvivorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SurvivorBusinesslogic {
    @Autowired
    public SurvivorRepository survivorRepository;
    @Autowired
    public InventoryRepository inventoryRepository;

//    Create survivor
    public ResponseEntity<?> createSurvivor(SurvivorDTO survivorDTO){
        try{
            List<Inventory> tempList = new ArrayList<>();
            Survivor survivor = new Survivor();
            survivor.setName(survivorDTO.getName());
            survivor.setAge(survivorDTO.getAge());
            survivor.setLocation(survivorDTO.getLocation());
            survivor.setInfected(false);
            for(Inventory inventory: survivorDTO.getInventories()){
                Inventory newInventory = new Inventory();
                newInventory.setName(inventory.getName());

//    Save inventory
                Inventory savedInventory = inventoryRepository.save(newInventory);

//    Add new inventory to inventoryList
                tempList.add(savedInventory);
            }

            survivor.setInventories(tempList);
            Survivor savedsurvivor = survivorRepository.save(survivor);
            SuccessDTO successDTO = new SuccessDTO();
            successDTO.setMessage("Survivor created successful");
            successDTO.setStatusCode("200");
            successDTO.setSurvivor(savedsurvivor);
            return ResponseEntity.status(HttpStatus.OK).body(Optional.of(successDTO));

        }catch (Exception exception){
            exception.printStackTrace();
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setMessage("Something went wrong please try again later");
            errorDTO.setStatusCode("500");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Optional.of(errorDTO));

        }
    }
//    Get all survivors
    public ResponseEntity<?> getAllSurvivors() {
        try{
            List<Survivor> survivors = new ArrayList<>();
            survivors = survivorRepository.findAll();
            for(Survivor survivor : survivors){
                if (survivor.getNumberOfReports() >= 3){
                    survivor.setInfected(true);
                    survivorRepository.save(survivor);
                }
            }
            SuccessDTO successDTO = new SuccessDTO();
            successDTO.setMessage("Got all survivors successfully");
            successDTO.setStatusCode("200");
            successDTO.setSurvivors(survivors);
            return ResponseEntity.status(HttpStatus.OK).body(Optional.of(successDTO));
        }catch (Exception exception){
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setMessage("Something went wrong please try again later");
            errorDTO.setStatusCode("500");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Optional.of(errorDTO));
        }
    }

//    Update Survivor location
    public ResponseEntity<?> updateLocation(UpdateLocationDTO updateLocationDTO){
        try{
            Survivor survivor = survivorRepository.getById(updateLocationDTO.getSurvivorId());
            survivor.setLocation(updateLocationDTO.getLocation());
            survivorRepository.save(survivor);
            SuccessDTO successDTO = new SuccessDTO();
            successDTO.setMessage("Location updated successfully");
            successDTO.setStatusCode("200");
            return ResponseEntity.status(HttpStatus.OK).body(Optional.of(successDTO));
        }catch (Exception exception){
            exception.printStackTrace();
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setMessage("Something went wrong please try again later");
            errorDTO.setStatusCode("500");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Optional.of(errorDTO));
        }
    }
//    Update Survivor gender
    public ResponseEntity<?>gender(GenderDTO genderDTO){
        try{
            Survivor survivor = survivorRepository.getById(genderDTO.getSurvivorId());
            survivor.setGender(genderDTO.getGender());
            survivorRepository.save(survivor);
            SuccessDTO successDTO = new SuccessDTO();
            successDTO.setMessage("Gender updated successfully");
            successDTO.setStatusCode("200");
            return ResponseEntity.status(HttpStatus.OK).body(Optional.of(successDTO));
        }catch (Exception exception){
            exception.printStackTrace();
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setMessage("Something went wrong please try again later");
            errorDTO.setStatusCode("500");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Optional.of(errorDTO));
        }
    }
//    Report Survivor as infected
    public ResponseEntity<?> reportSuspect(ReportSuspectDTO reportSuspectDTO){
        try{
            Survivor survivor = survivorRepository.getById(reportSuspectDTO.getSurvivorId());
            survivor.setNumberOfReports(survivor.getNumberOfReports() + 1);
            survivorRepository.save(survivor);
            SuccessDTO successDTO = new SuccessDTO();
            successDTO.setMessage("Reported survivor successfully");
            successDTO.setStatusCode("200");
            return ResponseEntity.status(HttpStatus.OK).body(Optional.of(successDTO));

        }catch (Exception exception){
            exception.printStackTrace();
            ErrorDTO errorDTO = new ErrorDTO();
            errorDTO.setMessage("Something went wrong please try again later");
            errorDTO.setStatusCode("500");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Optional.of(errorDTO));
        }
    }

}

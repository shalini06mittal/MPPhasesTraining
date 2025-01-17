package com.training.springbootrestdemo.controller;



import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.springbootrestdemo.entity.FictionalCharacter;
import com.training.springbootrestdemo.service.CharacterService;
import com.training.springbootrestdemo.utility.AppConstants;
import com.training.springbootrestdemo.utility.Status;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;


@RestController
@RequestMapping("/api/characters")
@CrossOrigin(origins = "*",methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
public class CharacterController {

    Logger logger = LoggerFactory.getLogger(CharacterController.class);
    @Autowired
    private CharacterService characterService;

    @GetMapping
    public List<FictionalCharacter> getAllCharacters(@RequestParam(defaultValue = "all") String house){
        logger.info("GET All Characters for house {}", house);
        if(house.equals("all")) {
           List<FictionalCharacter> ob = characterService.getAllCharacters();
           return ob;
        }else{
           List<FictionalCharacter> ob = characterService.getCharacterByHouse(house);
           return ob;
        }
    }
    @PostMapping()
    public ResponseEntity<Object> addCharacter(@RequestBody FictionalCharacter character){
        try{
            FictionalCharacter ob = characterService.addNewCharacter(character);
            return ResponseEntity.ok(ob);
        }catch (EntityExistsException e){
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(errorMap);
        }
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Object> getCharacterById(@PathVariable int id){
        try {
            FictionalCharacter ob = characterService.getCharacterById(id);
            return ResponseEntity.ok(ob);
        }catch (EntityNotFoundException e){
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(errorMap);
        }
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<Object> getCharacterByName(@PathVariable String name){
        try {
            FictionalCharacter ob = characterService.getCharacterByName(name);
            return ResponseEntity.ok(ob);
        }catch (EntityNotFoundException e){
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(errorMap);
        }
    }
    @PutMapping
    public ResponseEntity<Object> updateCharacter(@RequestBody FictionalCharacter character){
        try {
            FictionalCharacter ob = characterService.updateCharacter(character);
            return ResponseEntity.ok(ob);
        }catch (EntityNotFoundException e){
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(errorMap);
        }
    }

    @DeleteMapping("/wand/{id}")
    public ResponseEntity<Object> deleteWand(@PathVariable int id){
        Map<String, String> map = new HashMap<>();
        try {
            characterService.deleteWand(id);
            map.put("message", "Delete successful");
            return ResponseEntity.ok(map);
        }catch (EntityNotFoundException  e){
            map.put("error", e.getMessage());
        }catch (Exception e){
            if(e.getCause() != null && e.getCause().getCause() instanceof SQLIntegrityConstraintViolationException) {
                SQLIntegrityConstraintViolationException sql_violation_exception = (SQLIntegrityConstraintViolationException) e.getCause().getCause() ;
                map.put("error", "SQLIntegrityConstraintViolationException has accured. Foreign key cpnstraint" );
            } else {
                System.out.println(e.getMessage());
            }
        }


        return ResponseEntity.badRequest().body(map);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCharacter(@PathVariable int id){
        Map<String, String> map = new HashMap<>();
        try {
            characterService.deleteCharacter(id);
            map.put("message", "Delete successful");
            return ResponseEntity.ok(map);
        }catch (EntityNotFoundException e){
            map.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(map);
        }
    }
    @GetMapping("/wand/{id}")
    public ResponseEntity<Object> getCharacterWithWandId(@PathVariable int id){
        Map<String, Object> map = new HashMap<>();
        try {
            map.put(AppConstants.STATUS, Status.SUCCESS);
            FictionalCharacter character= characterService.getCharacterByWandId(id);
            map.put("character",character);
            return ResponseEntity.ok(map);
        }catch (EntityNotFoundException e){
            map.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(map);
        }

    }
}

package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.FictionalCharacter;
import com.example.demo.entity.Wand;
import com.example.demo.repo.CharacterRepo;
import com.example.demo.repo.WandRepo;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepo characterRepo;

    @Autowired
    private WandRepo wandRepo;

    public long getCount(){
        return this.characterRepo.count();
    }

    public List<FictionalCharacter> getCharacterByHouse(String house){
        return characterRepo.findAllByHouse(house);
    }
    public List<FictionalCharacter> getAllCharacters(){
        return characterRepo.findAll();
    }
    public FictionalCharacter addNewCharacter(FictionalCharacter character){

        if(characterRepo.existsById(character.getId()))
            throw new EntityExistsException("cannot insert "+character.getId()+" already exists");
//        if(character.getWand() != null) {
//            wandRepo.save(character.getWand());
//        }
        return characterRepo.save(character);

    }
    public FictionalCharacter updateCharacter(FictionalCharacter character){
        if(!characterRepo.existsById(character.getId()))
            throw new EntityNotFoundException("cannot update "+character.getName()+" does not exist");

//        if(character.getWand() != null) {
//            wandRepo.save(character.getWand());
//        }
        return characterRepo.save(character);

    }
    public boolean deleteCharacter(int id){
        if(!characterRepo.existsById(id))
            throw new EntityNotFoundException("cannot delete "+id+" does not exist");
        FictionalCharacter character = characterRepo.findById(id).get();
//        Wand ob = character.getWand();
        characterRepo.delete(character);
//        if(ob != null)
//            wandRepo.delete(ob);
        return true;
    }
    public FictionalCharacter getCharacterByName(String name){
        if(!characterRepo.existsByName(name))
            throw new EntityNotFoundException(name+" not found");
        return characterRepo.findByName(name);

    }
    public FictionalCharacter getCharacterById(int id){
        if(!characterRepo.existsById(id))
            throw new EntityNotFoundException(id+" not found");
        return characterRepo.findById(id).get();

    }

    public boolean deleteWand(int id) {
        if(!wandRepo.existsById(id))
            throw new EntityNotFoundException("cannot delete "+id+" does not exist");
        Wand wand= wandRepo.findById(id).get();
        wandRepo.delete(wand);
        return true;
    }

    public FictionalCharacter getCharacterByWandId(int wandid){
        if(!wandRepo.existsById(wandid))
            throw new EntityNotFoundException("cannot fetch as wand with id "+wandid+" does not exist");
        Wand wand = wandRepo.findById(wandid).get();
        return wand.getCharacter();
    }
}

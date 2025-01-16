package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.FictionalCharacter;

public interface CharacterRepo extends JpaRepository<FictionalCharacter,Integer >
 {

    public List<FictionalCharacter> findAllByHouse(String house);
    public FictionalCharacter findByName(String name);
    public boolean existsByName(String name);
}

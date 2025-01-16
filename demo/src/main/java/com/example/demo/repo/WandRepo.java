package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Wand;

public interface WandRepo extends JpaRepository<Wand, Integer>
{
}

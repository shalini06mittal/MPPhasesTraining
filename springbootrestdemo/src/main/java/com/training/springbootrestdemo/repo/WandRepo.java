package com.training.springbootrestdemo.repo;

import com.training.springbootrestdemo.entity.Wand;
import com.training.springbootrestdemo.entity.Wand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WandRepo extends JpaRepository<Wand, Integer>
{
}

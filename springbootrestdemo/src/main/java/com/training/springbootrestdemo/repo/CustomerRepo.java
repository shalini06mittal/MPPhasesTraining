package com.training.springbootrestdemo.repo;

import com.training.springbootrestdemo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}

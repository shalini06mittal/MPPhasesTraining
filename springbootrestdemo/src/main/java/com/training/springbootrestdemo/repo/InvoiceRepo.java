package com.training.springbootrestdemo.repo;

import com.training.springbootrestdemo.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepo extends JpaRepository<Invoice,Integer> {
    public List<Invoice> findAllByCustomerCustid(int id);
}

package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Invoice;

public interface InvoiceRepo extends JpaRepository<Invoice,Integer> {
    public List<Invoice> findAllByCustomerCustid(int id);
}

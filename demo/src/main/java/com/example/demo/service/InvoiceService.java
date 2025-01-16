package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Invoice;
import com.example.demo.repo.InvoiceRepo;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepo invoiceRepo;

    public Invoice getInvoiceByInvoiceId(int id){
        return invoiceRepo.findById(id)
                .orElseThrow(()->  new EntityNotFoundException("customer with "+id+" does not exists"));
    }
    public Invoice insertInvoice(Invoice invoice){
        if(invoiceRepo.existsById(invoice.getInvoiceid()))
            throw new EntityExistsException("Cannot add "+invoice.getInvoiceid()+" already exists");
        return invoiceRepo.save(invoice);
    }

    public List<Invoice> getAllInvoicesByCustomerId(int customerid){
        return  invoiceRepo.findAllByCustomerCustid(customerid);
    }
}

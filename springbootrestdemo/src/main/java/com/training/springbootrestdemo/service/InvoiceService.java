package com.training.springbootrestdemo.service;

import com.training.springbootrestdemo.entity.Invoice;
import com.training.springbootrestdemo.repo.InvoiceRepo;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

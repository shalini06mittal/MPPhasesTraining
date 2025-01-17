package com.training.springbootrestdemo.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.training.springbootrestdemo.entity.Invoice;
import com.training.springbootrestdemo.service.InvoiceService;

import jakarta.persistence.EntityExistsException;

@RestController
@RequestMapping("/api/invoices")
@CrossOrigin(origins = "*",methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
public class InvoiceController {

    Logger logger = LoggerFactory.getLogger(InvoiceController.class);
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/customer/{id}")
    public List<Invoice> getAllInvoicesByCustomerId(@PathVariable int id){
        logger.info("GET All Invoices for customer with id {} ", id);
           return invoiceService.getAllInvoicesByCustomerId(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getInvoicesByInvoiceId(@PathVariable int id){
        logger.info("GET All Invoices for customer with id {} ", id);
        try{
            Invoice ob = invoiceService.getInvoiceByInvoiceId(id);
            return ResponseEntity.ok(ob);
        }catch (EntityExistsException e){
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(errorMap);
        }
    }
    @PostMapping()
    public ResponseEntity<Object> addInvoice(@RequestBody Invoice invoice){
        try{
            Invoice ob = invoiceService.insertInvoice(invoice);
            return ResponseEntity.ok(ob);
        }catch (EntityExistsException e){
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(errorMap);
        }
    }

}

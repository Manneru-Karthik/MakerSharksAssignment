package com.makersharks.SpringbootProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.makersharks.SpringbootProject.dto.Responsecontent;
import com.makersharks.SpringbootProject.dto.Supplierdto;
import com.makersharks.SpringbootProject.service.SupplierService;



@RestController
@RequestMapping("/api/supplier/")
public class SupplierController {
    
    @Autowired
    private SupplierService supplierService;


    @PostMapping("query")
    public ResponseEntity<Responsecontent> getSuppliersBySearch(
        @RequestBody Supplierdto supplierdto,
        @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
        @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
            System.out.print(supplierdto);
            return new ResponseEntity<>(supplierService.getAllSuppliers(pageNo, pageSize,supplierdto), HttpStatus.OK);
    }
}

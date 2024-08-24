package com.makersharks.SpringbootProject.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.makersharks.SpringbootProject.dto.Responsecontent;
import com.makersharks.SpringbootProject.dto.Supplierdto;
import com.makersharks.SpringbootProject.model.Supplier;
import com.makersharks.SpringbootProject.repository.SupplierRepository;
@Service
public class SupplierService {
    
    @Autowired
    private SupplierRepository supplierRepository;

 
  public Responsecontent getAllSuppliers(int pageNo,int pageSize,Supplierdto supplier){
    Pageable pageable=PageRequest.of(pageNo, pageSize);
    Page<Supplier> suppliers=null;
    List<Supplier> listOfSuppliers=null;
    

    // Conditional Statements 

    //1. If there is no search specific value , then all the suppliers gets displayed
    if(supplier.getLocation()==null&&supplier.getNature()==null&&supplier.getManufacturing()==null){
        suppliers=supplierRepository.findAll(pageable);
        listOfSuppliers=suppliers.getContent();
    }
    //2. If user searches only with specific region , only the list of suppliers in that region gets displayed
    else if(supplier.getLocation()!=null&&supplier.getNature()==null&&supplier.getManufacturing()==null){
        suppliers=supplierRepository.findByLocation(supplier.getLocation(),pageable);
        listOfSuppliers=suppliers.getContent();
    }

    //3. If user searches only with specific Nature Of business(small_scale,medium_scale,large_scale) , only the list of suppliers of the specific nature of business gets displayed
    else if(supplier.getLocation()==null&&supplier.getNature()!=null&&supplier.getManufacturing()==null){
        suppliers=supplierRepository.findByNature(supplier.getNature(),pageable);
        listOfSuppliers=suppliers.getContent();
    }

    //4. If user searches only with specific Manufacturing process(moulding, 3d_printing, casting, coating) , only the list of suppliers of the specific manufacturing process gets displayed
    else if(supplier.getLocation()==null&&supplier.getNature()==null&&supplier.getManufacturing()!=null){
        suppliers=supplierRepository.findByManufacturing(supplier.getManufacturing(),pageable);
        listOfSuppliers=suppliers.getContent();
    }
    
   //5. If user searches with specific location and Nature Of business(small_scale,medium_scale,large_scale) , only the list of suppliers of the specific location and nature of business gets displayed 
    else if(supplier.getLocation()!=null&&supplier.getNature()!=null&&supplier.getManufacturing()==null){
        suppliers=supplierRepository.findByLocationAndNature(supplier.getLocation(),supplier.getNature(),pageable);
        listOfSuppliers=suppliers.getContent();
    }

    //6. If user searches with specific Nature Of business(small_scale,medium_scale,large_scale) and Manufacturing process(moulding, 3d_printing, casting, coating) , only the list of suppliers of the specific nature of business and manufacturing process gets displayed 
    else if(supplier.getLocation()==null&&supplier.getNature()!=null&&supplier.getManufacturing()!=null){
        suppliers=supplierRepository.findByNatureAndManufacturing(supplier.getNature(),supplier.getManufacturing(),pageable);
        listOfSuppliers=suppliers.getContent();
    }

    //7. If user searches with specific location and Manufacturing process(moulding, 3d_printing, casting, coating) , only the list of suppliers of the specific location and manufacturing process gets displayed 
    else if(supplier.getLocation()!=null&&supplier.getNature()==null&&supplier.getManufacturing()!=null){
        suppliers=supplierRepository.findByLocationAndManufacturing(supplier.getLocation(),supplier.getManufacturing(),pageable);
        listOfSuppliers=suppliers.getContent();
    }

    //8. If user searches with specific location,Nature Of business(small_scale,medium_scale,large_scale) and Manufacturing process(moulding, 3d_printing, casting, coating) , only the list of suppliers of the specific location,nature of business and manufacturing process gets displayed 
    else if(supplier.getLocation()!=null&&supplier.getNature()!=null&&supplier.getManufacturing()!=null){
        suppliers=supplierRepository.findByLocationAndNatureAndManufacturing(supplier.getLocation(),supplier.getNature(),supplier.getManufacturing(),pageable);
        listOfSuppliers=suppliers.getContent();
    }
  
   
    Responsecontent responsecontent=new Responsecontent();
        responsecontent.setSupplierlist(listOfSuppliers);
        responsecontent.setPageNo(suppliers.getNumber());
        responsecontent.setPageSize(suppliers.getSize());
        responsecontent.setTotalElements(suppliers.getTotalElements());
        responsecontent.setTotalPages(suppliers.getTotalPages());
        responsecontent.setLast(suppliers.isLast());
        return responsecontent;
  }
}

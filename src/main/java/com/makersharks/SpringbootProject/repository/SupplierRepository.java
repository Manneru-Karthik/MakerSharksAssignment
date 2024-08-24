package com.makersharks.SpringbootProject.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.makersharks.SpringbootProject.model.Supplier;

@Repository
public interface SupplierRepository  extends JpaRepository<Supplier,Long>{
    

  Page<Supplier> findByLocation(String location,Pageable pageable);

  
Page<Supplier> findByNature(Supplier.Nature nature, Pageable pageable);

Page<Supplier> findByManufacturing(Supplier.Manufacturing manufacturing,Pageable pageable);

Page<Supplier> findByLocationAndNature(String location,Supplier.Nature nature, Pageable pageable);

Page<Supplier> findByNatureAndManufacturing(Supplier.Nature nature,Supplier.Manufacturing manufacturing, Pageable pageable);

Page<Supplier> findByLocationAndManufacturing(String location,Supplier.Manufacturing manufacturing, Pageable pageable);

Page<Supplier> findByLocationAndNatureAndManufacturing(String location,Supplier.Nature nature,Supplier.Manufacturing manufacturing, Pageable pageable);

}
package com.makersharks.SpringbootProject.dto;

import com.makersharks.SpringbootProject.model.Supplier;



public class Supplierdto {
    private String location;
    private Supplier.Nature nature;
    private Supplier.Manufacturing manufacturing;
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Supplier.Nature getNature() {
        return nature;
    }
    public void setNature(Supplier.Nature nature) {
        this.nature = nature;
    }
    public Supplier.Manufacturing getManufacturing() {
        return manufacturing;
    }
    public void setManufacturing(Supplier.Manufacturing manufacturing) {
        this.manufacturing = manufacturing;
    }
    @Override
    public String toString() {
        return "Supplierdto [location=" + location + ", nature=" + nature + ", manufacturing=" + manufacturing + "]";
    }
   
   
    
}

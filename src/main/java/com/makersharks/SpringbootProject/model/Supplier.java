package com.makersharks.SpringbootProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long supplierId;

    private String company_name;

    private String website;

    private String location;
    
    @Enumerated(EnumType.STRING)
    private Nature nature;

    @Enumerated(EnumType.STRING)
    private Manufacturing manufacturing;

    public enum Nature{
        small_scale,medium_scale,large_scale
    }

    public enum Manufacturing{
          moulding, _3d_printing,casting,coating
    }
}

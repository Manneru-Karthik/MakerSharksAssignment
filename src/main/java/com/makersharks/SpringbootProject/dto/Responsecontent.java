package com.makersharks.SpringbootProject.dto;

import java.util.List;

import com.makersharks.SpringbootProject.model.Supplier;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Responsecontent {
    private List<Supplier> supplierlist;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}

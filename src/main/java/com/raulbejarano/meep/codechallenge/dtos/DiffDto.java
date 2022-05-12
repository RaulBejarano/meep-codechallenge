package com.raulbejarano.meep.codechallenge.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiffDto {
    private Date updatedAt;
    private List<VehicleDto> added;
    private List<VehicleDto> removed;
}

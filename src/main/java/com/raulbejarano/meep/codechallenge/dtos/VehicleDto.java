package com.raulbejarano.meep.codechallenge.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto {
    private String id;
    private String name;
    private int x;
    private int y;
    private String licencePlate;
    private int range;
    private int batteryLevel;
    private int helmets;
    private String model;
    private String resourceImageId;
    private String [] resourcesImagesUrls;
    private boolean realTimeData;
    private String resourceType;
    private int companyZoneId;
}

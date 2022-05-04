package com.raulbejarano.meep.codechallenge.controllers;

import com.raulbejarano.meep.codechallenge.dtos.VehicleDto;
import com.raulbejarano.meep.codechallenge.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleController {
    final
    VehicleService vehicleService;


    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/")
    public List<VehicleDto> listVehicles(){
        return vehicleService.list();
    }
}

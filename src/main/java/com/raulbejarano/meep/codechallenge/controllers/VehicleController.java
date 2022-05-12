package com.raulbejarano.meep.codechallenge.controllers;

import com.raulbejarano.meep.codechallenge.dtos.DiffDto;
import com.raulbejarano.meep.codechallenge.dtos.VehicleDto;
import com.raulbejarano.meep.codechallenge.services.DiffService;
import com.raulbejarano.meep.codechallenge.services.VehicleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleController {
    final
    VehicleService vehicleService;

    final DiffService diffService;


    public VehicleController(VehicleService vehicleService, DiffService diffService) {
        this.vehicleService = vehicleService;
        this.diffService = diffService;
    }

    @GetMapping("/")
    public List<VehicleDto> listVehicles(){
        return vehicleService.list();
    }

    @GetMapping("/diff")
    public DiffDto diffVehicles(){
        return diffService.get();
    }
}

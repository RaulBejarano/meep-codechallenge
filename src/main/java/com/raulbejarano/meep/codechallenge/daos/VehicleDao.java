package com.raulbejarano.meep.codechallenge.daos;

import com.raulbejarano.meep.codechallenge.dtos.VehicleDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleDao {
    private List<VehicleDto> vehicles = new ArrayList<>();

    public List<VehicleDto> list() {
        return vehicles;
    }

    public void update(List<VehicleDto> vehicleDtos){
        this.vehicles = vehicleDtos;
    }
}

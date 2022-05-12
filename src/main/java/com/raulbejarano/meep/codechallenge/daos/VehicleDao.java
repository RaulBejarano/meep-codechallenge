package com.raulbejarano.meep.codechallenge.daos;

import com.raulbejarano.meep.codechallenge.dtos.DiffDto;
import com.raulbejarano.meep.codechallenge.dtos.VehicleDto;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class VehicleDao {
    private List<VehicleDto> vehicles = new ArrayList<>();
    private DiffDto diff = new DiffDto();

    public List<VehicleDto> list() {
        return vehicles;
    }

    public void update(List<VehicleDto> vehicleDtos){

        Set<VehicleDto> intersection = new HashSet<>(vehicles);
        intersection.retainAll(vehicleDtos);

        List<VehicleDto> removed = new ArrayList<VehicleDto>(vehicles);
        removed.removeAll(intersection);

        List<VehicleDto> added = new ArrayList<VehicleDto>(vehicleDtos);
        added.removeAll(intersection);

        this.diff = DiffDto.builder()
                .added(added)
                .removed(removed)
                .updatedAt(new Date())
                .build();

        this.vehicles = vehicleDtos;
    }

    public DiffDto getDiff() {
        return diff;
    }
}

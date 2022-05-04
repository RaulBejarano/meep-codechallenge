package com.raulbejarano.meep.codechallenge.daos;

import com.raulbejarano.meep.codechallenge.dtos.VehicleDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VehicleDaoTest {

    @Autowired
    VehicleDao vehicleDao;

    private final VehicleDto VEHICLE_A = VehicleDto.builder()
            .id("A")
            .build();

    private final VehicleDto VEHICLE_B = VehicleDto.builder()
            .id("B")
            .build();

    private final VehicleDto VEHICLE_C = VehicleDto.builder()
            .id("C")
            .build();

    private final List<VehicleDto> VEHICLES = new ArrayList<>();

    @BeforeAll
    public void setup(){
        VEHICLES.add(VEHICLE_A);
        VEHICLES.add(VEHICLE_B);
    }

    @Test
    public void givenAEmptySetWhenListedThenSizeIsZero(){
        List<VehicleDto> vehicleDtoList = vehicleDao.list();
        assertEquals(0,vehicleDtoList.size());
    }

    @Test
    public void givenAListOfVehiclesWhenUpdatedThenListReturnsResults(){
        vehicleDao.update(VEHICLES);
        List<VehicleDto> vehicleDtoList = vehicleDao.list();
        assertNotEquals(0,vehicleDtoList.size());
    }

    @Test
    public void givenAListOfVehiclesWhenAddingOneThenListReturnsOneMoreResult(){
        vehicleDao.update(VEHICLES);

        List<VehicleDto> updatedList = new ArrayList<>(VEHICLES);
        updatedList.add(VEHICLE_C);
        vehicleDao.update(updatedList);

        List<VehicleDto> vehicleDtoList = vehicleDao.list();
        assertEquals(3,vehicleDtoList.size());
    }

    @Test
    public void givenAListOfVehiclesWhenAddingOneAndRemovingOneThenListReturnsUpdatedVehicles(){
        vehicleDao.update(VEHICLES);

        List<VehicleDto> updatedList = new ArrayList<>();
        updatedList.add(VEHICLE_B);
        updatedList.add(VEHICLE_C);
        vehicleDao.update(updatedList);

        List<VehicleDto> vehicleDtoList = vehicleDao.list();
        assertEquals(2 ,vehicleDtoList.size());

        assertEquals(updatedList, vehicleDtoList);
    }

}

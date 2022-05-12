package com.raulbejarano.meep.codechallenge.daos;

import com.raulbejarano.meep.codechallenge.dtos.DiffDto;
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

    private final List<VehicleDto> VEHICLES_1 = new ArrayList<>();
    private final List<VehicleDto> VEHICLES_2 = new ArrayList<>();

    @BeforeAll
    public void setup(){
        VEHICLES_1.add(VEHICLE_A);
        VEHICLES_1.add(VEHICLE_B);

        VEHICLES_2.add(VEHICLE_B);
        VEHICLES_2.add(VEHICLE_C);
    }

    @Test
    public void givenAListOfVehiclesWhenUpdatedThenListReturnsResults(){
        vehicleDao.update(VEHICLES_1);
        List<VehicleDto> vehicleDtoList = vehicleDao.list();
        assertNotEquals(0,vehicleDtoList.size());
    }

    @Test
    public void givenAListOfVehiclesWhenAddingOneThenListReturnsOneMoreResult(){
        vehicleDao.update(VEHICLES_1);

        List<VehicleDto> updatedList = new ArrayList<>(VEHICLES_1);
        updatedList.add(VEHICLE_C);
        vehicleDao.update(updatedList);

        List<VehicleDto> vehicleDtoList = vehicleDao.list();
        assertEquals(3,vehicleDtoList.size());
    }

    @Test
    public void givenAListOfVehiclesWhenAddingOneAndRemovingOneThenListReturnsUpdatedVehicles(){
        vehicleDao.update(VEHICLES_1);

        List<VehicleDto> updatedList = new ArrayList<>();
        updatedList.add(VEHICLE_B);
        updatedList.add(VEHICLE_C);
        vehicleDao.update(updatedList);

        List<VehicleDto> vehicleDtoList = vehicleDao.list();
        assertEquals(2 ,vehicleDtoList.size());

        assertEquals(updatedList, vehicleDtoList);
    }

    @Test
    public void givenTwoCallsWhenGettingDiffThenReturnsAddedAndRemoved(){
        vehicleDao.update(VEHICLES_1);
        vehicleDao.update(VEHICLES_2);

        DiffDto diff = vehicleDao.getDiff();

        assertEquals(1, diff.getAdded().size());
        assertEquals(1, diff.getRemoved().size());

        assertEquals(VEHICLE_A, diff.getRemoved().get(0));
        assertEquals(VEHICLE_C, diff.getAdded().get(0));
    }

}

package com.raulbejarano.meep.codechallenge.tasks;

import com.raulbejarano.meep.codechallenge.daos.VehicleDao;
import com.raulbejarano.meep.codechallenge.dtos.VehicleDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class MeepVehicleTaskTest {

    @Autowired
    MeepVehicleTask meepVehicleTask;

    @Autowired
    VehicleDao vehicleDao;

    @Test
    public void whenGettingVehiclesThenAreSaved () throws Exception {
        meepVehicleTask.getVehicles();

        List<VehicleDto> vehicleDtoList = vehicleDao.list();

        assertNotEquals(0, vehicleDtoList.size());

    }


}

package com.raulbejarano.meep.codechallenge.controllers;

import com.raulbejarano.meep.codechallenge.daos.VehicleDao;
import com.raulbejarano.meep.codechallenge.dtos.VehicleDto;
import com.raulbejarano.meep.codechallenge.tasks.MeepVehicleTask;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VehicleControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    MeepVehicleTask meepVehicleTask;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    VehicleDao vehicleDao;

    @BeforeAll
    public void setup() throws Exception {
        meepVehicleTask.getVehicles();
    }

    @Test
    public void givenAVehiclesListEndpointWhenMakingACallThenReturnAllVehicles() {
        List<VehicleDto> vehicleList = Arrays.asList(this.testRestTemplate.getForObject("http://localhost:"+port+"/", VehicleDto[].class));
        assertNotEquals(0, vehicleList.size());
        assertEquals(vehicleDao.list(), vehicleList);
    }
}

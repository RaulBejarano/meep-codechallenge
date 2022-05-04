package com.raulbejarano.meep.codechallenge.services;

import com.raulbejarano.meep.codechallenge.dtos.VehicleDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MeepCallServiceTest {

    @Autowired
    private MeepCallService meepCallService;

    private final String PARAMS = "?lowerLeftLatLon=38.711046,-9.160096&upperRightLatLon=38.739429,-9.137115&companyZoneIds=545,467,473";

    @Test
    public void givenParametersWhenMakingACallThenGetsAListOfVehicles() throws Exception {
        List<VehicleDto> result = meepCallService.retrieveVehicles(PARAMS);
        assertNotEquals(0,result.size());
    }

    @Test
    public void givenBadParametersWhenMakingACallThenGetsAnException() throws Exception {
        assertThrows(Exception.class, () -> {
            List<VehicleDto> result = meepCallService.retrieveVehicles("BAD-"+PARAMS);
        }, "Error on Meep call");
    }
}

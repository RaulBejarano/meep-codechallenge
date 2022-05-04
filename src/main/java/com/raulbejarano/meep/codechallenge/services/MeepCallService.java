package com.raulbejarano.meep.codechallenge.services;

import com.raulbejarano.meep.codechallenge.dtos.VehicleDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MeepCallService {

    @Value("${MEEP_URL}")
    private String MEEP_URL;

    public List<VehicleDto> retrieveVehicles(String parameters) throws Exception {
        String URI = MEEP_URL + parameters;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<VehicleDto[]> vehicleDtoResponse = restTemplate.getForEntity(URI, VehicleDto[].class);
        if (vehicleDtoResponse.getStatusCode() != HttpStatus.OK) {
            throw new Exception("Error on Meep call");
        }

        return Arrays.asList(vehicleDtoResponse.getBody());
    }

}

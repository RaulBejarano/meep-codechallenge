package com.raulbejarano.meep.codechallenge.services;

import com.raulbejarano.meep.codechallenge.common.services.CRUDService;
import com.raulbejarano.meep.codechallenge.dtos.VehicleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

@Service
public class VehicleService implements CRUDService<VehicleDto> {

    @Override
    public VehicleDto create(VehicleDto vehicleDto) {
        throw new NotImplementedException();
    }

    @Override
    public List<VehicleDto> list() {
        return null;
    }

    @Override
    public VehicleDto get(String id) {
        throw new NotImplementedException();
    }

    @Override
    public VehicleDto update(VehicleDto old, VehicleDto vehicleDto) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(VehicleDto vehicleDto) {
        throw new NotImplementedException();
    }
}

package com.raulbejarano.meep.codechallenge.services;

import com.raulbejarano.meep.codechallenge.daos.VehicleDao;
import com.raulbejarano.meep.codechallenge.dtos.DiffDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiffService {

    final
    VehicleDao vehicleDao;

    public DiffService(VehicleDao vehicleDao) {
        this.vehicleDao = vehicleDao;
    }

    public DiffDto get() {
        return vehicleDao.getDiff();
    }

}

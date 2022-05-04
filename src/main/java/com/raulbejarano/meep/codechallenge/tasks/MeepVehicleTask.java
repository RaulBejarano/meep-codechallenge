package com.raulbejarano.meep.codechallenge.tasks;

import com.raulbejarano.meep.codechallenge.daos.VehicleDao;
import com.raulbejarano.meep.codechallenge.dtos.VehicleDto;
import com.raulbejarano.meep.codechallenge.services.MeepCallService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MeepVehicleTask {

    final String parameters = "";
    final MeepCallService meepCallService;
    final VehicleDao vehicleDao;

    public MeepVehicleTask(MeepCallService meepCallService, VehicleDao vehicleDao) {
        this.meepCallService = meepCallService;
        this.vehicleDao = vehicleDao;
    }

    @Scheduled(fixedRateString = "${task.rate}")
    public void getVehicles() throws Exception {
        List<VehicleDto> vehicleDtoList = meepCallService.retrieveVehicles(parameters);
        vehicleDao.update(vehicleDtoList);
    }
}

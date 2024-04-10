package com.car_rent.carrentapplication.controller;

import com.car_rent.carrentapplication.model.Car;
import com.car_rent.carrentapplication.model.RentApplication;
import com.car_rent.carrentapplication.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rent")
public class RentController {
    private final RentService rentService;

    @Autowired
    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{applicationId}"
    )
    public @ResponseBody RentApplication getApplication(@PathVariable long applicationId) {
        return rentService.getRentApplication(applicationId);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/applications/{clientId}"
    )
    public @ResponseBody List<RentApplication> getAllApplication(@PathVariable String clientId) {
        return rentService.getAllRentApplication(clientId);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/rent-application",
            headers = "Accept=" + MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public void registerRentApplication(@RequestBody RentApplication rentApplication) {
        rentService.addRentApplication(rentApplication);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{rentApplicationId}"
    )
    @ResponseStatus(HttpStatus.OK)
    public void deleteRentClient(@PathVariable long rentApplicationId) {
        rentService.deleteRentApplication(rentApplicationId);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/car"
    )
    public @ResponseBody List<Car> getCars() {
        return rentService.getAllCars();
    }
}

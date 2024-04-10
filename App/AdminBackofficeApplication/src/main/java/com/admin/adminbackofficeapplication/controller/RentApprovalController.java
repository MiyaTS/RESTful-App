package com.admin.adminbackofficeapplication.controller;

import com.admin.adminbackofficeapplication.model.RentApplication;
import com.admin.adminbackofficeapplication.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rent-approval")
public class RentApprovalController {
    private final CarService carService;

    @Autowired
    public RentApprovalController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/application/{applicationId}"
    )
    public @ResponseBody RentApplication getApplication(@PathVariable long applicationId) {
        return carService.getRentApplication(applicationId);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/application"
    )
    public @ResponseBody List<RentApplication> getApplications() {
        return carService.getAllApplications();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/approve-application",
            headers = "Accept=" + MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody RentApplication processRentApplication(@RequestBody RentApplication rentApplication) {
        return carService.approveApplication(rentApplication);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/report-problem",
            headers = "Accept=" + MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public void reportProblem(@RequestBody RentApplication rentApplication) {
        carService.reportProblem(rentApplication);
    }
}

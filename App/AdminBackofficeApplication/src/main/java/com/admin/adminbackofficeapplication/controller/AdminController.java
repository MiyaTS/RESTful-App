package com.admin.adminbackofficeapplication.controller;

import com.admin.adminbackofficeapplication.model.Admin;
import com.admin.adminbackofficeapplication.model.Car;
import com.admin.adminbackofficeapplication.service.AdminSupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {
    private final AdminSupportService adminSupportService;

    @Autowired
    public AdminController(AdminSupportService adminSupportService) {
        this.adminSupportService = adminSupportService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{adminId}"
    )
    public @ResponseBody Admin getAdmin(@PathVariable String adminId) {
        return adminSupportService.getAdmin(adminId);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/account",
            headers = "Accept=" + MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public void createAdminAccount(@RequestBody Admin admin) {
        adminSupportService.registerAdminAccount(admin);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/account",
            headers = "Accept=" + MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public void updateAdmin(@RequestBody Admin admin) {
        adminSupportService.updateAdminAccount(admin);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{adminId}"
    )
    @ResponseStatus(HttpStatus.OK)
    public void deleteAdmin(@PathVariable String adminId) {
        adminSupportService.deleteAdmin(adminId);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/car/{carId}"
    )
    public @ResponseBody Car getCar(@PathVariable String carId) {
        return adminSupportService.getCar(carId);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/car",
            headers = "Accept=" + MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public void createCar(@RequestBody Car car) {
        adminSupportService.createCar(car);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/car",
            headers = "Accept=" + MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public void updateCar(@RequestBody Car car) {
        adminSupportService.updateCarInfo(car);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/car/{carId}"
    )
    @ResponseStatus(HttpStatus.OK)
    public void deleteCar(@PathVariable String carId) {
        adminSupportService.deleteCar(carId);
    }
}

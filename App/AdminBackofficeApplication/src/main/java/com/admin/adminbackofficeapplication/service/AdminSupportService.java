package com.admin.adminbackofficeapplication.service;

import com.admin.adminbackofficeapplication.model.Admin;
import com.admin.adminbackofficeapplication.model.Car;
import com.admin.adminbackofficeapplication.repository.AdminRepository;
import com.admin.adminbackofficeapplication.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminSupportService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private CarRepository carRepository;

    public Admin getAdmin(String id) {
        var admin = adminRepository.findById(id);
        if (admin.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return admin.get();
    }

    public void registerAdminAccount(Admin admin) {
        if (checkIfAdminExists(admin.getId())) {
            throw new IllegalArgumentException();
        }
        adminRepository.save(admin);
    }

    private boolean checkIfAdminExists(String id) {
        var admin = adminRepository.findById(id);
        return admin.isPresent();
    }

    public void deleteAdmin(String id) {
        adminRepository.deleteById(id);
    }

    public void updateAdminAccount(Admin admin) {
        if (!checkIfAdminExists(admin.getId())) {
            throw new IllegalArgumentException();
        }
        adminRepository.save(admin);
    }

    public Car getCar(String id) {
        var admin = carRepository.findById(id);
        if (admin.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return admin.get();
    }

    public void createCar(Car car) {
        if (checkIfCarExists(car.getId())) {
            throw new IllegalArgumentException();
        }
        carRepository.save(car);
    }

    private boolean checkIfCarExists(String id) {
        var car = carRepository.findById(id);
        return car.isPresent();
    }

    public void deleteCar(String id) {
        carRepository.deleteById(id);
    }

    public void updateCarInfo(Car car) {
        if (!checkIfCarExists(car.getId())) {
            throw new IllegalArgumentException();
        }
        carRepository.save(car);
    }
}

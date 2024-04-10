package com.car_rent.carrentapplication.service;

import com.car_rent.carrentapplication.model.Car;
import com.car_rent.carrentapplication.model.RentApplication;
import com.car_rent.carrentapplication.repository.CarRepository;
import com.car_rent.carrentapplication.repository.RentApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService {
    @Autowired
    private RentApplicationRepository rentApplicationRepository;
    @Autowired
    private CarRepository carRepository;

    public RentApplication getRentApplication(long id) {
        var application = rentApplicationRepository.findById(id);
        if (application.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return application.get();
    }

    public List<RentApplication> getAllRentApplication(String clientId) {
        var applications = rentApplicationRepository.findAll();
        if (applications.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return applications.stream().filter(rentApplication -> rentApplication.getClient().getId().equals(clientId)).toList();
    }

    public void addRentApplication(RentApplication rentApplication) {
        rentApplicationRepository.save(rentApplication);
        Car car = rentApplication.getCar();
        car.setRented(true);
        carRepository.save(car);
    }

    public void deleteRentApplication(long id) {
        rentApplicationRepository.deleteById(id);
    }

    public List<Car> getAllCars() {
        var car = carRepository.findAll();
        if (car.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return car;
    }
}

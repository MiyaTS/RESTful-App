package com.admin.adminbackofficeapplication.service;

import com.admin.adminbackofficeapplication.model.RentApplication;
import com.admin.adminbackofficeapplication.repository.CarRepository;
import com.admin.adminbackofficeapplication.repository.ClientRepository;
import com.admin.adminbackofficeapplication.repository.RentApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private RentApplicationRepository rentApplicationRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ClientRepository clientRepository;

    public RentApplication getRentApplication(long id) {
        var application = rentApplicationRepository.findById(id);
        if (application.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return application.get();
    }

    public List<RentApplication> getAllApplications() {
        var applications = rentApplicationRepository.findAll();
        if (applications.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return applications;
    }

    public void reportProblem(RentApplication rentApplication) {
        var car = rentApplication.getCar();
        car.setRented(false);
        carRepository.save(car);
        var client = rentApplication.getClient();
        client.setBills(client.getBills() * 2);
        clientRepository.save(client);
        rentApplicationRepository.delete(rentApplication);
    }

    public RentApplication approveApplication(RentApplication rentApplication) {
        var car = rentApplication.getCar();
        car.setRented(false);
        carRepository.save(car);
        rentApplicationRepository.delete(rentApplication);
        return rentApplication;
    }
}

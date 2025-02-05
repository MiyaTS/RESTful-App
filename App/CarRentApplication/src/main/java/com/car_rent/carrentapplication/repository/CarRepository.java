package com.car_rent.carrentapplication.repository;

import com.car_rent.carrentapplication.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {
}

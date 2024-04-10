package com.car_rent.carrentapplication.repository;

import com.car_rent.carrentapplication.model.RentApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentApplicationRepository extends JpaRepository<RentApplication, Long> {
}

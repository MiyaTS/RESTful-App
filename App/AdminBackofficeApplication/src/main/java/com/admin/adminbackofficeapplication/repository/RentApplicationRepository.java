package com.admin.adminbackofficeapplication.repository;

import com.admin.adminbackofficeapplication.model.RentApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentApplicationRepository extends JpaRepository<RentApplication, Long> {
}


package com.admin.adminbackofficeapplication.repository;

import com.admin.adminbackofficeapplication.model.Admin;
import com.admin.adminbackofficeapplication.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
}

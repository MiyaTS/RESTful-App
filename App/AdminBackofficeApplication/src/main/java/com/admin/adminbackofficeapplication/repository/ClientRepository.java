package com.admin.adminbackofficeapplication.repository;

import com.admin.adminbackofficeapplication.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
}

package com.musafir.driver.repository;

import com.musafir.driver.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long>{

    boolean existsByPhone(String phone);
    Optional<Driver> findByPhone(String phone);
}

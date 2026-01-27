package com.musafir.driver.repository;

import com.musafir.model.entity.Driver;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long>{

}

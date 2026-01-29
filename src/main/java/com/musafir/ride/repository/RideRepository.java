package com.musafir.ride.repository;

import com.musafir.driver.entity.Driver;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RideRepository extends JpaRepository<Driver,Long>{

}

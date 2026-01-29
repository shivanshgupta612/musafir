package com.musafir.rider.repository;

import com.musafir.rider.entity.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RiderRepository extends JpaRepository<Rider,Long>{
    boolean existsByPhone(String phone);
    Optional<Rider> findByPhone(String Phone);
}

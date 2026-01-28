package com.musafir.driver.entity;

import com.musafir.common.enums.VehicleType;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String regNo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VehicleType vehicleType;

    @OneToOne
    @JoinColumn(name="driver_id", nullable = false, unique = true)
    private Driver driver;
}

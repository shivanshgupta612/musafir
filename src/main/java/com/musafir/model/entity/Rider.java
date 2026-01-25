package com.musafir.model.entity;

import com.musafir.model.enums.DriverStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="riders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column
    private Double rating;
}

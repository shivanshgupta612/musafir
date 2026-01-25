package com.musafir.model.entity;

import com.musafir.model.value.Location;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="rides")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Location source;

    @Column(nullable = false)
    private Location destination;

    @Column(nullable = false)
    private Long fare;

    @Column(nullable = false)
    Driver driver;

    @Column(nullable = false)
    Rider rider;

}

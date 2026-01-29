package com.musafir.ride.entity;

import com.musafir.driver.entity.Driver;
import com.musafir.rider.entity.Rider;
import com.musafir.common.enums.RideStatus;
import com.musafir.common.vo.Location;
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

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="lat", column=@Column(name="source_lat")),
            @AttributeOverride(name="lon", column=@Column(name="source_lon"))
    })
    private Location source;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="lat", column=@Column(name="destination_lat")),
            @AttributeOverride(name="lon", column=@Column(name="destination_lon"))
    })
    private Location destination;

    @Column(nullable = false)
    private Long fare;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RideStatus status = RideStatus.REQUESTED;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "rider_id", nullable = false)
    private Rider rider;

}

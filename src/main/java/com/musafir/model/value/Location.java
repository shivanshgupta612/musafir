package com.musafir.model.value;

import jakarta.persistence.Embeddable;

@Embeddable
public class Location {
    private Double lat;
    private Double lon;
}

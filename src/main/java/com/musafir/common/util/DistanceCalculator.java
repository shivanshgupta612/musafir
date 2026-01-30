package com.musafir.common.util;

import com.musafir.common.vo.Location;

public final class DistanceCalculator {
    public static double calculateKm(Location a, Location b) {
        double R = 6371; // earth radius
        double latDistance = Math.toRadians(b.getLat() - a.getLat());
        double lonDistance = Math.toRadians(b.getLon() - a.getLon());

        double h = Math.sin(latDistance/2) * Math.sin(latDistance/2)
                + Math.cos(Math.toRadians(a.getLat()))
                * Math.cos(Math.toRadians(b.getLat()))
                * Math.sin(lonDistance/2) * Math.sin(lonDistance/2);

        return 2 * R * Math.atan2(Math.sqrt(h), Math.sqrt(1-h));
    }
}

package com.mylab.learn.myarchetype.service;

import com.mylab.learn.myarchetype.domain.Aircraft;

public class ServiceUtils {

    public static AircraftSumary convertAircraftToAircraftSumary(final Aircraft aircraft) {
        return new AircraftSumary(aircraft.getName(), aircraft.getRegistration());
    }

}

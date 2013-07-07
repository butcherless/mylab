package com.mylab.learn.myarchetype.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mylab.learn.myarchetype.domain.Aircraft;
import com.mylab.learn.myarchetype.domain.Destination;
import com.mylab.learn.myarchetype.domain.DomainFactory;
import com.mylab.learn.myarchetype.repository.AircraftRepository;
import com.mylab.learn.myarchetype.repository.DestinationRepository;

@Service
public class AviationServiceImpl implements AviationService {

    @Autowired
    private AircraftRepository aircraftRepository;

    @Autowired
    private DestinationRepository destinationRepository;

    @Override
    @Transactional
    public Long dummyOperation() {
        // TODO Auto-generated method stub
        Aircraft aircraft = createAircraft();

        String shortCode = "mad";
        Destination destination = this.destinationRepository.findByShortCode(shortCode);

        aircraft.addDestination(destination);

        return aircraft.getId();
    }

    private Aircraft createAircraft() {
        Aircraft aircraft = DomainFactory.newAircraft("Saturno", "e-sat");
        this.aircraftRepository.save(aircraft);

        return aircraft;
    }

}

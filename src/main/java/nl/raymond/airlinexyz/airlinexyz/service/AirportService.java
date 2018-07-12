package nl.raymond.airlinexyz.airlinexyz.service;

import nl.raymond.airlinexyz.airlinexyz.domain.Airport;
import nl.raymond.airlinexyz.airlinexyz.domain.Fleet;
import nl.raymond.airlinexyz.airlinexyz.repository.AirportRepository;
import nl.raymond.airlinexyz.airlinexyz.repository.FleetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    private FleetRepository fleetRepository;

    public Airport save(Airport fleet) {
        return airportRepository.save(fleet);
    }

    public List<Airport> findAll() {
        return airportRepository.findAll();
    }
    public List<Fleet> findAllFleet(Long id) {
        return fleetRepository.findByAirportId(id);
    }

    public Optional<Airport> findOne(Long id) {
        return airportRepository.findById(id);
    }

    public void delete(Long id) {
        airportRepository.deleteById(id);
    }
}

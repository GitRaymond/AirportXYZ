package nl.raymond.airlinexyz.airlinexyz.service;

import nl.raymond.airlinexyz.airlinexyz.domain.Fleet;
import nl.raymond.airlinexyz.airlinexyz.repository.FleetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FleetService {

    @Autowired
    private FleetRepository fleetRepository;

    public Fleet save(Fleet fleet) {
        return fleetRepository.save(fleet);
    }

    public List<Fleet> findAll() {
        return fleetRepository.findAll();
    }

    public Optional<Fleet> findOne(Long id) {
        return fleetRepository.findById(id);
    }

    public void delete(Long id) {
        fleetRepository.deleteById(id);
    }

    public List<Fleet> findAllByAirport(Long id) {
        return fleetRepository.findByAirportId(id);
    }
}

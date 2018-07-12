package nl.raymond.airlinexyz.airlinexyz.repository;

import nl.raymond.airlinexyz.airlinexyz.domain.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
}

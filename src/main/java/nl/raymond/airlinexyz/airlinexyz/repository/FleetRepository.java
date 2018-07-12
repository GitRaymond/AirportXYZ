package nl.raymond.airlinexyz.airlinexyz.repository;

import nl.raymond.airlinexyz.airlinexyz.domain.Fleet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FleetRepository extends JpaRepository<Fleet, Long> {
    List<Fleet> findByAirportId(Long id);
}

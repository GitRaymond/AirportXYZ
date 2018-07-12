package nl.raymond.airlinexyz.airlinexyz.repository;

import nl.raymond.airlinexyz.airlinexyz.domain.Fleet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FleetRepository extends JpaRepository<Fleet, Long> {
}

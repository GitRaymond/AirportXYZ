package nl.raymond.airlinexyz.airlinexyz.rest;

import nl.raymond.airlinexyz.airlinexyz.domain.Airport;
import nl.raymond.airlinexyz.airlinexyz.domain.Fleet;
import nl.raymond.airlinexyz.airlinexyz.service.AirportService;
import nl.raymond.airlinexyz.airlinexyz.service.FleetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FleetResource {

    @Autowired
    private FleetService fleetService;

    @Autowired
    private AirportService airportService;

    @PostMapping("/airports/{id}/fleets")
    public ResponseEntity<Fleet> createFleet(@PathVariable Long airport_id, @RequestBody Fleet fleet) {
        if(fleet.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<Airport> airport = airportService.findOne(airport_id);
        if(airport.isPresent()) {
            fleet.setAirport(airport.get());
        }

        fleetService.save(fleet);
        return new ResponseEntity<Fleet>(HttpStatus.OK);
    }

    @PutMapping("/airports/{airportId}/fleets/{fleetId}")
    public  ResponseEntity<Fleet> updateFleet(
            @PathVariable Long airport_id,
            @RequestBody Fleet fleet) {

        Optional<Fleet> result = fleetService.findOne(fleet.getId());
        Optional<Airport> airport = airportService.findOne(airport_id);

        if (result.isPresent()) {
            Fleet checkedResult = result.get();
            checkedResult.setAirplane(fleet.getAirplane());
            checkedResult.setFuel(fleet.getFuel());

            if (airport.isPresent()) {
                checkedResult.setAirport(airport.get());
            }

            fleetService.save(checkedResult);
            return new ResponseEntity<Fleet>(checkedResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/fleets/{id}")
    public  ResponseEntity<Fleet> getFleet(@PathVariable Long id) {

        Optional<Fleet> result = fleetService.findOne(id);

        if(result.isPresent()) {
            return new ResponseEntity<Fleet>(result.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/airports/{id}/fleets")
    public ResponseEntity<List<Fleet>> getAllFleetsByAirport(@PathVariable Long id) {

        Optional<Airport> airport = airportService.findOne(id);

        if(airport.isPresent()) {
            return new ResponseEntity<List<Fleet>>(
                    fleetService.findAllByAirport(airport.get().getId()),
                    HttpStatus.OK);
        } else {
            System.out.println("test");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}

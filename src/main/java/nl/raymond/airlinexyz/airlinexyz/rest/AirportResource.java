package nl.raymond.airlinexyz.airlinexyz.rest;

import nl.raymond.airlinexyz.airlinexyz.domain.Airport;
import nl.raymond.airlinexyz.airlinexyz.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AirportResource {

    @Autowired
    private AirportService airportService;

    @PostMapping("/airports")
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
        if(airport.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        airportService.save(airport);
        return new ResponseEntity<Airport>(HttpStatus.OK);
    }

    @PutMapping("/airports/{id}")
    public  ResponseEntity<Airport> updateAirport(@RequestBody Airport airport) {

        Optional<Airport> result = airportService.findOne(airport.getId());

        if (result.isPresent()) {
            Airport checkedResult = result.get();
            checkedResult.setName(airport.getName());
            airportService.save(checkedResult);
            return new ResponseEntity<Airport>(checkedResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/airports/{id}")
    public  ResponseEntity<Airport> getAirport(@PathVariable Long id) {

        Optional<Airport> result = airportService.findOne(id);

        if(result.isPresent()) {
            return new ResponseEntity<Airport>(result.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/airports")
    public ResponseEntity<List<Airport>> getAllAirports() {
        return new ResponseEntity<List<Airport>>(airportService.findAll(), HttpStatus.OK);
    }


}

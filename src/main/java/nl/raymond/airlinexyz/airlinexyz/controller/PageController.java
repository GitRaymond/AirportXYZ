package nl.raymond.airlinexyz.airlinexyz.controller;

import nl.raymond.airlinexyz.airlinexyz.domain.Airport;
import nl.raymond.airlinexyz.airlinexyz.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/")
public class PageController {

    @Autowired
    private AirportService airportService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        // get entity

        Airport airport = airportService.findOne(1L).get();

        model.put("airport", airport);

        return "index";
    }
}

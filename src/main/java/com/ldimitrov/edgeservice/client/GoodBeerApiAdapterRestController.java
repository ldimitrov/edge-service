package com.ldimitrov.edgeservice.client;

import com.ldimitrov.edgeservice.model.Beer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class GoodBeerApiAdapterRestController {

    private final BeerClient beerClient;

    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/good-beers")
    @CrossOrigin(origins = "*")
    public Collection<Beer> goodBeers() {
        return beerClient.readBeers()
                .getContent()
                .stream()
                .filter(this::isGreat)
                .collect(Collectors.toList());
    }

    public Collection<Beer> fallback() {
        return new ArrayList<>();
    }

    private boolean isGreat(Beer beer) {
        return !beer.getName().equals("Löwenbräu") &&
                !beer.getName().equals("Paulaner") &&
                !beer.getName().equals("Hacker Pschorr") &&
                !beer.getName().equals("Spaten");
    }

}

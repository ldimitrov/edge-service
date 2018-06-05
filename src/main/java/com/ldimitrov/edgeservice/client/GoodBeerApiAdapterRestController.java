package com.ldimitrov.edgeservice.client;

import com.ldimitrov.edgeservice.model.Beer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class GoodBeerApiAdapterRestController {

    private final BeerClient beerClient;

    @GetMapping("/good-beers")
    public Collection<Beer> goodBeers() {
        return beerClient.readBeers()
                .getContent()
                .stream()
                .filter(this::isGreat)
                .collect(Collectors.toList());
    }

    private boolean isGreat(Beer beer) {
        return !beer.getName().equals("Löwenbräu") &&
                !beer.getName().equals("Paulaner") &&
                !beer.getName().equals("Hacker Pschorr") &&
                !beer.getName().equals("Spaten");
    }

}

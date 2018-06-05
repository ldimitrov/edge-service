package com.ldimitrov.edgeservice.client;

import com.ldimitrov.edgeservice.model.Beer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("beer-catalog-service")
public interface BeerClient {

    @GetMapping("/beers")
    Resources<Beer> readBeers();
}

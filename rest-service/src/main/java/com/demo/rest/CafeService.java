package com.demo.rest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import jakarta.ws.rs.core.Response;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;


@Path("/cafe")
@ApplicationScoped
// @Produces(MediaType.APPLICATION_JSON)
// @Consumes(MediaType.APPLICATION_JSON)
public class CafeService {

    private final Map<String, Drink> drinkInventory = new HashMap<>();

    @PostConstruct
    public void initCafe() {
        createDrink("tea", 1.25);
        createDrink("coffee", 1.50);
        // createDrink("latte", 2.00);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Drink> getAllDrinks() {
        return drinkInventory.values();
    }

    @GET
    @Path("/size")
    public int getInventorySize() {
        return drinkInventory.size();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void createDrink(@QueryParam("name") @NotEmpty @Size(min = 2, max = 50) String name,
                             @QueryParam("cost") @PositiveOrZero double cost) {
        Drink d = new Drink(name, cost);
        drinkInventory.put(d.name, d);
    }
    
}

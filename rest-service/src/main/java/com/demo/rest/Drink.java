package com.demo.rest;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class Drink {

    @NotNull
    @Size(min = 2, max = 50)
    public final String name;

    @NotNull
    @PositiveOrZero
    public final double cost;

    @JsonbCreator
    public Drink(@JsonbProperty("name") String name,
            @JsonbProperty("cost") double cost) {
        this.name = name;
        this.cost = cost;
    }

}

package com.example.rest.client;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.rest.client.api.ApiException;
import com.example.rest.client.api.DefaultApi;
import com.example.rest.client.models.Drink;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
@Path("/")
public class CafeController {

    @Inject
    @RestClient
    DefaultApi cafeSvc;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getMenu")
    public List<Drink> getMenu() throws ProcessingException, ApiException {
        return cafeSvc.apiCafeGet();
    }
    
}

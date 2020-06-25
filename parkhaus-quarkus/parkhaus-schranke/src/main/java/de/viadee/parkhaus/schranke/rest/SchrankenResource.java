package de.viadee.parkhaus.schranke.rest;

import de.viadee.parkhaus.schranke.service.SchrankenService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/schranke")
public class SchrankenResource {

    @Inject
    SchrankenService SchrankenService;

    @Path("/{id}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get(@PathParam("id") String id) {
        return this.SchrankenService.canExit(id) ? "GREEN" : "RED";
    }
}


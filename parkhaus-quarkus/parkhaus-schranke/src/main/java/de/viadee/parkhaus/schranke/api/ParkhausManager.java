package de.viadee.parkhaus.schranke.api;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@RegisterRestClient
@Path("/parkticket")
public interface ParkhausManager {

    @Path("{id}/isAllowedToExit")
    @GET
    public boolean isAllowedToExit(@PathParam("id") String id);

}


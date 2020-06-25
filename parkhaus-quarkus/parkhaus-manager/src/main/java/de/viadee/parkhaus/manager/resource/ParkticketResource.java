package de.viadee.parkhaus.manager.resource;

import de.viadee.parkhaus.manager.entity.Parkticket;
import de.viadee.parkhaus.manager.service.ParkticketService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.List;

@Path("/parkticket")
public class ParkticketResource {

    final ParkticketService parkticketService;

    @Inject
    public ParkticketResource(ParkticketService parkticketService) {
      this.parkticketService = parkticketService;
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String create(@QueryParam("entered") LocalDateTime entered) {
        return parkticketService.create(entered);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Parkticket get(String id) {
      return parkticketService.get(id);
    }

    @GET
    @Path("/{id}/getPaymentAmount")
    @Produces(MediaType.APPLICATION_JSON)
    public Double getPaymentAmount(@PathParam("id") String id) {
      return parkticketService.getPaymentAmount(id);
    }

    @PUT
    @Path("{id}/makePayment")
    @Consumes(MediaType.TEXT_PLAIN)
    public Boolean makePayment(@PathParam("id") String id, Double payment) {
        return parkticketService.makePayment(id, payment);
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Parkticket> getAll() {
      return parkticketService.getAll();
    }

    @GET
    @Path("/{id}/isAllowedToExit")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean isAllowedToExit(@PathParam("id") String id) {
      return parkticketService.isAllowedToExit(id);
    }

}

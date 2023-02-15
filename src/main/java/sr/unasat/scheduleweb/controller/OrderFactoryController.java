package sr.unasat.scheduleweb.controller;

import sr.unasat.scheduleweb.service.DeliveryFactoryService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/delivery")
public class OrderFactoryController {

    private DeliveryFactoryService deliveryFactoryService = new DeliveryFactoryService();
    @Path("/order")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void getDelivery(){
        System.out.println(deliveryFactoryService.deliveryService());
    }

}

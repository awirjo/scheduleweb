package sr.unasat.scheduleweb.controller;

import sr.unasat.scheduleweb.service.SpecialMealDecoService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/order")
public class SpecialMealDecoController {

    private SpecialMealDecoService specialDeco = new SpecialMealDecoService();
    @Path("/special")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void getOrder(){
        System.out.println(specialDeco.getSpecial());
    }

}

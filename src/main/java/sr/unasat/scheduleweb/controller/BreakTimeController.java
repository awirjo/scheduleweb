package sr.unasat.scheduleweb.controller;
import sr.unasat.scheduleweb.dto.BreakTimeDTO;
import sr.unasat.scheduleweb.entities.BreakTime;
import sr.unasat.scheduleweb.service.BreakTimeService;

import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("breakTime")

public class BreakTimeController {

    private BreakTimeService breakTimeService = new BreakTimeService();


    @PersistenceContext(unitName = "PERSISTENCE")

    @Path("breakList")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BreakTime> findBreak(){
        System.out.println(breakTimeService.findAllBreakTime());
        return breakTimeService.findAllBreakTime();
    }

    @Path("/addBreak")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public BreakTime createBreak(BreakTimeDTO breakTimeDTO) {
        return breakTimeService.createBreakTime(breakTimeDTO);
    }

    @Path("/remove")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public void deleteBreakTime(String breakTime) {
        breakTimeService.deleteBreakTime(breakTime);
    }

}

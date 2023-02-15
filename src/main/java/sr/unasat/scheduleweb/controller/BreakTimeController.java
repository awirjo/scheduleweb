package sr.unasat.scheduleweb.controller;

import sr.unasat.scheduleweb.entities.BreakTime;
import sr.unasat.scheduleweb.service.BreakTimeService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("breakTime")
public class BreakTimeController {

    private BreakTimeService breakTimeService = new BreakTimeService();
    @Path("breakList")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<BreakTime> findBreak(){
        System.out.println(breakTimeService.findAllBreakTime());
        return breakTimeService.findAllBreakTime();
    }
}

package sr.unasat.scheduleweb.controller;

import sr.unasat.scheduleweb.entities.BreakTime;
import sr.unasat.scheduleweb.entities.Menu;
import sr.unasat.scheduleweb.service.BreakTimeService;

import javax.ws.rs.*;
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

    @Path("/addBreak")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void add(BreakTime breakTime){
        breakTimeService.insertBreakTime(breakTime);
    }

    @Path("/removeBreak")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void remove(String breakTime){
        breakTimeService.deleteBreakTime(breakTime);
    }

    @Path("/getBreak")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BreakTime getBreakTime(int breakTimeId){
        return breakTimeService.updateBreakTime(breakTimeId);
    }


}

package sr.unasat.scheduleweb.controller;

import sr.unasat.scheduleweb.entities.BreakTime;
import sr.unasat.scheduleweb.service.ReportsService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/reports")
public class ReportsController {

    private ReportsService reportsService = new ReportsService();
    @Path("/quarter")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReportByQuarter(){
        List<BreakTime> breakTimeRapportByQuarter = reportsService.breakTimeRapportByQuarter();
        return Response.ok(breakTimeRapportByQuarter).build();
    }

    @Path("/halfYear")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReportByHalfYear(){
        List<BreakTime> breakTimeRapportHalfYear = reportsService.breakTimeRapportHalfYear();
        return Response.ok(breakTimeRapportHalfYear).build();
    }

    @Path("/year")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReportByYear(){
        List<BreakTime> breakTimeRapportByYear = reportsService.breakTimeRapportByYear();
        return Response.ok(breakTimeRapportByYear).build();
    }
}

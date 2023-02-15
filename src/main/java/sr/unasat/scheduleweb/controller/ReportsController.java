package sr.unasat.scheduleweb.controller;

import sr.unasat.scheduleweb.service.ReportsService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/reports")
public class ReportsController {

    private ReportsService reportsService = new ReportsService();
    @Path("/quarter")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void getReportByQuarter(){
        System.out.println(reportsService.breakTimeRapportByQuarter());
    }

    @Path("/halfYear")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void getReportByHalfYear(){
        System.out.println(reportsService.breakTimeRapportHalfYear());
    }

    @Path("/year")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void getReportByYear(){
        System.out.println(reportsService.breakTimeRapportByYear());
    }
}

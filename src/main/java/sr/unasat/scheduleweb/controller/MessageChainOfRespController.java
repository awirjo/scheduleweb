package sr.unasat.scheduleweb.controller;

import sr.unasat.scheduleweb.service.MessageChainOfRespService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/message")
public class MessageChainOfRespController {

    private MessageChainOfRespService messageChain = new MessageChainOfRespService();
    @Path("/chain")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void getMessage(){
        System.out.println(messageChain.messageMaker());
    }
}

package sr.unasat.scheduleweb.service;

import sr.unasat.scheduleweb.chainofresp.*;

public class MessageChainOfRespService {
    public boolean messageMaker(){
        System.out.println("Chain Of Responsibility Design Pattern Handling.\n");

        //End of Chain Of Responsibility:
        FirstDepartmentHandler firstDepartmentHandler = new FirstDepartmentHandler();

        //First handler
        SecondDepartmentHandler secondDepartmentHandler = new SecondDepartmentHandler();
        secondDepartmentHandler.setNextChain(firstDepartmentHandler);

        //Starting point: Raiser will raise issues and set the first handler:
        IssueRaiser raiser = new IssueRaiser(secondDepartmentHandler);

        Message messagePrint = new Message("ICT request order to be delivered", MessagePriority.High );

        raiser.raiseMessage(messagePrint);
        return true;
    }
}

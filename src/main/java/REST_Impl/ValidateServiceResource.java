package REST_Impl;

import Model.Validation.Validation;
import REST_Interface.ValidateService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ValidateServiceResource implements ValidateService {
    private Validation validation;

    public ValidateServiceResource(Validation validation){
        this.validation = validation;
    }

    @Override
    public String getStuff(){
        return validation.getTestString();
    }

    @Override
    public Response validateShit(){
        String json = "{\n"+
                "\"response\": \"hello there\" \n"+
                "}";
        return Response.status(200)
                .entity(json)
                .build();
    }
}

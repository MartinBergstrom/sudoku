package REST_Impl;

import Model.Validation.Validation;
import REST_Interface.ValidateService;
import com.google.gson.Gson;

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
    public Response validateShit(String jsonMatrix){
        Gson gson = new Gson();
        if (validation.validateSudoku(gson.fromJson(jsonMatrix, int[][].class))){
            return Response.status(200).build();
        }else {
            return Response.status(400).build();
        }
    }
}

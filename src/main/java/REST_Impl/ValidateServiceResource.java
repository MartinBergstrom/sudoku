package REST_Impl;

import Model.Validation.Validation;
import Model.Validation.ValidationError;
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
    public Response validateCompleteBoard(String jsonMatrix){
        Gson gson = new Gson();
        ValidationError validationError = validation.validateSudoku(gson.fromJson(jsonMatrix, int[][].class));
        if (validationError.equals(ValidationError.OK)){
            return Response.status(200).build();
        }else {
            return Response.status(400).entity(validationError).build();
        }
    }
}

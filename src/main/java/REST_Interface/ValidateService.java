package REST_Interface;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/validate")
public interface ValidateService {

    /**
     * Validates the completeSudoBoard
     *
     * Does not create any resource, just for validation
     *
     * @return
     */
    @POST
    @Path("/board")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response validateCompleteBoard(String jsonMatrix);
}

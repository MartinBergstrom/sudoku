package REST_Interface;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/validate")
public interface ValidateService {

    @GET
    @Path("getLogic")
    @Produces(MediaType.TEXT_PLAIN)
    public String getStuff();

    /**
     * Does not create any resource, just for validation
     *
     * @return
     */
    @POST
    @Path("validate")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response validateShit();
}

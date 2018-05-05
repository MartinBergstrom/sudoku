package REST_Interface;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/validate")
public interface ValidateService {

    @GET
    @Path("getLogic")
    @Produces(MediaType.TEXT_PLAIN)
    public String getStuff();

    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public Response validateShit();
}

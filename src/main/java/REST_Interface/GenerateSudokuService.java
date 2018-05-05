package REST_Interface;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/generate")
public interface GenerateSudokuService {
    @GET
    @Path("Random")
    @Produces(MediaType.APPLICATION_JSON)
    public Response generateRandomSudoku();
}

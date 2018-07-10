package REST_Interface;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/save")
public interface SaveSudokuService {

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSudoku(String jsonMatrix);

    @PUT
    @Path("update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSudouko(String jsonMatrix, @PathParam("id")UUID uuid);
}

package REST_Interface;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/")
public interface SaveSudokuService {

    @POST
    @Path("create/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createSudoku(String jsonMatrix, @PathParam("id")UUID uuid);

    @PUT
    @Path("save/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSudouko(String jsonMatrix, @PathParam("id")UUID uuid);
}

package REST_Interface;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/")
public interface SaveSudokuService {

    @POST
    @Path("save/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postSudoku(String jsonMatrix, @PathParam("id")UUID uuid);
}

package REST_Interface;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/generate")
public interface GenerateSudokuService {
    
    @GET
    @Path("random/{diffi}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response generateRandomSudoku(@PathParam("diffi")Difficulty difficulty);

    @GET
    @Path("random/file/{diffi}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRandomSudokuFromFile(@PathParam("diffi")Difficulty difficulty);

}

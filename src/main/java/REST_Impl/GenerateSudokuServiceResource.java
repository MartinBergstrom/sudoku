package REST_Impl;

import Model.Sudoku.Generator;
import REST_Interface.GenerateSudokuService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/Generate")
public class GenerateSudokuServiceResource implements GenerateSudokuService {
    private Generator generator;

    public GenerateSudokuServiceResource(Generator generator){
        this.generator = generator;
    }

    //TODO
    // use strategy pattern to decide where to get random sudoku from
    // then use with levels - EASY, MEDIUM, HARD, EXTREME

    @GET
    @Path("Random")
    @Produces(MediaType.APPLICATION_JSON)
    public Response generateRandomSudoku() {
        return null;
    }
}

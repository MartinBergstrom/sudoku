package REST_Impl;

import Model.Persistence.CacheView;
import Model.Sudoku.SudokuBoard;
import Model.Validation.Validation;
import REST_Interface.SaveSudokuService;
import com.google.gson.Gson;

import javax.ws.rs.core.Response;
import java.util.UUID;

public class SaveSudokuServiceResource implements SaveSudokuService {
    private final CacheView cacheView;
    private final Validation validation;

    public SaveSudokuServiceResource(CacheView cacheView, Validation validation){
        this.cacheView = cacheView;
        this.validation = validation;
    }

    @Override
    public Response createSudoku(String jsonMatrix) {
        Response response = validate(jsonMatrix);
        if (response.getStatus() != 200){
            return response;
        }
        Gson gson = new Gson();
        SudokuBoard newBoard = new SudokuBoard(gson.fromJson(jsonMatrix, int[][].class));
        if (cacheView.boardExists(newBoard)){
            return Response.status(422).entity("").build();
        }
        UUID uuid = cacheView.addBoard(newBoard);
        String jsonUuid = gson.toJson(uuid, UUID.class);

        return Response.status(200)
                .entity(jsonUuid)
                .build();
    }

    @Override
    public Response updateSudouko(String jsonMatrix, UUID uuid) {
       return validate(jsonMatrix);
        //return null;
    }

    private Response validate(String jsonMatrix) {
        Gson gson = new Gson();
        if(!validation.validateSudoku(gson.fromJson(jsonMatrix, int[][].class))){
            return Response.status(400)
                    .build();
        }else{
            return Response.status(200).build();
        }
    }
}

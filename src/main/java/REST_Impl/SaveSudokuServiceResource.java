package REST_Impl;

import Model.Persistence.DataBaseInMemoryView;
import Model.Sudoku.SudokuBoard;
import Model.Validation.Validation;
import Model.Validation.ValidationError;
import REST_Interface.SaveSudokuService;
import com.google.gson.Gson;

import javax.ws.rs.core.Response;
import java.util.UUID;

public class SaveSudokuServiceResource implements SaveSudokuService {
    private final DataBaseInMemoryView dataBaseInMemoryView;
    private final Validation validation;

    public SaveSudokuServiceResource(DataBaseInMemoryView dataBaseInMemoryView, Validation validation){
        this.dataBaseInMemoryView = dataBaseInMemoryView;
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
        if (dataBaseInMemoryView.boardExists(newBoard)){
            return Response.status(422).entity("Board already exists").build();
        }
        UUID uuid = dataBaseInMemoryView.addBoard(newBoard);
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
        ValidationError validationError = validation.validateSudoku(gson.fromJson(jsonMatrix, int[][].class));
        if (validationError.equals(ValidationError.OK)){
            return Response.status(200).build();
        }else {
            return Response.status(400).entity(validationError).build();
        }
    }
}

package REST_Impl;

import Model.Persistence.CacheView;
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
    public Response createSudoku(String jsonMatrix, UUID uuid) {
        return null;
    }

    //validate here aswell
    @Override
    public Response updateSudouko(String jsonMatrix, UUID uuid) {
        Gson gson = new Gson();
        if(!validation.validateSudoku(gson.fromJson(jsonMatrix, int[][].class))){
            return Response.status(400)
                    .build();
        }
        return null;
    }
}

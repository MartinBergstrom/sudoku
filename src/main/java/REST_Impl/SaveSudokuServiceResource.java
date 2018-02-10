package REST_Impl;

import Model.Persistence.CacheView;
import REST_Interface.SaveSudokuService;

import javax.ws.rs.core.Response;
import java.util.UUID;

public class SaveSudokuServiceResource implements SaveSudokuService {
    private final CacheView cacheView;

    public SaveSudokuServiceResource(CacheView cacheView){
        this.cacheView = cacheView;
    }

    @Override
    public Response postSudoku(String jsonMatrix, UUID uuid) {
        return null;
    }
}

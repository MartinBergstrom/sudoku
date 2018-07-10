package REST_Impl;

import Model.Sudoku.Generator;
import REST_Interface.Difficulty;
import REST_Interface.GenerateSudokuService;
import com.google.gson.Gson;

import javax.ws.rs.core.Response;
import java.io.FileNotFoundException;


public class GenerateSudokuServiceResource implements GenerateSudokuService {
    private Generator generator;

    public GenerateSudokuServiceResource(Generator generator){
        this.generator = generator;
    }

    @Override
    public Response generateRandomSudoku(Difficulty difficulty) {
        String json = "{\n"+
                "\"response\": \"Random sudoku incoming, with diff:" + difficulty.name() + "\" \n"+
                "}";
        return Response.status(200)
                .entity(json)
                .build();
    }

    @Override
    public Response getSudokukoFromFile(Difficulty difficulty) {
        if(!difficulty.equals(Difficulty.EASY)){
            return Response.status(404)
                    .build();
        }
        int[][] sudoku;
        try {
            sudoku = generator.getRandomSudokuFromFile(difficulty);
        } catch (FileNotFoundException e) {
            return Response.status(404)
                    .build();
        }
        Gson gson = new Gson();
        String jsonArray = gson.toJson(sudoku);
        return Response.status(200)
                .entity(jsonArray)
                .build();
    }
}

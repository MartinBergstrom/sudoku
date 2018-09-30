package REST_Impl;

import Model.Sudoku.Generator;
import Model.Sudoku.GeneratorFactory;
import REST_Interface.Difficulty;
import REST_Interface.GenerateSudokuService;
import com.google.gson.Gson;

import javax.ws.rs.core.Response;

public class GenerateSudokuServiceResource implements GenerateSudokuService {
    private GeneratorFactory generatorFactory;

    public GenerateSudokuServiceResource(GeneratorFactory generatorFactory){
        this.generatorFactory = generatorFactory;
    }

    @Override
    public Response generateRandomSudoku(Difficulty difficulty) {
        //TODO
        Generator generator = generatorFactory.getGenerator(GeneratorFactory.GeneratorType.DEFAULT_GENERATOR);
        try {
            int[][] generatedBoard = generator.generateRandomSudoku(difficulty);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String json = "{\n"+
                "\"response\": \"Random sudoku incoming, with diff:" + difficulty.name() + "\" \n"+
                "}";
        return Response.status(200)
                .entity(json)
                .build();
    }

    @Override
    public Response getRandomSudokuFromFile(Difficulty difficulty) {
        Generator generator = generatorFactory.getGenerator(GeneratorFactory.GeneratorType.FILE_GENERATOR);
        if (!difficulty.equals(Difficulty.EASY)){
            return Response.status(404)
                    .build();
        }
        int[][] sudoku;
        try {
            sudoku = generator.generateRandomSudoku(difficulty);
        } catch (Exception e) {
            return Response.status(404)
                    .entity(e)
                    .build();
        }
        return buildJsonSudokuResponse(sudoku);
    }

    private Response buildJsonSudokuResponse(int[][] sudoku) {
        Gson gson = new Gson();
        String jsonArray = gson.toJson(sudoku);
        return Response.status(200)
                .entity(jsonArray)
                .build();
    }
}

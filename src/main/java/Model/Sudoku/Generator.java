package Model.Sudoku;

import REST_Interface.Difficulty;

import java.io.FileNotFoundException;

public interface Generator {

    public int[][] generateRandomSudoku(Difficulty difficulty) throws Exception;

    public int numberOfGeneratedSudokus();
}

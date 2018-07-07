package Model.Sudoku;

import REST_Interface.Difficulty;

import java.io.FileNotFoundException;

public interface Generator {

    public int[][] getRandomSudokuFromFile(Difficulty difficulty) throws FileNotFoundException;

    public int[][] generateRandomSudoku(Difficulty difficulty);
}

package Model.Sudoku;

import REST_Interface.Difficulty;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class SudokuGenerator implements Generator
{
    @Override
    public int[][] generateRandomSudoku(Difficulty difficulty) {
        // use backtracking algorithm and shit
        return new int[0][];
    }

    @Override
    public int numberOfGeneratedSudokus() {
        return 0;
    }

}

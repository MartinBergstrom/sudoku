package Model.Sudoku;

import REST_Interface.Difficulty;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.Scanner;

public class SudokuFromFileGenerator implements Generator {
    private static final String SUDOKU_RESOURCES = "Sudokus";
    private static int counter = 0;

    @Override
    public int[][] generateRandomSudoku(Difficulty difficulty) throws Exception{
        URL url = SudokuGenerator.class.getClassLoader().getResource(SUDOKU_RESOURCES);
        try {
            File dir = new File(url.toURI());
            File foundDir = null;
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir.toPath(),
                    f -> Files.isDirectory(f))){
                for (Path p: stream){
                    foundDir = p.toFile();
                    if (foundDir.getName().equalsIgnoreCase(difficulty.name())){
                        break;
                    }
                }
            } catch (IOException e) {
                throw new FileNotFoundException("Could not find any file with specified difficulty");
            }
            if (foundDir != null){
                File[] sudokus = foundDir.listFiles();
                return createSudokuArrayFromFile(sudokus[(new Random()).nextInt(sudokus.length)]);
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int numberOfGeneratedSudokus() {
        return counter;
    }

    private static int[][] createSudokuArrayFromFile(File file) throws FileNotFoundException {
        try(Scanner scanner = new Scanner(file)){
            int[][] sudokuBoard = new int[9][9];
            for (int i = 0; i<9; i++){
                String[] line = scanner.nextLine().split("");
                for (int j = 0; j<9; j++){
                    sudokuBoard[i][j] = Integer.parseInt(line[j]);
                }
            }
            counter++;
            return sudokuBoard;
        }
    }
}

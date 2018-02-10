package Model.Sudoku;

import java.awt.*;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class SudokuBoard{
    private final UUID ID;
    private Cell[][] matrix;

    public SudokuBoard(int[][] array){
        initializeMatrixClassicWay(array);
        printMatrix();
        ID = UUID.randomUUID();
    }

    public UUID getID(){
        return ID;
    }

    public Stream<Cell[]> getRowsAsStream(){
        return Arrays.stream(matrix);
    }

    public Cell[][] getSquare(CellSquare cellSquare){
        Cell[][] squareCell = new Cell[3][3];
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                squareCell[i][j] = matrix[cellSquare.x+i][cellSquare.y+j];
            }
        }
        return squareCell;
    }


    private void initializeMatrixClassicWay(int[][] array){
        matrix = new Cell[9][9];
        for (int i = 0; i<array.length; i++) {
            for(int j = 0; j<array[i].length; j++){
                matrix[i][j] = new Cell(array[i][j]);
            }
        }
    }

    /**
     * Overkill java8 way of doing it
     *
     * @param array
     */
    private void initializeMatrix(int[][] array){
        matrix = Stream.of(array)
                .map(row -> IntStream.of(row)
                        .mapToObj(Cell::new).toArray(Cell[]::new))
                .toArray(Cell[][]::new);
    }

//    interface IntegerToCellFunction{
//
//        public Cell applyAsCell(int nbr);
//
//    }
//
//    private Cell[][] transformArray(int[][] array, IntegerToCellFunction function){
//        //TODO fix shit
//        return null;
//    }

    private void printMatrix(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Represents a CellSquare in the grid
     * x and y will be the start point for the square,
     * always starting from the top left corner
     *
     */
    public enum CellSquare{
        TOP_LEFT(0,0),
        TOP(3,0),
        TOP_RIGHT(6,0),
        MIDDLE_LEFT(0,3),
        MIDDLE(3,3),
        MIDDLE_RIGHT(6,3),
        BOT_LEFT(0,6),
        BOT(3,6),
        BOT_RIGHT(6,6);

        private int x;
        private int y;

        CellSquare(int x, int y){
            this.x = x;
            this.y = y;
        }

        public Point getPoint(){
            return new Point(x,y);
        }
    }
}

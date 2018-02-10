package Model.Validation;


import Model.Sudoku.Cell;
import Model.Sudoku.SudokuBoard;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.rmi.runtime.Log;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ValidateImpl implements Validation {
    private static final Logger LOG = LogManager.getLogger(ValidateImpl.class);

    @Override
    public boolean validateSudoku(int[][] matrix) {
        SudokuBoard sudokuBoard = new SudokuBoard(matrix);

        int numberOfValidRows = (int) sudokuBoard.getRowsAsStream()
                .filter(ValidateImpl::checkIfValidRow)
                .count();
        boolean rowCheck = numberOfValidRows == 9;
        if(rowCheck)
            LOG.log(Level.INFO, "Row check validation is OK");

        boolean squareCheck = checkSquares(sudokuBoard);
        if(squareCheck)
            LOG.log(Level.INFO, "Square check validation is OK");

        return (rowCheck && squareCheck);
    }

    private static boolean checkSquares(SudokuBoard board){
        for (SudokuBoard.CellSquare cellSquare: SudokuBoard.CellSquare.values()){
            Cell[][] cells = board.getSquare(cellSquare);
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < cells.length; i++){
                for(int j = 0; j < cells[i].length; j++){
                    Cell cell = cells[i][j];
                    Optional<Integer> cellNumber = cell.getCellNumber();
                    if(cellNumber.isPresent()){
                        int value = cellNumber.get();
                        if(set.contains(value)){
                            return false;
                        }
                        set.add(value);
                    }
                }
            }
        }
        return true;
    }


    private static boolean checkIfValidRow(Cell[] row){
        for(Cell cell : row){
            Set<Integer> set = new HashSet<>();
            Optional<Integer> optional = cell.getCellNumber();
            if(optional.isPresent()){
                int value = optional.get();
                if(set.contains(value)){
                    return false;
                }
                set.add(value);
            }
        }
        return true;
    }


    public String getTestString() {
        return "TEST from ValidateIMPL";
    }
}

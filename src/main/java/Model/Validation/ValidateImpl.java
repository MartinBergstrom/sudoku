package Model.Validation;


import Model.Sudoku.Cell;
import Model.Sudoku.SudokuBoard;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.IntStream;

public class ValidateImpl implements Validation {
    private static final Logger LOG = LogManager.getLogger(ValidateImpl.class);

    @Override
    public ValidationError validateSudoku(int[][] matrix) {
        OptionalInt invalidValue = Arrays.stream(matrix)
                .flatMapToInt(IntStream::of)
                .filter(e -> e < 0 || e > 9)
                .findAny();
        if (invalidValue.isPresent()) {
            return ValidationError.INVALID_NUMBER;
        }
        SudokuBoard sudokuBoard = new SudokuBoard(matrix);

        int numberOfValidRows = (int) sudokuBoard.getRowsAsStream()
                .filter(ValidateImpl::checkIfValidRow)
                .count();
        boolean rowCheck = numberOfValidRows == 9;
        if (!rowCheck) {
            LOG.log(Level.INFO, "Row check validation failed");
            return ValidationError.ROW_CHECK_FAILED;
        }
        boolean squareCheck = checkSquares(sudokuBoard);
        if (!squareCheck) {
            LOG.log(Level.INFO, "Square check validation failed");
            return ValidationError.SQUARE_CHECK_FAILED;
        }
        return ValidationError.OK;
    }

    private static boolean checkSquares(SudokuBoard board) {
        for (SudokuBoard.CellSquare cellSquare : SudokuBoard.CellSquare.values()) {
            Cell[][] cells = board.getSquare(cellSquare);
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    Cell cell = cells[i][j];
                    Optional<Integer> cellNumber = cell.getCellNumber();
                    if (cellNumber.isPresent()) {
                        int value = cellNumber.get();
                        if (set.contains(value)) {
                            return false;
                        }
                        set.add(value);
                    }
                }
            }
        }
        return true;
    }

    private static boolean checkIfValidRow(Cell[] row) {
        Set<Integer> set = new HashSet<>();
        for (Cell cell : row) {
            Optional<Integer> optional = cell.getCellNumber();
            if (optional.isPresent()) {
                int value = optional.get();
                if (set.contains(value)) {
                    return false;
                }
                set.add(value);
            }
        }
        return true;
    }
}
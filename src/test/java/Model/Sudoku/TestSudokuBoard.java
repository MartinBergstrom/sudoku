package Model.Sudoku;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestSudokuBoard {
    private int[][] sudokuExample = new int[][]{
            {8,3,5,4,1,6,0,2,7},
            {2,9,6,8,5,7,4,3,1},
            {4,1,7,2,0,3,6,5,8},
            {5,6,9,1,3,4,2,8,2},
            {1,2,3,6,7,8,5,4,9},
            {7,4,8,4,2,9,1,6,3},
            {6,5,2,7,8,1,3,9,4},
            {9,8,1,3,4,5,2,7,6},
            {3,7,4,9,6,2,8,1,5}
    };

    @Test
    public void shouldCreate(){
        new SudokuBoard(sudokuExample);
    }

    @Test
    public void shouldBeEqualIfSameBoard() {
        SudokuBoard firstBoard = new SudokuBoard(sudokuExample);
        UUID firstUUID = firstBoard.getID();

        SudokuBoard secondBoard = new SudokuBoard(sudokuExample);
        UUID secondUUID = secondBoard.getID();

        assertNotEquals(firstUUID, secondUUID);
        assertEquals(firstBoard,secondBoard);
    }
}

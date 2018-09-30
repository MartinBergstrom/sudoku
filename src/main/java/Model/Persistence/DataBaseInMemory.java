package Model.Persistence;

import Model.Sudoku.SudokuBoard;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataBaseInMemory implements PersistenceView {
    private final List<SudokuBoard> sudokuBoards;
    private static DataBaseInMemory instance;

    public static DataBaseInMemory getInstance(){
        if(instance == null){
            instance = new DataBaseInMemory();
        }
        return instance;
    }
    private DataBaseInMemory() {
        sudokuBoards = new ArrayList<>();
    }

    @Override
    public synchronized boolean boardExists(SudokuBoard board) {
        synchronized (sudokuBoards) {
            return sudokuBoards.contains(board);
        }
    }

    @Override
    public synchronized UUID addBoard(SudokuBoard board) {
        sudokuBoards.add(board);
        return board.getID();
    }

    @Override
    public synchronized void updateBoard(int[][] board, UUID uuid) throws SudokuUIIDNotFoundException {
        SudokuBoard foundBoard = null;
        for (SudokuBoard b: sudokuBoards) {
            if (b.getID().equals(uuid)){
                foundBoard = b;
            }
        }
        if (foundBoard == null) {
            throw new SudokuUIIDNotFoundException();
        }
    }

    @Override
    public synchronized SudokuBoard getWithId(UUID uuid) {
        for (SudokuBoard board : sudokuBoards) {
            if (board.getID().equals(uuid)) {
                return board;
            }
        }
        return null;
    }

    @Override
    public synchronized ImmutableList<SudokuBoard> getAll() {
        return ImmutableList.copyOf(sudokuBoards);
    }
}


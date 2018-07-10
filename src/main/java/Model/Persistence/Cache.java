package Model.Persistence;

import Model.Sudoku.SudokuBoard;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cache implements CacheView{
    private List<SudokuBoard> sudokuBoards;
    private static Cache instance;

    public static Cache getInstance(){
        if(instance == null){
            instance = new Cache();
        }
        return instance;
    }
    private Cache() {
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
    public void updateBoard(int[][] board, UUID uuid) {

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


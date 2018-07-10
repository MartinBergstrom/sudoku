package Model.Persistence;

import Model.Sudoku.SudokuBoard;
import com.google.common.collect.ImmutableList;

import java.util.UUID;

public interface CacheView {

    public boolean boardExists(SudokuBoard board);

    public UUID addBoard(SudokuBoard board);

    public void updateBoard(int[][] board, UUID uuid);

    public SudokuBoard getWithId(UUID uuid);

    public ImmutableList<SudokuBoard> getAll();
}

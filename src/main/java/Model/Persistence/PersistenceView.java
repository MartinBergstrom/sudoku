package Model.Persistence;

import Model.Sudoku.SudokuBoard;
import com.google.common.collect.ImmutableList;

import java.util.UUID;

public interface PersistenceView {

    public boolean boardExists(SudokuBoard board);

    public UUID addBoard(SudokuBoard board);

    public void updateBoard(int[][] board, UUID uuid) throws SudokuUIIDNotFoundException;

    public SudokuBoard getWithId(UUID uuid);

    public ImmutableList<SudokuBoard> getAll();
}

package Model.Persistence;

import Model.Sudoku.SudokuBoard;
import com.google.common.collect.ImmutableList;

import java.util.UUID;

public interface CacheView {

    public void addBoard(SudokuBoard board);

    public SudokuBoard getWithId(UUID uuid);

    public ImmutableList<SudokuBoard> getAll();
}

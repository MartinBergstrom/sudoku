package Model.Persistence;

import Model.Sudoku.SudokuBoard;
import com.google.common.collect.ImmutableList;

import java.nio.file.Path;
import java.util.UUID;

public class FilePersistenceImpl implements PersistenceView {
    private final Path BASE_PATH;

    public FilePersistenceImpl(Path basePath) {
        BASE_PATH = basePath;
    }

    @Override
    public boolean boardExists(SudokuBoard board) {
        return false;
    }

    @Override
    public UUID addBoard(SudokuBoard board) {
        return null;
    }

    @Override
    public void updateBoard(int[][] board, UUID uuid) throws SudokuUIIDNotFoundException {

    }

    @Override
    public SudokuBoard getWithId(UUID uuid) {
        return null;
    }

    @Override
    public ImmutableList<SudokuBoard> getAll() {
        return null;
    }
}

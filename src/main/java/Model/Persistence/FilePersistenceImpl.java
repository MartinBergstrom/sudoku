package Model.Persistence;

import Model.Sudoku.SudokuBoard;
import com.google.common.collect.ImmutableList;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class FilePersistenceImpl implements PersistenceView {
    private final Path basePath = Paths.get(System.getProperty("user.dir"), "seralized");

    public FilePersistenceImpl() {
        basePath.toFile().mkdirs();
    }

    public FilePersistenceImpl(Path additionalPath){
        basePath.resolve(additionalPath);
        basePath.toFile().mkdirs();
    }

    @Override
    public boolean boardExists(SudokuBoard board) {
        return false;
    }

    @Override
    public UUID addBoard(SudokuBoard board) {
        UUID boardId = board.getID();
        String idPath = basePath.resolve(boardId.toString() + ".ser").toString();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(idPath))) {
            objectOutputStream.writeObject(board);
            return board.getID();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateBoard(int[][] board, UUID uuid) throws SudokuUIIDNotFoundException {

    }

    @Override
    public SudokuBoard getWithId(UUID uuid) {
        String idPath = basePath.resolve(uuid.toString() + ".ser").toString();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(idPath))) {
            SudokuBoard board = (SudokuBoard) objectInputStream.readObject();
            return board;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ImmutableList<SudokuBoard> getAll() {
        return null;
    }

    public Path getBasePath() {
        return Paths.get(basePath.toUri());
    }
}

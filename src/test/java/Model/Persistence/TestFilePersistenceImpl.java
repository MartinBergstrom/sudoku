package Model.Persistence;

import Model.Sudoku.SudokuBoard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.UUID;

import static org.junit.Assert.*;

public class TestFilePersistenceImpl
{
    private FilePersistenceImpl filePersistence;
    private UUID testID;

    private final int[][] sudokuExample = new int[][]{
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

    @Before
    public void setUp() throws Exception {
        filePersistence = new FilePersistenceImpl();
    }

    @After
    public void tearDown() throws Exception {
        Files.deleteIfExists(filePersistence.getBasePath().resolve(testID + ".ser"));
    }

    @Test
    public void shouldSerializeAndDeserializeToFile() {
        final UUID id = UUID.fromString("1ce1bad9-ce38-4989-b05f-3f3b0077e511");
        testID = id;
        // Serialize
        SudokuBoard addedBoard = new SudokuBoard(sudokuExample, id);
        UUID addBoardUUID = filePersistence.addBoard(addedBoard);
        assertNotNull(id);
        assertEquals(addBoardUUID, id);
        File serializedFile = new File(filePersistence.getBasePath().toString());
        assertTrue(serializedFile.exists());

        // Deserialize
        SudokuBoard board = filePersistence.getWithId(id);
        assertNotNull(board);
        assertEquals(board.getID(), id);
    }
}

package Model.Persistence;

public class SudokuUIIDNotFoundException extends Exception {
    public SudokuUIIDNotFoundException() {
        super("Could not find any sudokuBoard with that ID");
    }
}

package Model.Sudoku;

public class GeneratorFactory {
    private static Generator fileGenerator = new SudokuFromFileGenerator();
    private static Generator defaultGenerator = new SudokuGenerator();

    public enum GeneratorType {
        FILE_GENERATOR,
        DEFAULT_GENERATOR
    }

    public Generator getGenerator(GeneratorType type) {
        switch (type){
            case FILE_GENERATOR:
                return fileGenerator;
            case DEFAULT_GENERATOR:
                return defaultGenerator;
        }
        return null;
    }
}

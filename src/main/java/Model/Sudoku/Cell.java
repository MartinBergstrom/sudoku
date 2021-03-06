package Model.Sudoku;


import jersey.repackaged.com.google.common.collect.ImmutableSet;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Cell implements Serializable {
    private static final long serialVersionUID = 1L;

    private Optional<Integer> cellNumber;
    private final Set<Integer> allowedNumbers;

    public Cell(int number) {
        allowedNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        if (!allowedNumbers.contains(number)) {
            cellNumber = Optional.empty();
        } else {
            cellNumber = Optional.ofNullable(number);
        }
    }

    public Optional<Integer> getCellNumber() {
        return cellNumber;
    }


    @Override
    public String toString() {
        return cellNumber.isPresent() ? String.valueOf(cellNumber.get()) : " ";
    }

    private Object writeReplace() throws ObjectStreamException {
        return new CellSerialized(this);
    }
}

final class CellSerialized implements Serializable{
    private final Integer value;

    public CellSerialized(Cell cell) {
        this.value = cell.getCellNumber().orElse(null);
    }

    private Object readResolve() throws ObjectStreamException {
        int newValue = value == null ? -1 : value;
        return new Cell(newValue);
    }
}


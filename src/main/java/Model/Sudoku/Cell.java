package Model.Sudoku;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Cell{
    private Optional<Integer> cellNumber;
    private final Set<Integer> allowedNumbers;

    public Cell(int number){
        allowedNumbers = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9));

        if(!allowedNumbers.contains(number)){
            cellNumber = Optional.empty();
        }else{
            cellNumber = Optional.ofNullable(number);
        }
    }

    public Optional<Integer> getCellNumber(){
        return cellNumber;
    }

    @Override
    public String toString() {
        return cellNumber.isPresent()? String.valueOf(cellNumber.get()) : " ";
    }
}

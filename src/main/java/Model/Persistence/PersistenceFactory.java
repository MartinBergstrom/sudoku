package Model.Persistence;

public class PersistenceFactory {

    public static DataBaseInMemoryView getDefaultPersistenceImpl(){
        return DataBaseInMemory.getInstance();
    }

}

package Model.Persistence;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PersistenceFactory {

    private PersistenceFactory() {

    }

    /**
     *
     * @param identifier memory, file
     *
     * @return
     */
    public static PersistenceView getPersistenceImpl(String identifier){
        switch (identifier){
            case "memory" :
                return DataBaseInMemory.getInstance();
            case "file":
                Path path = Paths.get(System.getProperty("user.dir"))
                        .resolve("database")
                        .resolve("file");
                return new FilePersistenceImpl(path);
            default:
                return DataBaseInMemory.getInstance();
        }
    }
}

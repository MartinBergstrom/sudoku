package Model.Persistence;

public class PersistenceFactory {

    public static CacheView getDefaultPersistenceImpl(){
        return Cache.getInstance();
    }

}

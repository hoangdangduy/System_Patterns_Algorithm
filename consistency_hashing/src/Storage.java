import java.util.Map;

public class Storage {
    private String name;
    private Map<String, String> dataStore;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getDataStore() {
        return dataStore;
    }

    public void setDataStore(Map<String, String> dataStore) {
        this.dataStore = dataStore;
    }

    public Storage(String name, Map<String, String> storage) {
        this.name = name;
        this.dataStore = storage;
    }
}

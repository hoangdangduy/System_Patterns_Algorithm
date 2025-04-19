import java.math.BigInteger;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistencyHashing {

    private ConsistencyHashing() {
        // Prevent instantiation
    }

    private static final TreeMap<BigInteger,Storage> mapConsistencyHashing = new TreeMap<>();
    private static final int VIRTUAL_NODE = 2;

    public static SortedMap<BigInteger, Storage> getMapConsistencyHashing() {
        return mapConsistencyHashing;
    }

    public static void addServer(Storage storage) {
        for(int i = 0; i < VIRTUAL_NODE; i++) {
            var hash = HashingStrategy.generateHash(storage.getName().concat("-").concat(String.valueOf(i)));
            mapConsistencyHashing.put(hash, storage);
        }
    }

    public static void saveData(String key, String data) {
        getNode(key).getDataStore().put(key, data);
    }

    public static Storage getNode(String key) {
        var hash = HashingStrategy.generateHash(key);
        var result = mapConsistencyHashing.tailMap(hash);
        if (result.isEmpty()) {
            var map = mapConsistencyHashing.headMap(hash);
            var firstKey = map.firstKey();
            return map.get(firstKey);
        }
        var firstKey = result.firstKey();
        return result.get(firstKey);
    }

    public static String getData(String key) {
        return getNode(key).getDataStore().get(key);
    }

}

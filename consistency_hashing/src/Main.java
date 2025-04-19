import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final int NUM_TASK = 15;

    public static void main(String[] args) {
        ConsistencyHashing.addServer(new Storage("server-1", new ConcurrentHashMap<>()));
        ConsistencyHashing.addServer(new Storage("server-2", new ConcurrentHashMap<>()));
        ConsistencyHashing.addServer(new Storage("server-3", new ConcurrentHashMap<>()));

        IntStream.range(0, NUM_TASK).forEach(value -> {
            int randomValue = ThreadLocalRandom.current().nextInt(0, Integer.MAX_VALUE);
            var key = "key_" + value + "_" + randomValue;
            ConsistencyHashing.saveData(key, String.valueOf(randomValue));
        });

        ConsistencyHashing.getMapConsistencyHashing().values().stream()
                .collect(Collectors.toMap(Storage::getName, storage -> storage.getDataStore().size(), (o, o2) -> o))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println("Server: " + entry.getKey() + " total size: " + entry.getValue()));
    }
}
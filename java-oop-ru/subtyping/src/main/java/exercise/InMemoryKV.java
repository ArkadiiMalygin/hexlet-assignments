package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private Map<String, String> keys;

    public InMemoryKV(Map<String, String> keys) {
        this.keys = new HashMap<>(keys);
    }

    @Override
    public String get(String key, String defaultValue) {
        if (keys.containsKey(key)) {
            return keys.get(key);
        }
        return defaultValue;
    }

    @Override
    public void set(String key, String value) {
        keys.put(key, value);
    }

    @Override
    public void unset(String key) {
        keys.remove(key);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(keys);
    }
}
// END

package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage vault) {
        var keysValue = vault.toMap();
        var keys = keysValue.keySet();
        for (var key : keys) {
            var temp = vault.get(key, "");
            vault.unset(key);
            vault.set(temp, key);
        }
    }
}
// END

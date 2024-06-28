package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> homes, int count) {
        if (homes.isEmpty()) {
            return new ArrayList<String>();
        }
        var sortedHomes = new ArrayList<>(homes);
        sortedHomes.sort(Home::compareTo);
        var result = new ArrayList<String>();
        for (var i = 0; i < count; i++) {
            result.add(sortedHomes.get(i).toString());
        }
        return result;
    }
}
// END

package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        MaxThread maxThread = new MaxThread(numbers);
        MinThread minThread = new MinThread(numbers);
        maxThread.start();
        minThread.start();
        try {
            minThread.join();
            maxThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        var res = new HashMap<String, Integer>();
        res.put("min", minThread.getMin());
        res.put("max", maxThread.getMax());
        return res;
    }
    // END
}

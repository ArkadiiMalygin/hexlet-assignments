package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    @SneakyThrows
    public static void save(Path path, Car car) throws IOException {
        var objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(String.valueOf(path)), car);
    }

    @SneakyThrows
    public static Car extract(Path path) throws IOException {
        var objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(String.valueOf(path)), Car.class);
    }
}
// END

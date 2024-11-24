package exercise;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String path1, String path2, String pathRes) {
        CompletableFuture<String> path1Future = CompletableFuture.supplyAsync(() -> {
            String file1;
            try {
                file1 = Files.readString(Path.of(path1));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return file1;
        }).exceptionally(e -> {
            System.out.println("oops - " + e);
            return null;
        });

        CompletableFuture<String> path2Future = CompletableFuture.supplyAsync(() -> {
            String file2;
            try {
                file2 = Files.readString(Path.of(path2));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return file2;
        }).exceptionally(e -> {
            System.out.println("oops - " + e);
            return null;
        });

        CompletableFuture<String> pathResFuture = path1Future.thenCombine(path2Future, (str1, str2) -> {
            try {
                Files.writeString(Path.of(pathRes), str1 + str2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return str1 + str2;
        }).exceptionally(e -> {
            System.out.println("oops - " + e);
            return null;
        });
        return pathResFuture;
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        CompletableFuture<String> res = App.unionFiles("src/main/resources/file1.txt"
                ,"src/main/resources/file2.txt"
                ,"src/main/resources/file3.txt");
        // END
    }
}


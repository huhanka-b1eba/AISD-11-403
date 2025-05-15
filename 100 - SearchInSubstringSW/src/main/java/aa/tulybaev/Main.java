package aa.tulybaev;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        SearchInSubstring searchInSubstring = new SearchInSubstring();
        String projectPath = "src/main/java/aa/tulybaev/";

        // Реальный случай

        BufferedWriter writerReal = Files.newBufferedWriter(Paths.get(projectPath, "resultsReal.csv"), StandardCharsets.UTF_8);

        writerReal.write("№,strLength,substrLength,durationNanosec,iterations,isFound");
        writerReal.newLine();

        for (int i = 1; i <= 100; i++) {
            Path path = Paths.get(projectPath + "/files/", String.valueOf(i) + ".txt");
            String[] strings = Files.readString(path).split(" ");

            long startTime = System.nanoTime();
            SearchInSubstring.SearchResult result = searchInSubstring.searchKMP(strings[0], strings[1]);
            long stopTime = System.nanoTime();

            int strLength = strings[0].length();
            int substrLength = strings[1].length();
            long durationMs = (stopTime - startTime);

            writerReal.write(i + "," + strLength + "," + substrLength + "," + durationMs + "," + result.getIterations() + "," + result.isFound());
            writerReal.newLine();
        }
        writerReal.close();

    }



}
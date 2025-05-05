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
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(projectPath, "results.csv"), StandardCharsets.UTF_8);


        for (int i = 1; i <= 100; i++) {
            Random random = new Random();
            int strLength = 100 + random.nextInt(9901);
            String str = StringGenerator.generateRandomString(strLength);

            int substrLength = 5 + random.nextInt(strLength / 10);
            String substr = StringGenerator.generateRandomString(substrLength);

            // Чтобы были хоть какие то метчи
            if (i % 5 == 0) {
                int start = random.nextInt(strLength);
                int finish = start + random.nextInt(strLength - start);
                substr = str.substring(start, finish);
            }

            FileGenerator.generateFile("" + i, str, substr);
        }

        writer.write("№,strLength,substrLength,durationMs,iterations,isFound");
        writer.newLine();

        for (int i = 1; i <= 100; i++) {
            Path path = Paths.get(projectPath + "/files/", String.valueOf(i) + ".txt");
            String[] strings = Files.readString(path).split(" ");

            long startTime = System.nanoTime();
            SearchInSubstring.SearchResult result = searchInSubstring.searchKMP(strings[0], strings[1]);
            long stopTime = System.nanoTime();

            int strLength = strings[0].length();
            int substrLength = strings[1].length();
            long durationMs = (stopTime - startTime);

            writer.write(i + "," + strLength + "," + substrLength + "," + durationMs + "," + result.getIterations() + "," + result.isFound());
            writer.newLine();
        }
        writer.close();
    }
}
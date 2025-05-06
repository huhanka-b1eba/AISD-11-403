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
        for (int i = 1; i <= 100; i++) {
            Random random = new Random();
            int strLength = 100 + random.nextInt(9901);
            String str = StringGenerator.generateRandomString(strLength);

            int substrLength = random.nextInt(strLength);
            String substr = StringGenerator.generateRandomString(substrLength);

            // Чтобы были данные, где есть совпадения
            if (i % 5 == 0) {
                int start = random.nextInt(strLength);
                int finish = Math.min(start + substrLength, strLength);
                substr = str.substring(start, finish);
            }

            FileGenerator.generateFile("" + i, str, substr);
        }

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

        // Средний случай
        BufferedWriter writerNormal = Files.newBufferedWriter(Paths.get(projectPath, "resultsNormal.csv"), StandardCharsets.UTF_8);
        for (int i = 1; i <= 100; i++) {
            Random random = new Random();
            int strLength = 100 + random.nextInt(9901);
            String str = StringGenerator.generateRandomString(strLength);

            int substrLength = 5;
            String substr = StringGenerator.generateRandomString(substrLength);

            // Чтобы были данные, где есть совпадения
            if (i % 5 == 0) {
                int start = random.nextInt(strLength);
                int finish = start + 5;
                substr = str.substring(start, finish);
            }

            FileGenerator.generateFile("" + i, str, substr);
        }

        writerNormal.write("№,strLength,substrLength,durationNanosec,iterations,isFound");
        writerNormal.newLine();

        for (int i = 1; i <= 100; i++) {
            Path path = Paths.get(projectPath + "/files/", String.valueOf(i) + ".txt");
            String[] strings = Files.readString(path).split(" ");

            long startTime = System.nanoTime();
            SearchInSubstring.SearchResult result = searchInSubstring.searchKMP(strings[0], strings[1]);
            long stopTime = System.nanoTime();

            int strLength = strings[0].length();
            int substrLength = strings[1].length();
            long durationMs = (stopTime - startTime);

            writerNormal.write(i + "," + strLength + "," + substrLength + "," + durationMs + "," + result.getIterations() + "," + result.isFound());
            writerNormal.newLine();
        }
        writerNormal.close();


        // Лучший случай
        BufferedWriter writerBest = Files.newBufferedWriter(Paths.get(projectPath, "resultsBest.csv"), StandardCharsets.UTF_8);

        for (int i = 101; i <= 200; i++) {
            Random random = new Random();
            int strLength = 100 + random.nextInt(9901);
            String str = StringGenerator.generateWithOneLetterString(strLength, 'a');

            String substr = StringGenerator.generateWithOneLetterString(1, 'b');
            FileGenerator.generateFile("" + i, str, substr);
        }


        writerBest.write("№,strLength,substrLength,durationNanosec,iterations,isFound");
        writerBest.newLine();

        for (int i = 101; i <= 200; i++) {
            Path path = Paths.get(projectPath + "/files/", String.valueOf(i) + ".txt");
            String[] strings = Files.readString(path).split(" ");

            long startTime = System.nanoTime();
            SearchInSubstring.SearchResult result = searchInSubstring.searchKMP(strings[0], strings[1]);
            long stopTime = System.nanoTime();

            int strLength = strings[0].length();
            int substrLength = strings[1].length();
            long durationMs = (stopTime - startTime);

            writerBest.write(i + "," + strLength + "," + substrLength + "," + durationMs + "," + result.getIterations() + "," + result.isFound());
            writerBest.newLine();
        }
        writerBest.close();


        // Худший случай

        BufferedWriter writerBad = Files.newBufferedWriter(Paths.get(projectPath, "resultsBad.csv"), StandardCharsets.UTF_8);
        for (int i = 201; i <= 300; i++) {
            Random random = new Random();
            int strLength = 100 + random.nextInt(9901);
            String str = StringGenerator.generateRandomString(strLength);

            String substr = str.substring(0, strLength-1);
            substr += '_';
            FileGenerator.generateFile("" + i, str, substr);
        }

        writerBad.write("№,strLength,substrLength,durationNanosec,iterations,isFound");
        writerBad.newLine();

        for (int i = 201; i <= 300; i++) {
            Path path = Paths.get(projectPath + "/files/", String.valueOf(i) + ".txt");
            String[] strings = Files.readString(path).split(" ");

            long startTime = System.nanoTime();
            SearchInSubstring.SearchResult result = searchInSubstring.searchKMP(strings[0], strings[1]);
            long stopTime = System.nanoTime();

            int strLength = strings[0].length();
            int substrLength = strings[1].length();
            long durationMs = (stopTime - startTime);

            writerBad.write(i + "," + strLength + "," + substrLength + "," + durationMs + "," + result.getIterations() + "," + result.isFound());
            writerBad.newLine();
        }
        writerBad.close();

    }



}
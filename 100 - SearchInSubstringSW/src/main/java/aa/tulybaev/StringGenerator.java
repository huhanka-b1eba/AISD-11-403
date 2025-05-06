package aa.tulybaev;

import java.util.Random;

public class StringGenerator {
    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append((char) ('a' + random.nextInt(26)));
        }

        return sb.toString();
    }

    public static String generateWithOneLetterString(int length, char letter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(letter);
        }

        return sb.toString();
    }
}

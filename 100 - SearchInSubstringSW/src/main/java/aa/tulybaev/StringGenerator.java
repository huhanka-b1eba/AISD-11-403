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
}

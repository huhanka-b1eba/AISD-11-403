package aa.tulybaev;

import java.util.Arrays;

public class SearchInSubstring {

    public static class SearchResult {
        public final boolean found;
        public final int iterations;

        public SearchResult(boolean found, int iterations) {
            this.found = found;
            this.iterations = iterations;
        }

        public boolean isFound() {
            return found;
        }

        public int getIterations() {
            return iterations;
        }
    }

    // Наивный способ нахождения подстроки - Прямой поиск
    public static boolean badSearchInSubstring(String str, String substr) {
        if (substr.isEmpty()) return true;

        // Идем по строке, если есть несовпадение - сдвигаемся на 1 шаг
        for (int i = 0; i <= str.length() - substr.length(); i++) {
            boolean flag = true;
            for (int j = 0; j < substr.length() && flag; j++) {
                if (str.charAt(i+j) != substr.charAt(j)) flag = false;
            }
            if (flag) return true;
        }
        return false;
    }

    // Алгоритм Кнута-Морриса-Пратта
    public static SearchResult searchKMP(String str, String substr) {
        if (substr.isEmpty()) return new SearchResult(true, 0);

        // Этап 1. Формирование массива сдвига
        int[] pi = new int[substr.length()];
        pi[0] = 0;
        int j = 0;
        int comparisons = 0;

        for (int i = 1; i < substr.length(); i++) {
            while (j > 0 && substr.charAt(i) != substr.charAt(j)) {
                j = pi[j - 1];
                comparisons++;
            }
            if (substr.charAt(i) == substr.charAt(j)) {
                j++;
            }
            pi[i] = j;
            comparisons++;
        }

        // Этап 2. Поиск образа в строке
        int l = 0;

        for (int k = 0; k < str.length(); k++) {
            while (l > 0 && str.charAt(k) != substr.charAt(l)) {
                l = pi[l-1];
                comparisons++;
            }
            if (str.charAt(k) == substr.charAt(l)) {
                l++;
            }
            comparisons++;
            if (l == substr.length()) {
                return new SearchResult(true, comparisons);
            }
        }

        return new SearchResult(false, comparisons);
    }

}

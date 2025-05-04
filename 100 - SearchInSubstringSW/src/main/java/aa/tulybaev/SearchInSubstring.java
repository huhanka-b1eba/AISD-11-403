package aa.tulybaev;

import java.util.Arrays;

public class SearchInSubstring {

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
    public static boolean searchKMP(String str, String substr) {
        if (substr.isEmpty()) return true;

        // Этап 1. Формирование массива сдвига
        int[] pi = new int[substr.length()];
        pi[0] = 0;
        int j = 0;

        for (int i = 1; i < substr.length(); i++) {
            while (j > 0 && substr.charAt(i) != substr.charAt(j)) {
                j = pi[j - 1];
            }
            if (substr.charAt(i) == substr.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }

        // Этап 2. Поиск образа в строке
        int l = 0;

        for (int k = 0; k < str.length(); k++) {
            while (l > 0 && str.charAt(k) != substr.charAt(l)) {
                l = pi[l-1];
            }
            if (str.charAt(k) == substr.charAt(l)) {
                l++;
            }
            if (l == substr.length()) {
                return true;
            }
        }

        return false;
    }

}

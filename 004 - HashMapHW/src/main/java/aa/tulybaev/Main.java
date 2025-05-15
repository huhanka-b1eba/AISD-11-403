package aa.tulybaev;


// Напишите функцию, которая принимает на вход текст и возвращает количество вхождений каждого слова (с учетом окончаний. Т.е. "яблоко" и "яблока" -- это два разных слова ). Сложность -- O(n)

// Дан массив целых чисел и число k. Определить, есть ли в массиве такие два различных индекса i и j, что nums[i] == nums[j] и |i - j| <= k
//Пример:
//[1, 2, 3, 1, 5], k = 3
//Вывод: true (индекс 0 и 3, расстояние 3)


// Задача 3
//Даны два массива целых чисел. Вернуть массив их общих элементов, где количество вхождений каждого элемента равно минимальному из его встречаемости в обоих массивах
//Пример:
//[2, 4, 4, 1], [2, 2, 4, 5]
//Вывод:
//[2, 4]

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(toSetArrays(new int[]{1, 2, 2, 3, 4}, new int[]{2, 2, 2, 3, 4})));
    }

    public static HashMap<String, Integer> toCountWords(String word) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String letter : word.split(" ")) {
            if (map.get(letter) == null) {
                map.put(letter, 1);
            } else {
                map.put(letter, map.get(letter) + 1);
            }
        }

        return map;
    }

    public static boolean toCheckDegree(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue;
                if (Math.abs(arr[i] - arr[j]) == k) return true;
            }
        }
        return false;
    }

    public static int[] toSetArrays(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            if (map1.get(arr1[i]) == null) map1.put(arr1[i], 1);
            else  map1.put(arr1[i], map1.get(arr1[i]) + 1);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (map2.get(arr2[i]) == null) map2.put(arr2[i], 1);
            else map2.put(arr2[i], map2.get(arr2[i]) + 1);
        }

        Set<Integer> unicKeys = map1.keySet();
        for (Integer key : unicKeys) {
            if (map2.containsKey(key)) {
                for (int j = 0; j < Math.min(map1.get(key), map2.get(key)); j++) {
                    list.add(key);
                }
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
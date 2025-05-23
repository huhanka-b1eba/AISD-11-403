package aa.tulybaev;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Task 1
        int[] arr1 = {5, 4, 3, 2, 1, 2, 3, 4, 5};
        System.out.println(findIndex(arr1));

        int[] arr2 = {10, 8, 6, 5, 4, 3, 2, 1, 3, 5, 7};
        System.out.println(findIndex(arr2));

        // Task 2
        toOver("the sky is blue");

        // Task 3
        System.out.println(maxInt(new String[]{"3", "30", "34", "5", "9"}));

        // Task 4
        System.out.println(maxElemInList(new int[]{15, 5, 11, 10, 12}, 30));
    }

    // Task 1
    public static int findIndex(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid+1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // Task 2
    public static void toOver(String str) {
        int j = str.length();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                System.out.print(str.substring(i+1, j) + " ");
                j = i;
            }
        }

        System.out.println(str.substring(0, j));
    }

    // Task 3
    public static int maxInt(String arr[]) {
        String returnNumber = "";

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o2+o1) - Integer.parseInt(o1 + o2);
            }
        });

        for (int i = 0; i < arr.length; i++) {
            returnNumber += arr[i];
        }

        return Integer.parseInt(returnNumber);
    }

    // Task 4

    public static int maxElemInList(int[] arr, int s) {
        int sum = 0;
        int counter = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length && (sum < s); i++) {
            sum += arr[i];
            if (sum < s) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }


}
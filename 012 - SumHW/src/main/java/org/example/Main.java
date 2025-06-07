package org.example;

// Дан массив из n элементов и число t. Найти три различных числа из массива, которые в сумме ближе всего к t. Гарантируется, что такая тройка единственна. Сложность линейная.


import java.util.Arrays;

public class Main {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        int closestSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;

        int[] resultTriplet = new int[3];

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                int currentDiff = Math.abs(currentSum - target);

                if (currentDiff == 0) {
                    System.out.println("Тройка: " + nums[i] + ", " + nums[left] + ", " + nums[right]);
                    return currentSum;
                }

                if (currentDiff < minDiff) {
                    minDiff = currentDiff;
                    closestSum = currentSum;
                    resultTriplet[0] = nums[i];
                    resultTriplet[1] = nums[left];
                    resultTriplet[2] = nums[right];
                }

                if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println("Ближайшая тройка: " + resultTriplet[0] + ", " + resultTriplet[1] + ", " + resultTriplet[2]);
        return closestSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        int result = threeSumClosest(nums, target);
        System.out.println("Ближайшая сумма к " + target + ": " + result);
    }
}
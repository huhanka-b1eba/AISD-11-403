package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] area = new int[10][10];
        area[0] = new int[]{51, 21, 93, 48, 45, 100, 67, 39, 18, 29};
        area[1] = new int[]{57,	43,	97,	51,	92,	10,	93,	32,	19,	58};
        area[2] = new int[]{63, 16, 31, 16, 78, 88, 90, 72, 37, 67};
        area[3] = new int[]{10, 57, 64, 25, 96, 50, 81, 65, 91, 69};
        area[4] = new int[]{99, 43, 95, 7, 40, 76, 18, 34, 5, 65};
        area[5] = new int[]{35, 19, 71, 77, 64, 38, 62, 56, 10, 2};
        area[6] = new int[]{100, 57, 27, 26, 51, 33, 100, 11, 53, 1};
        area[7] = new int[]{11, 79, 49, 46, 37, 69, 80, 31, 25, 39};
        area[8] = new int[]{22, 71, 20, 23, 11, 12, 39, 16, 64, 34};
        area[9] = new int[]{4, 25, 87, 84, 30, 48, 77, 13, 40, 33};


        int[][] newArea = new int[10][10];
        newArea[0][0] = area[0][0];
        for (int i = 1; i < area.length; i++) {
            newArea[0][i] = newArea[0][i-1] + area[0][i];
        }
        for (int i = 1; i < area[0].length; i++) {
            newArea[i][0] = newArea[i-1][0] + area[i][0];
        }

        for (int i = 1; i < area.length; i++) {
            for (int j = 1; j < area.length; j++) {
                newArea[i][j] = area[i][j] + Math.min(newArea[i-1][j], newArea[i][j-1]);
            }
        }

        System.out.println("Ответ: " + newArea[area.length - 1][area[0].length - 1]);

        for (int i = 0; i < area.length; i++) {
            System.out.println(Arrays.toString(newArea[i]));
        }
    }
}
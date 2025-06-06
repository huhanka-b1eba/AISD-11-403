package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(lasNumInFibonacci(10));
        System.out.println(pashWays(2, 5));
    }

//    public static boolean fibonachiCheck(int n) {
//        ArrayList<Integer> arrFibonachi = new ArrayList<>();
//        arrFibonachi.add(1);
//        arrFibonachi.add(1);
//        for (int i = 2; i < n; i++) {
//            arrFibonachi.add(arrFibonachi.get(i - 1) + arrFibonachi.get(i - 2));
//        }
//        System.out.println(arrFibonachi);
//        for (int i = 0; i < arrFibonachi.size(); i++) {
//            if (arrFibonachi.get(i) == n) return true;
//        }
//        return false;
//    }

    public static int lasNumInFibonacci(int n) {
        ArrayList<Integer> arrFibonachi = new ArrayList<>();
        arrFibonachi.add(1);
        arrFibonachi.add(1);
        for (int i = 2; i < n; i++) {
            arrFibonachi.add(arrFibonachi.get(i - 1) + arrFibonachi.get(i - 2));
        }

        return (arrFibonachi.get(arrFibonachi.size() - 1) % 10);
    }


    public static int pashWays(int k, int n) {
        int[] arrWay = new int[n];
        arrWay[0] = 1;
        System.out.println(Arrays.toString(arrWay));
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < k && (i+j < n); j++) {
                arrWay[i+j] += arrWay[i];
            }
            System.out.println(Arrays.toString(arrWay));
        }
        return arrWay[n - 1];
    }

    
}
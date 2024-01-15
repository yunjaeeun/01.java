package com.ohgiraffers.section01.array;

import java.util.Arrays;
import java.util.Scanner;

public class baek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] sum1 = new int[10];

        for (int i = 0; i < sum1.length; i++) {
            sum1[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(sum1));

//        System.out.println(sum1 % 42);
    }
}

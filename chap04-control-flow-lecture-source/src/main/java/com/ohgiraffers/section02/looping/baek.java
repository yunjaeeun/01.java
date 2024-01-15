package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class baek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        for (int i = 1; i <= input; i++) {
            int sum1 = sc.nextInt();
            int sum2 = sc.nextInt();
            System.out.println("Case #" + i + ": " + sum1 + " + " + sum2 + " = " + (sum1 + sum2) );
        }
    }
}

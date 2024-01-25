package com.ohgiraffers.section03.filterstream;

import java.io.*;

public class Application2 {
    public static void main(String[] args) {

        // Scanner sc = new Scanner(System.in)과 같음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       // System.in : 콘솔로부터 입력을 받음

        System.out.print("문자열 입력: ");
        try {
            String value = br.readLine();

            System.out.println("value: " + value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        BufferedWriter bw = null;
        OutputStreamWriter osw = null;
        osw = new OutputStreamWriter(System.out);
        bw = new BufferedWriter(osw);

        try {
            bw.write("println이 좋은거구만!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
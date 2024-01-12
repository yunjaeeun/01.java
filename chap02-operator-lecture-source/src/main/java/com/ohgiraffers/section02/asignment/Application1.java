package com.ohgiraffers.section02.asignment;

public class Application1 {

    public static void main(String[] args) {

        /* 수업목표. 대입연산자와 산술 복합 대입 연산자를 이해하고 활용할 수 있다. */
        /* 필기.
         *  대입연산자와 산술 복합 대입 연산자
         *  '=': 왼쪽의 피연산자에 오른쪽의 피연산자를 대입함
         *  '+=': 왼쪽의 피연산자에 오른쪽의 피연산자를 더한 결과를 왼쪽의 피연산자에 대입합
         *  '-=': 왼쪽의 피연산자에 오른쪽의 피연산자를 뺀 결과를 왼쪽의 피연산자에 대입함
         *  '*=': 왼쪽의 피연산자에 오른쪽의 피연산자를 곱한 결과를 왼쪽의 피연산자에 대입함
         *  '/=': 왼쪽의 피연산자에 오른쪽의 피연산자를 나눈 결과를 왼쪽의 피연산자에 대입함
         *  '%=': 왼쪽의 피연산자에 오른쪽의 피연산자를 나누고 나머지 결과를 왼쪽의 피연산자에 대입함
        * */

        int num = 12;

        System.out.println("num = " + num);

        num = num + 3;
        System.out.println("num = " + num);
        
        num += 3;
        System.out.println("num = " + num);
        
        num -= 5;
        System.out.println("num = " + num);
        
        num *= 2;
        System.out.println("num = " + num);
        
        num /= 2;
        System.out.println("num = " + num);
        
        num %= 10;
        System.out.println("num = " + num);

        /* 주의사항 */
        num =- 5;           // equal(=) 기호가 오른쪽에 와야 복합 대입 연산자가 된다.
        System.out.println("num = " + num);
    }
}

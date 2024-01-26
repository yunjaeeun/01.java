package com.ohgiraffers.section01.intro;

public class Application1 {

    public static void main(String[] args) {

        /* 수업목표. 람다식에 대해 이해하고 활용할 수 있다.(feat.FunctionalInterface) */

        /* 필기. 1. 인터페이스를 구현한 구현체(Impl 클래스)를 이용한 방식(동적 바인딩 활용) */
        Calculator c1 = new CalculatorImpl();
        System.out.println("10과 20의 합은: " + c1.sumTwoNumber(10, 20));       // 실행 시점에 동적 바인딩이 일어남.

        /* 필기. 2. 익명클래스를 활용한 방식(인터페이스의 하위 구현체) */
        Calculator c2 = new Calculator() {          // 한번만 사용하고 버릴 즉흥적인 클래스
            @Override
            public int sumTwoNumber(int num1, int num2) {
                return (num1 + num2) * 2;
            }
        };
        System.out.println("10과 20의 합에 2를 곱하면: " + c2.sumTwoNumber(10, 20));

        /* 필기. 3. 람다식을 활용한 방식 */
//        Calculator c3 = (x, y) -> { return (x + y) * 3;};
        Calculator c3 = (x, y) -> (x + y) * 3;                  // 위와 같음
        System.out.println("10과 20의 합에 3을 곱하면? " + c3.sumTwoNumber(10, 20));
    }
}

package com.ohgiraffers.section02.looping;

public class Application {
    public static void main(String[] args) {
        A_for aClass = new A_for();

        /* 수업목표. for문 단독 사용에 대한 흐름을 이해하고 적용할 수 있다. */
//        aClass.testSimpleForStatement();

        /* 필기. 반복문을 사용하는 예제(반복문 필요성) */
//        aClass.testForExample1();
//        aClass.testForExample2();

        /* 수업목표. 중첩된 for문의 흐름을 이해하고 적용할 수 있다.  */
        B_nestedFor bClass = new B_nestedFor();

        /* 필기. 중첩 반복문을 사용하는 예제 */
//        bClass.printGugudanFromTwoToNine();
//        bClass.printUpgradeGugudanFromTwoToNine();

        /* 필기. 중첩 반복문을 활용한 별 찍기 관련 예제 */
//        bClass.printStars();

        C_While cClass = new C_While();

        /* 필기. 단독 while문 흐름 확인용 메소드 호출 */
//        cClass.testSimpleWhileStatement();

        /* 필기. while문 사용하는 예제 */
//        cClass.testWhileExample();

        D_doWhile dClass = new D_doWhile();

        /* 필기. 단독 do-while문 흐름 확인용 메소드 호출  */
//        dClass.testSimpleDoWhileStatement();

        /* 필기. do-while문 사용하는 예제 */
        dClass.testDoWhileExample();
    }

}



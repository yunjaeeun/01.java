package com.ohgiraffers.section02.userException;


import com.ohgiraffers.section02.userException.exception.MoneyNegativeException;
import com.ohgiraffers.section02.userException.exception.NotEnoughMoneyException;
import com.ohgiraffers.section02.userException.exception.PriceNegativeExcption;

public class Application1 {
    public static void main(String[] args) {

        /* 수업목표. 사용자 정의의 예외클래스 정의 후 발생한 사용자 정의의 예외를 처리할 수 있다. */
        ExceptionTest et = new ExceptionTest();

        try {
//            et.checkEnoughMoney(-30000, 50000);
//            et.checkEnoughMoney(30000, -50000);
//            et.checkEnoughMoney(50000, 30000);
            et.checkEnoughMoney(30000, 50000);
        } //catch (Exception e) {}    // 다형성에 의해서 상위 클래스인 Exception에서 혼자 처리가 가능하지만 제일 앞으로 오면 안됨.
//        catch (PriceNegativeExcption e) {
//            System.out.println(e.getMessage());
//        } catch (NotEnoughMoneyException e) {
//            System.out.println(e.getMessage());
//        } catch (MoneyNegativeException e) {
//            System.out.println(e.getMessage());
//        }
        catch (Exception e) {               // 다형성을 활용한 catch 처리 방식
            System.out.println("예외 메시지: " + e.getMessage());
        }
    }
}

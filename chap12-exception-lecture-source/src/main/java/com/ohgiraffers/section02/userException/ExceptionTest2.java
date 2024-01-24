package com.ohgiraffers.section02.userException;

import com.ohgiraffers.section02.userException.exception.MoneyNegativeException;
import com.ohgiraffers.section02.userException.exception.NotEnoughMoneyException;
import com.ohgiraffers.section02.userException.exception.PriceNegativeExcption;

public class ExceptionTest2 {
    public void checkEnoughMoney(int price, int money) throws PriceNegativeExcption, MoneyNegativeException, NotEnoughMoneyException {

        /* 설명. throw를 통한 예외 발생 시 바로 메소드를 호출한 곳으로 예외 인스턴스와 함께 반환된다. */
        if (price < 0) {
            throw new PriceNegativeExcption("상품 가격은 음수일 수 없습니다.");
        }

        if(money < 0){
            throw new MoneyNegativeException("가지고 있는 돈은 음수일 수 없습니다.");
        }

        if(money < price) {
            throw new NotEnoughMoneyException("가진 돈 보다 상품 가격이 더 비쌉니다.");
        }

        /* 설명. throw를 통해 if문이 실행되면 호출한곳으로 바로 반환되기 때문에 else를 작성하지 않아도 됨. */
        System.out.println("가진 돈이 충분하시군요 고객님! 즐거운 쇼핑 되세요!");
    }
}

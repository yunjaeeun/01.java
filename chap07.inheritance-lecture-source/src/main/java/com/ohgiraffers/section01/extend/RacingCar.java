package com.ohgiraffers.section01.extend;

public class RacingCar extends Car{
    @Override
    public void run() {
//        super.run();        // this.은 큰 객체의 주소를 뜻하고 super.은 부모의 주소를 뜻함
        System.out.println("레이싱 자동차가 신나게 달립니다. 쌔애애앵!~");
    }

    @Override
    public void soundHorn() {
        System.out.println("레이싱카는 경적따위 울리지 않습니다.");
    }
}

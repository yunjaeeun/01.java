package com.ohgiraffers.section03.abstraction;

public class carRacer {

    /* 설명. 차 한대(Car 객체 하나)를 필드로 가진다. */
    private car myCar = new car();

    /* 설명. 자신이 보유한 차량에 시동을 건다. */
    public void startUp() {
        this.myCar.startUP();
    }

    public void stepAccelator() {
        this.myCar.go();
    }

    public void steepBreak() {
        this.myCar.stop();
    }

    public void turnOff() {
        this.myCar.turnOff();
    }
}

package com.ohgiraffers.section02.extend.vo;

public class RabbitFarm <T extends Rabbit>{     // <T extends Rabbit> : Rabbit이거나 Rabbit의 자손 타입만 가능
    private T aniaml;

    public RabbitFarm() {
    }

    public RabbitFarm(T aniaml) {
        this.aniaml = aniaml;
    }

    public T getAniaml() {
        return aniaml;
    }

    public void setAniaml(T aniaml) {
        this.aniaml = aniaml;
    }
}

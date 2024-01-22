package com.ohgiraffers.section02.extend.run;

import com.ohgiraffers.section02.extend.vo.*;

public class Application2 {
    public static void main(String[] args) {

    /* 수업목표. 와일드카드에 대해 이해할 수 있다. */
        wildCardFarm wildCardFarm1 = new wildCardFarm();
        wildCardFarm1.anyType(new RabbitFarm<Rabbit>());
        wildCardFarm1.anyType(new RabbitFarm<Bunny>());
        wildCardFarm1.anyType(new RabbitFarm<DrunkenBunny>());

//                wildCardFarm1.extendsType(new RabbitFarm<Rabbit>());
        wildCardFarm1.extendsType(new RabbitFarm<Bunny>());
//        wildCardFarm1.extendsType(new RabbitFarm<DrunkenBunny>());

        wildCardFarm1.superType(new RabbitFarm<Rabbit>());
        wildCardFarm1.superType(new RabbitFarm<Bunny>());
//        wildCardFarm1.superType(new RabbitFarm<DrunkenBunny>());


    }
}

package com.ohgiraffers.section04.constructor;

import java.util.Date;

public class Application {
    public static void main(String[] args) {

        /* 수업목표. 생성자 함수가 무엇인지 이해하고 선언 및 호출할 수 있다. */
        User user1 = new User("user01", "pass01", "피카츄", new Date());
        System.out.println(user1.forInformation());

        User user2 = new User("user01", "pass01", "피카츄", new java.util.Date());
    }
}

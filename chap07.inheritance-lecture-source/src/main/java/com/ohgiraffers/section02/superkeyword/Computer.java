package com.ohgiraffers.section02.superkeyword;

import java.util.Date;

public class Computer extends Product {
    private String cpu;
    private int ssd;
    private int ram;
    private String operationSystem;

    public Computer() {
        super();
        System.out.println("Computer 클래스의 기본 생성자 호출함...");
    }

    public Computer(String cpu, int ssd, int ram, String operationSystem) {
//        super();                    따로 적지 않아도 자식 객체에는 무조건 적어져 있음
        this.cpu = cpu;
        this.ssd = ssd;
        this.ram = ram;
        this.operationSystem = operationSystem;
        System.out.println("Computer 클래스의 모든 필드를 초기화하는 생성자 호출함...");
    }

    public Computer(String code, String brand, String name, int price, Date menufactureingDate, String cpu, int ssd, int ram, String operationSystem) {
        super(code, brand, name, price, menufactureingDate);
        this.cpu = cpu;
        this.ssd = ssd;
        this.ram = ram;
        this.operationSystem = operationSystem;
        System.out.println("Computer 클래스의 부모 필드까지 모두 초기화하는 생성자 호출함...");
    }

//    @Override
//    public String toString() {
//        return "Computer{" +
//                "cpu='" + cpu + '\'' +
//                ", ssd=" + ssd +
//                ", ram=" + ram +
//                ", operationSystem='" + operationSystem + '\'' +
//                "} " +
//                super.toString();
//    }
}

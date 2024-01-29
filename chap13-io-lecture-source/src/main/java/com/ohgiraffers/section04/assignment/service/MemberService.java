package com.ohgiraffers.section04.assignment.service;

import com.ohgiraffers.section04.assignment.aggregate.BloodType;
import com.ohgiraffers.section04.assignment.aggregate.MBTI;
import com.ohgiraffers.section04.assignment.aggregate.Member;
import com.ohgiraffers.section04.assignment.repository.MemberRepository;

import java.util.ArrayList;
import java.util.Scanner;

/* 설명. 트랜잭션 성공실패 여부 확인 및 회원 관련 비즈니스 로직 처리하는 클래스 */
public class MemberService {

    private final MemberRepository mr = new MemberRepository();
    Scanner sc = new Scanner(System.in);

    public MemberService() {
    }

    public void selectAllMembers() {
        ArrayList<Member> selectedMembers = mr.selectAllMembers();

        /* 설명. 회원이 한명도 없어서 조회 결과가 없더라도 ArrayList객체는 넘어온다.(Empty상태로) */
        if(!selectedMembers.isEmpty()) {        // 회원이 한명이라도 조회 된다면
            System.out.println("==== service까지 잘 반환되어 오나 확인 ====");
            for(Member m: selectedMembers) {
                System.out.println(m);
            }

            return;                             // 이후 코드와 상관 없이 메소드 종료
        }

        /* 설명. 조건이 맞지 않아(회원이 조회되지 않아) 출력을 하는 구문(위의 조건이 맞으면 실행되지 않음)(feat.else 안 쓰기) */
        System.out.println("슬프게도 우리 싸이트는 아직 회원이 없습니다.");
    }

    /* 설명. 전달된 회원 번호를 활용해 repository에 있는 memberList로부터 해당 회원 찾아 반환 받기 */
    public void selectMember(int memNo) {
        Member selectedMember = mr.selectMember(memNo);

        if(selectedMember == null) {
            System.out.println("그런 회원이 없네요!~");
        } else {
            System.out.println("조회된 회원은: " + selectedMember);
        }
    }

    /* 설명. 입력받아 넘어온 회원이 가질 번호를 만들고 추가 후 repository로 전달 후 결과 확인 */
    public void registMember(Member member) {
//        System.out.println("사용자가 입력해서 넘겨준 Member 확인: " + member);

        int lastMemberNo = mr.selectLastMemberNo();
        member.setMemNo(lastMemberNo + 1);

        int result = mr.registMember(member);
        if(result == 1) {
            System.out.println(member.getId() + "님의 회원 가입이 성공하였습니다.");
        }
    }

    public void deleteMember(int memNo) {
        int result = mr.deleteMember(memNo);
        if(result > 0) {
            System.out.println(memNo + "번 회원 탈퇴를 성공하였습니다.");
            return;
        }

        System.out.println("회원 탈퇴에 실패하였습니다.");
    }

    public String checkID() {
        System.out.print("아이디를 입력하세요: ");
        String id = sc.nextLine();
        return id;
    }

    public MBTI checkMBTI() {
        while (true) {
            System.out.print("MBTI를 입력하세요: ");
            String mbti = sc.nextLine().toUpperCase();
            MBTI mt = null;
            switch(mbti) {
                case "ISTJ" : mt = MBTI.ISTJ; return mt;
                case "ISTP" : mt = MBTI.ISTP; return mt;
                case "ISFJ" : mt = MBTI.ISFJ; return mt;
                case "ISFP" : mt = MBTI.ISFP; return mt;
                case "INTJ" : mt = MBTI.INTJ; return mt;
                case "INTP" : mt = MBTI.INTP; return mt;
                case "INFJ" : mt = MBTI.INFJ; return mt;
                case "INFP" : mt = MBTI.INFP; return mt;
                case "ESTJ" : mt = MBTI.ESTJ; return mt;
                case "ESTP" : mt = MBTI.ESTP; return mt;
                case "ESFJ" : mt = MBTI.ESFJ; return mt;
                case "ESFP" : mt = MBTI.ESFP; return mt;
                case "ENTJ" : mt = MBTI.ENTJ; return mt;
                case "ENTP" : mt = MBTI.ENTP; return mt;
                case "ENFJ" : mt = MBTI.ENFJ; return mt;
                case "ENFP" : mt = MBTI.ENFP; return mt;
                default: System.out.println("다시 입력해 주세요");
            }
        }
    }
    public BloodType checkBT() {
        while (true) {
            System.out.print("혈액형을 입력하세요(A, AB, B, O): ");
            String bloodType = sc.nextLine().toUpperCase();
            BloodType bt = null;
            switch(bloodType) {
                case "A": bt = BloodType.A; return bt;
                case "AB": bt = BloodType.AB; return bt;
                case "B": bt = BloodType.B; return bt;
                case "O": bt = BloodType.O; return bt;
            }
        }
    }
}







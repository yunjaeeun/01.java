package com.ohgiraffers.section08.uses;

public class MemberFinder {

	/* 설명. 회원을 잘 조회하는 클래스 */
	public Member[] findAllMembers() {
		
		return MemberRepository.findAllMembers();
	}
}

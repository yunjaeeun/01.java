package com.ohgiraffers.section04.assignment.stream;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutput extends ObjectOutputStream {
    public MyObjectOutput(OutputStream out) throws IOException {
        super(out);
    }


    /* 설명. 객체 출력시 헤더 추가 관련 기능이 없도록 재정의 */
    @Override
    protected void writeStreamHeader() throws IOException {
        // 부모 클래스에 가면 내용이 있지만 헤더 추가가 되지 않도록 비워놓음
    }
}

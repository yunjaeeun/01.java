package com.ohgiraffers.section03.filterstream;

import java.io.*;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. 데이터타입 입출력 보조스트림을 이해하고 활용할 수 있다.(Reader 또는 Writer 계열 X) */
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(
                    new FileOutputStream("src/main/java/com/ohgiraffers/section03/filterstream/testData.txt"));

            dos.writeUTF("홍길동");            // 자료형별로 보내면 사람의 눈으로 해석이 안되므로 InputStream으로 해석 해야함.
            dos.writeInt(20);
            dos.writeChar('A');

            dos.writeUTF("유관순");
            dos.writeInt(16);
            dos.writeChar('B');

            dos.writeUTF("강감찬");
            dos.writeInt(46);
            dos.writeChar('C');

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (dos != null) dos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        DataInputStream dis = null;
        try {
            dis = new DataInputStream(
                    new FileInputStream("src/main/java/com/ohgiraffers/section03/filterstream/testData.txt"));
            while (true) {
                System.out.println(dis.readUTF());                      // 자료형을 넣은 순서대로 출력하지 않으면 이상한 결과가 출력됨.
                System.out.println(dis.readInt());
                System.out.println(dis.readChar());
            }
        } catch (EOFException e) {          // 파일을 다 읽어내면 EOFException 예외가 발생하므로 이를 이용하여 구문을 작성하면 break를 작성 할 필요가 없음.
            System.out.println("파일 다 읽어냄");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (dis != null) dis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

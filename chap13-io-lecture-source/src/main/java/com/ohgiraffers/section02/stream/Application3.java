package com.ohgiraffers.section02.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. FileOutputStream에 대해 이해하고 활용할 수 있다. */
        FileOutputStream fout = null;

        try {
            fout = new FileOutputStream("src/main/java/com/ohgiraffers/section02/stream/testOutputStream.txt");     // 출력스트림은 해당 위치에 파일이 없으면 만듦.
//            fout.write('a');
//            fout.write(97);

            byte[] bArr = new byte[]{'a', 'p', 'p', 'l', 'e'};
//            for(byte b: bArr) {               // apple 라는 문자가 들어감.
//                fout.write(b);
//            }

//            fout.write(bArr);                 // apple 라는 문자가 들어감.

            fout.write(bArr, 1, 3);     // ppl 라는 문자가 들어감.

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(fout != null) fout.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

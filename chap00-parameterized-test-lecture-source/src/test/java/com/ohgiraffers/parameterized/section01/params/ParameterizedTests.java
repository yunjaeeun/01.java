package com.ohgiraffers.parameterized.section01.params;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.*;

import java.lang.annotation.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.stream.Stream;

public class ParameterizedTests {

    /* 목차. 1. @ValueSource를 이용한 parameter value 목록 지정 */
    /* 설명. @ValueSource를 이용하여 한 개의 파라미터로 전달할 값들의 목록을 지정할 수 있다. */
    /* 설명. 가능한 자료형으로는 short, int, long, float, double, char, java.lang패키지 클래스들(String 포함) */
    @DisplayName("홀수 짝수 판별 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, -1, 15, 123})                // @ValueSource -> 기본 자료형으로 배열을 만들어서 테스트 메소드의 매개변수로 넘어가게 한다(파라미터의 갯수만큼 반복을 돌려줌)
    void testIsOdd(int number) {

        //when
        boolean result = NumberValidator.isOdd(number);

        //then
        Assertions.assertTrue(result);
    }

    /* 목차. 2. @NullSource와 @EmptySource */
    @DisplayName("null값 테스트")
    @ParameterizedTest
    @NullSource                                              // @NullSource -> 따로 추가하지 않아도 Null 값을 매개변수로 넘어가게 해줌
    void testIsNull(String input) {

        //when
        boolean result = StringValidator.isNull(input);

        //then
        Assertions.assertTrue(result);
    }

    @DisplayName("empty값 테스트")
    @ParameterizedTest
    @EmptySource                                            // @EmptySource -> 따로 추가하지 않아도 비어있는 값을 매개변수로 넘어가게 해줌
    void testIsEmpty(String input) {

        //when
        boolean result = StringValidator.isEmpty(input);

        //then
        Assertions.assertTrue(result);
    }

    @DisplayName("blank값 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void testIsBlank(String input) {

        //when
        boolean result = StringValidator.isBlank(input);

        //then
        Assertions.assertTrue(result);
    }

    /* 목차. 3. 열거형을 이용한 @EnumSource 활용하기 */
    /* 설명. Enum의 필드 갯수만큼 각각 파라미터로 넣어주며 테스트 메소드 동작시킴 */
    @DisplayName("Month에 정의된 타입들이 1~12월 사이의 범위인지 테스트")
    @ParameterizedTest
    @EnumSource(Month.class)
    void testMonthValueIsCollect(Month month) {

        //when
        boolean result = DateValidator.isCollect(month);

        //then
        Assertions.assertTrue(result);
    }

    @DisplayName("4월, 6월, 9월, 11월이 30일인지 확인")
    @ParameterizedTest
    @EnumSource(value = Month.class, names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
    void testHasThirtyDaysLong(Month month) {

        //given
        int verifyValue = 30;

        //when
        int actual = DateValidator.getLastDayOf(month);

        //then
        Assertions.assertEquals(verifyValue, actual);
    }

    @DisplayName("2월, 4월, 6월, 9월, 11월을 제외한 달이 31일인지 확인")
    @ParameterizedTest
    @EnumSource(
            value = Month.class,
            names = {"FEBRUARY", "APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"},
            mode = EnumSource.Mode.EXCLUDE
    )
    void testHasThityOneDaysLong(Month month) {

        //given
        int verifyValue = 31;

        //when
        int actual = DateValidator.getLastDayOf(month);

        //then
        Assertions.assertEquals(verifyValue, actual);
    }

    /* 목차. 4. @CsvSource를 이용한 CSV 리터럴 */
    @DisplayName("영문자를 대문자로 변경하는지 확인")
    @ParameterizedTest
//    @CsvSource({"test,TEST", "tEst,TEST", "JavaScript, JAVASCRIPT"})
    @CsvSource(                                         // Csv -> 키와 밸류의 개념을 가진 파일, @CsvSource -> 구분자를 기분으로 파라미터에 각각 넣어주는 기능
            value = {"test:TEST", "tEst:TEST", "JavaScript: JAVASCRIPT"},
            delimiter = ':'
    )
    void testToUpperCase(String input, String verifyValue) {

        System.out.println("input = " + input);
        System.out.println("verifyValue = " + verifyValue);

        //when
        String actual = input.toUpperCase();

        //then
        Assertions.assertEquals(verifyValue, actual);
    }

    @DisplayName("CSV 파일을 읽은 테스트 데이터를 테스트에 활용하는지 확인")
    @ParameterizedTest
    @CsvFileSource(resources = "/parameter-test-data.csv", numLinesToSkip = 1)
    void testToUpperCaseWithCSVFileData(String input, String verifyValue) {

        //when
        String actual = input.toUpperCase();

        //then
        Assertions.assertEquals(verifyValue, actual);
    }

    /* 목차. 5. @MethodSource를 활용한 메소드 인수 활용하기 */
    /* 필기. Stream을 반환하는 메소드를 만들어서 이를 테스트에 활용할 수 있다. */

    private static Stream<Arguments> providerStringSource() {

        return Stream.of(
                Arguments.of("hello world", "HELLO WORLD"),
                Arguments.of("JavaScript", "JAVASCRIPT"),
                Arguments.of("tEsT", "TEST")
        );
    }

    @DisplayName("메소드 소스를 활용한 대문자 변환 테스트")
    @ParameterizedTest
    @MethodSource("providerStringSource")               // @MethodSource를 통해 미리 Arguments를 만들어 놓고 메소드를 호출해 파라미터에 넣어줄 수 있음
//    @MethodSourceStringSource
    void testToUpperCaseWithMethodSource(String input, String verifyValue) {

        //when
        String actual = input.toUpperCase();

        //then
        Assertions.assertEquals(verifyValue, actual);
    }

    /* 설명. 어노테이션을 만들었기 때문에 메소드명을 일일히 작성하지 않아도 된다. */
//    @Documented
//    @Target(ElementType.METHOD)
//    @Retention(RetentionPolicy.RUNTIME)
//    @MethodSource("providerStringSource")
//    private @interface MethodSourceStringSource {}

    /* 목차. 6. ArgumentsProvider를 이용한 메소드 소스 사용 */
    @DisplayName("두 수를 더한 결과를 정상적으로 반환하는지 테스트")
    @ParameterizedTest(name = "[{index}] {0} + {1} = {2} (이)가 맞는지 확인")
    @ArgumentsSource(SumTwoNumbersArgumentsProvider.class)              // Argument를 반환하는 메소드를 모아 클래스로 정의 후 불러올 수 있음.
    void testSumTwoNumbers(int num1, int num2, int verifyValue) {

        //when
        int actual = Calculator.sumTwoNumbers(num1, num2);

        //then
        Assertions.assertEquals(verifyValue, actual);
    }
}

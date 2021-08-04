package com.example.java8.lamdba;

/**
 * @FunctionalInterface
 *  : 람다는 인터페이스가 구현해야할 표현식으로 추상 메서드 1개를 가지고 있을때 지원
 *    (메서드가 2개 이상이라면 :: 지원하지 않음)
 *    -- @functionalInterface : 함수형 인터페이스 지원 이유
 *    : 추후에 인터페이스 수정할 일이 생겼을때 개수 제한하는 방법이 없으므로
 *      빌드시 추상메서드에 추가하는 일을 막기 위해서
 */

@java.lang.FunctionalInterface
public interface FunctionalInterface {
  void move(String behavior);
}

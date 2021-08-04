package com.example.java8.lamdba;

/**
 *   람다는 자바가 기존에 없던 함수형 프로그램밍을 받아드리기 위해 추가 되었다.
 *   함수형 프로그래밍은 새로운 패러다임을 가지고 있다.
 *   람다의 핵심은 지울수 있는건 모두 지우자!!!
 *   컴파일러의 추론에 의지하고 드를 간결하게 만드는 것이다.
 */

public interface Moveable {

  void move(String behavior);

  // 인터페이스 구현 클래스를 만들어 객체화
  // 재사용이 필요한 car 클래스 경우는 재사용을 위해 남겨둠.
  class Car implements Moveable {

    @Override
    public void move(String behavior) {
      System.out.println("gogo car move" + behavior);
    }
  }

  // 익명 클래스 객체를 구현
  // 재사용성이 없으니 람다 표현식으로 수정
  /**
   * Moveable moveable = new Moveable() {
   *     @Override
   *     public void move(String behavior) {
   *       System.out.println("gogo move " + behavior);
   *     }
   *   };
   *
   *  removable parts
   *  1) target type
   *  2) method name (as only one method)
   *  3) parameter type
   *
   *  Moveable moveable = (behavior -> {
   *     System.out.println("gogo move" + behavior);
   *   });
   *
   *   removable parts
   *   1) 1개의 실행문 괄호
   *   2) 인자 1개 괄호
   */

    Moveable moveable = behavior -> System.out.println("gogo move" + behavior);
}

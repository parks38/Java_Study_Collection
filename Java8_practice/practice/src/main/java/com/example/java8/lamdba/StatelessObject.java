package com.example.java8.lamdba;

/**
 *  클래스를 구현할때 클래스에는 매서드(행위)만 존재하라는 법은 없음.
 *  인스턴스 필드 (상태) 가 존재하는 클래스 존재 가능
 */
public interface StatelessObject {

  Moveable example = new Moveable() {
    private int speed;

    @Override
    public void move(String behavior) {
      System.out.println("gogogo move current speed:" + speed);
    }
  };
  /**
   *  익명 객체 생성시 인스턴스 필드를 추가 할 수 있으나
   *  람다를 이용하게 되면 인스턴스 필드 추가 방법은 없다.
   *  메서드와 함수의 가장 큰 차이점은 메서드는 객체에 종속되어 있다.
   *    - 객체에 종속적이기 때문에 input 이 달라지지 않아도 객체의 상태에 따라 결과값 변경 가능
   *  함수란 input 에 의해서 output 이 달라진다.
   *    # 함수형 프로그래밍에서 함수는 인풋에 의해서만 아웃풋이 달라져야 하기 때문에
   *      이를 지원하기 위해서 람다의 객체는 상태를 사질 수 없다.
   *      therefore, + stream && parallel programming
   */
}

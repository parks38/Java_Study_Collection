package com.example.java8.API_Practice;

/**
 *  Runnable : 인터페이스로 스레드 생성할 때 주로 사용
 *             void 타입의 인자 없는 메서드
 */
public class RunnableTest {

/*  static Runnable task1 = new Runnable() {
    @Override
    public void run() {
      System.out.println("task #1 is running");
    }
  };*/

  static Runnable task1 = () -> System.out.println("task #1 is running");

  public static void main(String[] args) {
    Thread thread1 = new Thread(task1);
    thread1.start();
  }
}

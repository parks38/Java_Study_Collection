package com.example.java8.API_Practice;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *  Supplier, Consumer, Function, Predicate 예시
 */
public class basicAPITest {

  public static void main (String[] args) {

    /**
     *  Supplier (공급자) : 인자는 받지 않으며 리턴 타입만 존재하는 메서드
     *  순수 함수에서 결과를 바꾸는건 오직 input 뿐이다.
     *  input이 없다는 것은 항상 같은 것을 리턴
     *
     *  Supplier<T>  { T get(); }
     */
    Supplier<String> supplier = () -> "Supplier";
    System.out.println(supplier.get()); //Supplier

    /**
     *  Consumer(소비자) : 인자를 받지만 리턴을 하지않고 (void) - 소모
     *
     *  Consumer<T> { void accept(T t); }
     */
    Consumer<String> consumer1 = text -> System.out.println("consumer1");
    Consumer<String> consumer2 = text -> System.out.println("consumer2 " + text);
    consumer1.andThen(consumer2).accept("new parameter");
    //consumer1
    //consumer2 new parameter

    /**
     *  Function<T, R> : 하나의 인자와 리턴타입을 가지며 제네릭으로 지정 가능.
     *   { R apply(T t); }
     */
    Function<Integer, Integer> multiply = (value) -> value * 2;
    System.out.println(multiply.apply(3)); //6

    // compose() 두개의 function 조합하여 새로운 메소드 생성 (andThen() 과 반대로 실행 순서)
    Function<Integer, Integer> add = (value) -> value + 3;

    Function<Integer, Integer> addThenMultiply = multiply.compose(add); // add 먼저
    System.out.println(addThenMultiply.apply(3)); // 12

    /**
     *  Predicate<T> : 하나의 인자와 리턴타입 가짐. (반환은 boolean)
     *   == Function<T, Boolean>
     *   { boolean test(T t); }
     */
    Predicate<Integer> isBiggerThanFive = num -> num > 5;
    System.out.println("predicate test: " + isBiggerThanFive.test(10));
    // predicate test: true
    Predicate<Integer> isLowerThanSeven = num -> num < 7;
    System.out.println("test (10) : " + isBiggerThanFive.and(isLowerThanSeven).test(10));
    // test (10) : false
  }
}

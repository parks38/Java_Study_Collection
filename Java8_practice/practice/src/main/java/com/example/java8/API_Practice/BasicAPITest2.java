package com.example.java8.API_Practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

/**
 * UnaryOperation, BinaryOperation, BiPredicate, BiConsumer, BiFunction, Comparator
 */
public class BasicAPITest2 {

  private static Object BiConsumer;

  public static void main(String[] args) {

    /**
     *  BiConsumer<T, U> : 서로 다른 타입의 2개의 인자 소모 (void)
     *    void accept(T t, U u);
     */
    BiConsumer<Integer, Integer> biConsumerAdd = (n1, n2) -> System.out.println(n1 + n2);
    biConsumerAdd.accept(10, 20); //30

    // Map.forEach() : 인자로 BiConsumer 받음
    Map<String, Integer> map = new HashMap<>();
    map.put("one", 1);
    map.put("two", 2);
    map.put("three", 3);

    BiConsumer<String, Integer> biConsumer1 = (key, value) -> System.out.println("key: " + key + " value:" + value);
    map.forEach(biConsumer1);
    //key: one value:1
    //key: two value:2
    //key: three value:3

    // andThen() 구현 가능
    BiConsumer<Integer, Integer> biConsumerMultiply = (n1, n2) -> System.out.println(n1 * n2); //30

    biConsumerAdd.andThen(biConsumerMultiply).accept(10,20); // 200
    /**
     *      andThen 구현
     *         BiConsumer<T, U> andThen(BiConsumer<? super T, ? super U> after) {
         *       Object.requireNonNull(after);
         *
         *       return (l, r) -> {
         *         accept(l, r);
         *         after.accept(l,r);
         *       }
         *     }
     */


    /**
     * BiPredicate<T, U> : 서로 다른 타입의 2개의 인자를 받아들여 boolean 타입으로 반환
     *  (return true || false)
     *   boolean test (T t, U u);
     */
    // test()
    BiPredicate<Integer, Integer> biPredicate = (n1, n2) -> n1 > n2;
    System.out.println(biPredicate.test(20, 30)); //false

    // and() : 연결(체이닝 메소드)
    BiPredicate<Integer, Integer> biPredicate2 = (n1, n2) -> n1 * n2 > 100;
    System.out.println(biPredicate.and(biPredicate2).test(11,10)); //true

    // or()
    System.out.println(biPredicate.or(biPredicate2).test(9, 10)); //false

    // negate() : NOT -> 리턴하는 값과 반대되는 값
    BiPredicate<Integer, Integer> biPredicateNegate = biPredicate.negate();

    System.out.println(biPredicate.test(10,9)); //true
    System.out.println(biPredicateNegate.test(10,9));//false

    /**
     *  UnaryOperator<T> : 하나의 인자와 리턴 타입을 가짐. 인자 타입 = 리턴타입
     *  public interface UnaryOperator<T> extends Function<T, T> {
     *      R apply(T t);
     */
    UnaryOperator<Integer> unaryOperator = n -> n * n;
    System.out.println(unaryOperator.apply(10)); // 100

    /**
     *  BinaryOperator<T, U> : 두개의 인자를 받고 동일한 객체를 리턴함.
     *  R apply(T t, U u);
     */
    BinaryOperator<Integer> binaryOperator = (n1, n2) -> n1 * n2;
    System.out.println("binary multiply: " + binaryOperator.apply(10,3));
    // binary multiply: 30

    // comparator 이용
/*    BinaryOperator<Item> binaryOperator1 = BinaryOperator.maxBy(
        (Item i1, Item i2) -> i1.getId() - i2.getId());

    Item item1 = new Item(10, "first");
    Item item2 = new Item(20, "second");

    Item max = binaryOperator1.apply(item1, item2);*/

    /** Comparator
     */
    Comparator<Integer> findMax =  (n1, n2) -> n1 - n2;
    System.out.println(findMax.compare(20,10)); // 10
  }
}

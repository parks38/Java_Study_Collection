package com.example.java8.lamdba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import lombok.Getter;

/**
 *  행위 파라미터화 (Behavior Parameterize)
 *  : 매개변수에 데이터를 전달하여 행위 메서드를 구현할 때 행위를 전달하면 더 유연한 코드가 됨.
 */

@Getter
class Fruit {

  private String name;
  private String color;

  Fruit(String name, String color) {
    this.name = name;
    this.color = color;
  }
  /**
   * Predicate<T>: 하나의 인자와 리턴 타입을 가짐.
   *   Function 과 비슷해 보이지만 리턴 타입이 boolean 고정
   *   Function<T, Boolean> 형태
   *
   * 주어진 조건에 맞는 fruitList 를 추출해 내는 공통 로직
   */

  List<Fruit> extractFruitList(List<Fruit> fruits, Predicate<Fruit> predicate) {
    List<Fruit> resultList = new ArrayList<>();
    for(Fruit fruit: fruits) {
      if(predicate.test(fruit)) {
        resultList.add(fruit);
      }
    }
    return resultList;
  }


  List<Fruit> fruits = Arrays.asList(new Fruit("apple", "red"), new Fruit("banana", "yellow"), new Fruit("melon", "green"));

  List<Fruit> appleList = extractFruitList(fruits, new Predicate<Fruit>() {
    @Override
    public boolean test(Fruit fruit) {
      return "apple".equals(fruit.getName());
    }
  });

  List<Fruit> redList = extractFruitList(fruits, new Predicate<Fruit>() {
    @Override
    public boolean test(Fruit fruit) {
      return "red".equals(fruit.getName());
    }
  });

  // Predicate 인터페이스 안에는 추상 메서드는 한개이다.
  // 람다 표현식으로 한번더 짧게 바꿀수 있다.
                                // 메소드 이름 (인자 , 인자 -> 실행문);
  List<Fruit> appleLambdaList = extractFruitList(fruits, fruit -> "apple".equals(fruit.getName()));
  List<Fruit> redLambdaList = extractFruitList(fruits, fruit -> "red".equals(fruit.getName()));

/* 위 코드를 풀이 :

   List<Fruit> extractApple(List<Fruit> fruits) {
    List<Fruit> resultList = new ArrayList<>();
    for(Fruit fruit : fruits) {
      if("apple".equals(fruit.getName())) {
        resultList.add(fruit);
      }
    }
    return resultList;
  }

  List<Fruit> extractRed(List<Fruit> fruits) {
    List<Fruit> resultList = new ArrayList<>();
    for(Fruit fruit : fruits) {
      if("red".equals(fruit.getColor())) {
        resultList.add(fruit);
      }
    }
    return resultList;
  }*/
}

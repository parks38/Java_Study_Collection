[참고]
https://kapentaz.github.io/java/spring/Enum-and-@RequestParam-in-Spring/#

<br>

[여러개 일 경우]

```
  @RequestMapping("/fruit")
  public String handleRequest(@RequestParam("name") Fruit fruit) {
      return "response for " + fruit;
  }

  @RequestMapping("/fruits")
  public String handleRequest2(@RequestParam("name") Fruit[] fruits) {
      return "response for " + Arrays.toString(fruits);
  }

  @RequestMapping("/fruitsCount")
  public String handleRequest3(@RequestParam MultiValueMap<String, Integer> queryMap) {
      String response = "";
      for (Map.Entry<String, List<Integer>> entry : queryMap.entrySet()) {
          Fruit f = null;
          try {
              f = Fruit.valueOf(entry.getKey());
          } catch (IllegalArgumentException e) {
              return "Not a valid fruit: " + entry.getKey();
          }
          List<Integer> value = entry.getValue();
          if (value.size() > 0) {
              response += f + "=" + value.get(0) + "<br/>";
          }
      }
      return response;
  }
  ```
<br> 
  https://www.logicbig.com/tutorials/spring-framework/spring-web-mvc/mapping-query-param-to-enum.html

  <br>

  Fruit[] frits = queryMap.key();
  switch (fruits) {
      case "sorted" : 
      case "name" : 
        service.sortName();
        break;
     case "sorted" : 
        service.sort();
        break;
  }
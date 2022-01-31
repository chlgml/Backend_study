## Stream



- Filtering

  필터는 스트림 내의 요소들을 하나씩 평가해서 걸러내는 작업이다.

  ```java
  Stream<T> filter(Fredicate<? super T> predicate);
  ------------------------------------------------------------------
  Stream<String> stream = 
      names.stream()
      	.filter(name -> name.contains("a"));
  ```

  스트림의 각 요소에 대해서 평가식을 실행, 'a'가 들어간 스트림 리턴



- Mapping

  맵은 스트림 내의 요소들을 하나씩 특정값으로 반환해줍니다.

  ```java
  <R>Stream<R> map(Function<? super T, ? extends R> mapper);
  ------------------------------------------------------------------
  Stream<String> stream = 
      names.stream()
      	.map(String::toUppercase);
  ```

  스트림 내의 String의 toUppercase메소드 실행해서 대문자로 변환한 값이 담긴 스트림 리턴

  
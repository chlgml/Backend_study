

래퍼 클래스(Wrapper class) : 기본타입의 데이터를 객체로 변환해 주는 클래스

java.lang 패키지에 포함되어 제공 

| 기본타입 | 래퍼클래스 |
| :------: | :--------: |
|   long   |    Long    |
|   int    |  Integer   |
|  float   |   Float    |
|  double  |   Double   |
|   char   | Character  |

여기서 long은 int보다 더 많은 범위를 가지고 있는 타입이다.



박싱(Boxing)과 언박싱(UnBoxing)

박싱 : 기본타입 =>래퍼클래스                언박싱 : 래퍼클래스  =>기본타입

```java
Integer num = new Integer(17); // 박싱
int n = num.intValue();        // 언박싱

Character ch = 'X'; //오토박싱
// Character ch = new Character('X'); 
char c = ch; //오토언박싱
// char c = ch.charValue();
```



**int 와 Integer**

|         | 산술연산                              | null                 |
| ------- | ------------------------------------- | -------------------- |
| int     | 산술연산 가능                         | null로 초기화 불가능 |
| Integer | 언박싱을 하지 않는 이상 산술연술 불가 | null값 처리 가능     |

둘의 가장 큰 다른점은 객체냐 아니냐 인것 같다. int를 객체로 사용해야 할 때 Integer로 사용함!!




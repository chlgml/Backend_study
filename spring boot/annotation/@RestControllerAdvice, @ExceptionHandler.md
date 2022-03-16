

```java
@RestControllerAdvice ---------------------------------------------------- (1)
public class ExceptionHandler {
    	// Handler를 설정할때는 빈으로 명시해주어야 Handler가 잘 작동한다.
    
    @ExceptionHandler(NullPointerException.class) ------------------------ (2)
    protected ResponseEntity<ErrorResponse> HandleNullPointerException(final NullPointerException e) {
        return new ResponseEntity<>(new ErrorResponse(400, e.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
```



## (1) @RestControllerAdvice

@RestConrtoller과 비슷하게  @RestControllerAdvice이 어노테이션도 @ControllerAdvice + @ResponseBody 어노테이션이다. 간단하게 설명하면 controller의 예외도 잡아주면서 객체를 리턴할 수 있는 어노테이션이다.

- 이 어노테이션은 controller(controller로 설정된 클래스)만 예외를 감지하기 때문에 다른 클래스에서는 에러를 감지 할 수 없다. 하지만 controller에서 다른 클래스를 호출한 경우 호출한 클래스의 예외 또한 controller의 예외로 생각하기에 예외처리가 가능하다.

- @ControllerAdvice

  controller 전역예외를 잡아주는 어노테이션이다. 예외 처리를 하고자 하는 클래스 위에 붙여준 후 @ExceptionHandler로 처리하고 싶은 예외를 잡아준다.

  

```java
@RestControllerAdvice("com.example.demo.패키지")
```

위와 같이 설정을 해준다면 예외를 패키지 단위로 제한할 수 있다.



## (2) @ExceptionHandler

```java
@ExceptionHandler(예외클래스.class)
```

**@ControllerAdvice** 이 명시된 클래스 내부 메소드에 사용한다. @ExceptionHandler사용은 위와 같은 방법으로 한다. 메소드위에 써 놓은면 controller에서 @ExceptionHandler에서 설정해놓은 예외가 발생하면 메소드를 수행한다.







>어노테이션을 정리하다가 많은 코드를 찾아보게 되었는데 그 코드중 참고했으면 좋을 부분이 있어서 적는다.
>
>ErrorResponse 필드에 예외를 세분화 하기 위해서 사용자 지정 코드를 적는 건데 글을 적은 분의 의도는 잘 모르겠지만, 내 방식대로 해석하자면, 같은 400에러라도 어디서 에러가 나느냐에 따라서 message가 달라진다. 그리고 message가 같아도 예외가 어디서 발생했냐에 따라 나눌 수 있다. 세분화 되어있는 에러를 코드(예시를 들어 C001등)로 지정하자는거다. 
>
>근데 계속 보다보니까 필요에 대해 의문이 들긴하지만, 협업할때 많은 예외를 지정하기 위해 사용해도 좋을 것 같다.


## @SpringBootApplication

@SpringBootApplication은 자동 설정을 해주는 어노테이션이다.

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration -------------------------------------- (1)
@EnableAutoConfiguration -------------------------------------- (2)
@ComponentScan(excludeFilters = { @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
		@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) }) --------- (3)
public @interface SpringBootApplication {
    ...
}
```

@SpringBootApplication의 내부를 들여다보면, 위와 같다. 차근차근 하나씩 파헤쳐보도록하자.

- @SpringBootApplication은 Baen을 2번 등록해준다. 처음에 @ComponentScan로 등록하고 그 후에 @EnableAutoConfiguration으로 추가적인 Baen을 등록해준다.



## (1) @SpringBootConfiguration

환경설정 파일임을 알려주는 어노테이션이다..! 스프링에서는 @Configuration 어노테이션으로도 @SpringBootConfiguration와 동일한 역할을 수행 할 수 있다. 그런데 왜 @SpringBootConfiguration사용하는 것일까? 

- SpringBoot만의 Configuration라는 의미를 주기 위함과 @SpringBootConfiguration는 한 서비스 내에서 2개 이상을 사용하지 못한다고 함!



### @Configuration

설정파일을 만들기 위한, Bean을 등록하기 위한 어노테이션이다. 또한 @Bean을 사용하는 클래스에는 반드시 @Configuration 어노테이션을 활용하여 해당 클래스가 Bean을 생성하고 있음을 명시한다. 그러므로 @Bean이 사용되는 클래스에는 @Configuration 어노테이션을 붙여주어야한다.

- 그래도 @Bean만 사용해도 Bean으로 등록이 된다. 하지만 메소드 호출을 통해 객체를 생성할 때 싱글톤을 보장하지 못한다. 그러므로 반드시 @Configuration 어노테이션을 적어야한다.

-  @Configuration 어노테이션도 내부적으로 @Component 어노테이션을 가지고 있어서 @Component의 클래스도 Bean으로 등록이 된다.

  

이제 중요한 건 아래 두개의 어노테이션이다!!



## (2) @EnableAutoConfiguration

@EnableAutoConfiguration은 스프링부트의  spring.factories 내부에 정의되어 있는 configuration 대상 클래스들을 빈으로 등록해준다. 이 대상 클래스들은 @Configuration 어노테이션이 없어도 자동으로 빈이 등록된다. 

개발자가 직접 클래스를 추가해놓으면 그 클래스 또한 빈으로 등록을 해준다.

- 하지만 항상 다 빈으로 등록한다면 엄청난 리소스가 낭비되기 때문에 프로젝트에 필요한 부부만 빈이 생성되도록 필터링 작업을 한다.



## (3) @ComponentScan

@ComponentScan은 스캔 위치를 설정하고, 어떤 어노테이션을 스캔할지 결정하는 필터 기능을 가지고 있는 어노테이션이다. 

스캔 위치를 설정하는 방법은 BasePackages와 BasePackageClasses가 있다. BasePackages는 페키지의 경로를 스캔하는 방법(이 방법은 TypeSafe하지 않아서 BasePackageClasses를 더 추천한다고 한다.)이고, BasePackageClasses는 전달된 클래스의 위치를 기준으로 스캔을 시작하는 방법이다.

- BasePackageClasses

  @ComponentScan이 붙어있는 Configuration부터 스캔을 시작한다.
  SpringBoot프로젝트에서는 @SpringBootApplication에 이미 @Configuration과 @ComponentScan이 붙어있기 때문에 @SpringBootApplication 기준으로 패키지 이하의 클래스만 스캔이 된다.

  하지만 패키지 밖에 있는 패키지 밖에있는 클래스들은 스캔이 되지 않는다.

- @ComponentScan은 다른 Bean을 등록하기 전에 컴포넌트 스캔을 해서 Bean을 등록해준다.

-  @Autowired와의 차이점

  @ComponentScan은 다른 Bean을 찾아 Bean을 등록해주는 과정이고, @Autowired는 등록된 다른 Bean을 찾아 의존성을 주입하는 역할을 한다.

- 다른 Bean이란?

  우리가 직접 등록하는 Bean을 가르킨다.

  - @Controller, @Service, @Bean 등



### @Component

@ComponentScan이 스캐닝을 하는 기준이 @Component이다. @Component가 붙어 있는 클래스는 스캐닝이 되며, Bean으로 등록된다. 

- 대표적인 컴포넌트
  - @Controller
  - @Repository
  - @Service
  - @Configuration

개발자가 직접개발한 클래스를 Bean으로 등록하고자하는 경우 @Component 어노테이션을 사용한다.  @Bean을 통해서도 Bean으로 등록 할 수 있지만, 직접 개발한 클래스 단위의 Bean을 등록할때는 @Component로 설정해 놓으면 해당 Bean이 잘 등록되어있는 지 잘 찾을 수 있다. 
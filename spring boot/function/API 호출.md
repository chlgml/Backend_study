## API 호출

REST API 호출 방법
-  RestTemplate
    -  Spring 3부터 지원, REST API 호출이후 응답을 받을 때까지 기다리는 동기 방식
-  AsyncRestTemplate
    -  Spring 4에 추가된 비동기 RestTemplate이다.
-  WebClient
    - Spring 5.0에 추가된 인터페이스이다. 리엑티브 웹 클라이언트로 동기, 비동기 방식을 지원한다.
    - WebClient가 나오기 전까지 비동기 처리는 AsyncRestTemplate를 통해서 했지만 WebClient가 나온 후 WebClient를 사용할 것을 권장한다고 한다.

RestTemplate와 WebClient
RestTemplate를 많이 사용했으나 RestTemplate은 deprecated 될 가능성이 있기 때문에 WebClient를 사용한다.
- deprecated : 명령 혹은 문장이 잘 쓰이지 않을 것, 다른 것으로 대체 될 수 있으니 주의해서 사용


### WebClient

의존성 추가
```java
implementation 'org.springframework.boot:spring-boot-starter-webflux'
```

(택배 API를 예시로 사용함.)
```java
@RequiredArgsConstructor
@Component
public class DeliveryUtil {

  
    @Value("${sweettracker.baseUrl}")
    private String baseUrl;

    @Value("${sweettracker.secretKey}")
    private String secretKey;
 
    public DeliveryDto getDelivery(String courierCompany, String waybillNumber) {

        WebClient webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .build();

        return webClient.get() // 요청하려는 API의 HTTP 메소드를 적어준다.
                .uri(uriBuilder ->  uriBuilder.path("/api/v1/trackingInfo")
                        .queryParam("t_key", secretKey) // 쿼리 내용을 보낼 수 있음
                        .queryParam("t_code", "0"+courierCompany)
                        .queryParam("t_invoice", waybillNumber).build())
                        // 요청할 API의 형식대로 적어준다.
                .accept(MediaType._APPLICATION_JSON) // JSON으로 값을 받아옴 
                .retrieve() // response를 받아옴
                .bodyToMono(DeliveryDto.class) // DeliveryDto 클래스 타입으로 가져옴.
                .block();
  
    }
}
```

#### response 받아오기
- exchange() : ClientResponse를 상태값을 헤더와 함께 가져옴
- retrieve() : body 내용을 가져옴



### OkHttpClient
RestAPI와 HTTP 통신을 간편하게 하기 위한 'Square'라는 회사가 만든 라이브러리이다.
- OkHttpClient는 오픈 소스이다.

의존성 추가
```java
implementation group: 'com.squareup.okhttp3', name: 'okhttp', version: '4.2.2'
```

```java
public void sendMessageTo(String targetToken, String title, String body) {  
    String message = makeMessage(targetToken, title, body);  
  
    OkHttpClient client = new OkHttpClient();  // OkHttpClient 객체 생성

	// RequestBody 생성
    RequestBody requestBody = RequestBody.create(message, MediaType.get("application/json; charset=utf-8"));
    
	// post 객체 생성
    Request request = new Request.Builder()  
            .url(API_URL)  
            .post(requestBody)  
            .addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + getAccessToken())  
            .addHeader(HttpHeaders.CONTENT_TYPE, "application/json; UTF-8")  
            .build();  

	// 요청 전송
    Response response = client.newCall(request).execute();  
  
}
```

그리고 요청 시에 .execute() 메소드를 꼭 호출에 주어야 한다.
만약, 비동기로 수행할 것이라면 .execute()이게 아니라 .enqueue() 메소드를 사용해야한다.

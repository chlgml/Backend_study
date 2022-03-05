## Key

| 키의 종류     | 설명                                                         |
| ------------- | ------------------------------------------------------------ |
| PK(기본키)    | 테이블을 식별할 수 있는 고유 키로, 테이블은 무조건 PK를 가지고 있다.<br /> 중복이나 NULL이 불가능하다. |
| FK(외래키)    | 테이블간의 관계를 의미한다. <br /> ex) 교실(1반)과 교실의 학생의 관계는 1:N이다. 이때 FK를 가지고 있는 테이블은 학생 테이블이다. |
| Composite Key | 두 가지 이상의 컬럼으로 이루어진 키                          |
| Natural Key   | 현실 세계의 속성으로 적용된 키<br /> ex) 이메일, 주민번호 등 |
| Surrogate Key | 비즈니스적이 의미가 없는키<br />ex) 정수형 식별자 등         |
| Candidate Key | PK가 될 수 있는 unique 한 키의 모음. Composite Key도 해당 될 수 있음. |
| Alternate Key | PK 대신 사용할 수 있는 레코드의 unique 키                    |



선배의 피드백 중 unique의 속성을 가진 이메일을 key로 설정하지 않고 따로 id를 PK 로 설정한 이유가 있냐는 질문을 받았다. 솔직히 생각해본적도 없었던 부분이기에 검색을 하던 중 여러 내용을 알게되었다.

때에 따라서 달라지겠지만 개인정보인 이메일을 식별자로 사용하도록 노출하고 싶지 않을 수도 있다. 그래서 Surrogate Key를 사용하는 것이 좋은 방법일 수 있다. 반대로 노출을 하고 싶다면 이메일을 식별자로 사용하면 된다.

그리고 email을 pk로 설정하면 저장공간을 줄일 수 있다는 장점이 있지만, email은 소실될 수 있는 정보이며, 비지니스의 요구사항의 영향을 받을 수 있다는 단점이 있다.
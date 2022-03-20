## Config

프로젝트 설정 파일이다.



## Detail

- **UserDetails**
  Spring security에서 사용자의 정보를 담는 인터페이스

  | 메소드                    | 설명                                                     |
  | ------------------------- | -------------------------------------------------------- |
  | getAuthorities()          | 계정의 권한 목록을 리턴                                  |
  | getPassword()             | 계정의 비밀번호를 리턴                                   |
  | getUsername()             | 계정 고유 값 리턴 <br /> ex) BD PK값, 중복 없는 이메일값 |
  | isAccountNonExpired()     | 계정의 만료 여부 리턴                                    |
  | isAccountNonLocked()      | 계정의 잠김 여부 리턴                                    |
  | isCredentialsNonExpired() | 비밀번호 만료여부 리턴                                   |
  | isEnabled()               | 계정 활성화여부                                          |

- **UserDetailsService** 
  Spring Security에서 유저의 정보를 가져오는 인터페이스

  | 메소드             | 설명                                      |
  | ------------------ | ----------------------------------------- |
  | loadUserByUsername | 유저의 정보를 불러와서 UserDetails로 리턴 |



## Util

Util클래스는 중복 코드를 줄여주는 코드로 보통은 static클래스로 만들어 사용한다.

보통 보안, 문자열 처리, 날짜 처리 등 특정 비지니스 로직과 독립적인 기능들을 Util 클래스로 만들어 사용한다. 

특정 개념과 독립적인 기능 + 다른 부분과의 의존성이 없고 input parameter만 갖고 단순한 처리만 하는 메소드들은 특히 정적 메소드로 많이 구성하며, 빈을 주입하지 않는다.

- Utility는 운영체계젱서 제공되는 것 이외의 기능을 제공하는 작은 프로그램을 의미한다.



## Filter

자바 서블릿에서 제공하는 기능으로 필터는 주로 요청에 대한 인증, 권한 체크등을 하는 데 쓰인다.

Filter 인터페이스는 3가지 메소드를 가지고 있다.

- init() : 필터가 생성될 때 수행되는 메소드
- doFilter() :  Request, Response가 필터를 거칠 때 수행되는 메소드
- destroy() : 필터가 소멸될 때 수행도는 메소드

필터 클래스를 만들려면 필터를 빈으로 등록해야 한다.
필터를 거치지 않는(토큰X) 구간은 Config에서 접근 설정을 해주면 된다.
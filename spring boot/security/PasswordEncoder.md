## PasswordEncoder



SecurityConfig

```java
@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    } // PasswordEncoder을 생성해주기!

}
```



Service

```java
@RequiredArgsConstructor
@Service
public class Service {

    private final PasswordEncoder passwordEncoder;
    // PasswordEncoder 불러오기
    private final Repository Repository;

    public void seve(Dto dto) {

        Entity entity = Entity.builder()
                .name(dto.getName())
                .password(passwordEncoder.encode(dto.getPassword()))
                // 비밀번호를 암호화
                .build();

        Repository.save(entity);

    }

    public void vrfct(Dto dto) {

        Entity Entity = Repository.findByName(dto.getName())
                .orElseThrow(NotFoundException::new);

        if(!passwordEncoder.matches(dto.getPassword(), Entity.getPassword())) {
            // matches(비교할 비밀번호, db에 저장되어 있는 비밀번호)
            throw new NotFoundException();
        }

    }

}
```






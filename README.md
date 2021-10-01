# 🌏 Bon Voyage

> 꼭 가보고 싶은 여행지가 있나요? Bon Voyage에 기록해두세요!

![](https://user-images.githubusercontent.com/80450262/134696774-13b2f76f-a4fd-4176-96d0-07690a4c8581.png)

## <a name="toc">📕 목차</a>

1. [기술 스택](#1)
2. [핵심 기능](#2)
3. [트러블 슈팅](#3)
4. [프로젝트를 통해 배운 것](#4)

<br/>

## [🔝](#toc)<a name="1">1. 기술 스택</a>

- Front-end
  <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"><img src="https://img.shields.io/badge/css3-1572B6?style=for-the-badge&logo=css3&logoColor=white"><img src="https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white"><img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white"><img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=white">

- Back-end

  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"><img src="https://img.shields.io/badge/spring boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"><img src="https://img.shields.io/badge/spring security-6DB33F?style=for-the-badge&logo=spring&logoColor=white"><img src="https://img.shields.io/badge/spring data jpa-6DB33F?style=for-the-badge&logo=spring&logoColor=white">

  <img src="https://img.shields.io/badge/mariadb-003545?style=for-the-badge&logo=mariadb&logoColor=white"><img src="https://img.shields.io/badge/aws-FF9900?style=for-the-badge&logo=amazonaws&logoColor=white">

<br/>

## [🔝](#toc)<a name="2">2. 핵심 기능</a>

### 2-1. 메인 페이지에 조회수 가장 높은 4개 게시물 노출

![](src/main/resources/static/docs/2-1.gif)

게시판에서 조회수가 가장 높은 4개의 게시물을 메인 페이지에 노출시키는 로직을 구현했습니다. Repository에 JPA의 메서드 네이밍을 활용하여 조회수 내림차순(OrderByCountDesc)으로 상위 4개 게시물(Top4By)을 불러오는 메서드를 선언했습니다.

```java
public interface PlacesRepository extends JpaRepository<Places, Long> {
    List<Places> findTop4ByOrderByCountDesc();
}
```

```findTop4ByOrderByCountDesc()``` 를 선언하면 Hibernate에서 자동으로 다음과 같은 쿼리를 생성합니다.

```sql
SELECT * FROM places ORDER BY count DESC LIMIT 4;
```

application.yml에 아래와 같이 설정함으로써 자동 생성된 쿼리를 콘솔에서 확인할 수 있었습니다.

```yaml
spring:
	jpa:
		show-sql: true
```

![Hibernate가 자동 생성한 쿼리](https://user-images.githubusercontent.com/80450262/135632991-4f90ad33-f9ba-4ac3-a6e6-744567531953.png)

### 2-2. 게시물 최신순으로 정렬 및 5개 단위로 페이징

![image](https://user-images.githubusercontent.com/80450262/135636400-32bfc8f3-d81b-4331-b42a-8381ed4d974a.png)

게시물은 등록번호(#)의 역순으로 정렬하였고, 페이지당 게시물 5개씩 나누어 볼 수 있도록 페이징을 구현하였습니다.

JpaRepository 를 상속받은 ```PlacesRepository```에서```findAll()``` 메서드의 매개변수로 ```Pageable``` 인터페이스를 받아 페이징을 구현할 수 있었습니다.

![image](https://user-images.githubusercontent.com/80450262/135636976-b4f74b10-afab-45d9-bb7b-71093e488137.png)

**PlacesController.java**

```java
@GetMapping("/places")
    public String placeList(Model model, @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Places> places = placesService.getList(pageable);

        int pageNum = places.getPageable().getPageNumber(); // 현재 페이지
        int totalPages = places.getTotalPages();// 총 페이지수
        int pageBlock = 5; // 블럭의 수
        int startBlockPage = (pageNum / pageBlock) * pageBlock + 1;
        int endBlockPage = startBlockPage + pageBlock - 1;
        endBlockPage = totalPages < endBlockPage ? totalPages : endBlockPage;

        model.addAttribute("startBlockPage", startBlockPage);
        model.addAttribute("endBlockPage", endBlockPage);
        model.addAttribute("places", places);
        
        return "/places/place-list";
    }
```

**PlacesServiceImpl.java**

```java
@Override
@Transactional
public Page<Places> getList(Pageable pageable) {
  return placesRepository.findAll(pageable);
}
```

컨트롤러에서는 ```@PageableDefault``` 어노테이션을 통해 한 페이지에 보여줄 게시물 개수(size)와 정렬 기준(sort), 그리고 정렬 순서(direction)을 설정했습니다.

Repository의 ```findAll(Pageable pageable)```은 리턴타입으로 ```Page```를 사용하게 됩니다. ```Page```를 사용하면 페이징 기능을 제공하기 위해 쿼리에서 COUNT 함수를 사용하게 됩니다. COUNT 함수는 places 테이블에서 id 컬럼의 데이터 개수를 가져옵니다. Hibernate가 자동으로 생성하는 쿼리는 다음과 같습니다.

```sql
SELECT COUNT(id) FROM places;
```

![image](https://user-images.githubusercontent.com/80450262/135644937-1c2aa9bc-d670-4367-88f7-bc9a2e80d8d4.png)

페이지 블럭으로 보여주기 위해 ```getPageNumber()``` , ```getTotalPages()``` 메서드를 사용하여 현재 페이지와 총 페이지수를 구하고, 최대로 보여줄 페이지 블럭 수를 설정하였습니다. 이를 통해 게시물 개수에 따라 첫 페이지와 끝 페이지의 번호를 결정하는 식을 각각 ```startBlockPage```와 ```endBlockPage``` 에 담아 view로 전달했습니다.

### 2-3. 관리자 계정(ROLE_ADMIN)에 권한 부여

![image](https://user-images.githubusercontent.com/80450262/135647529-a1ae2e95-0e05-4e45-8412-1e26176616b7.png)

Enum 타입의 Role이 ROLE_ADMIN 인 계정(이하 관리자 계정)에는 다른 회원의 Role을 변경하거나, 회원을 탈퇴시킬 수 있으며, 게시물을 삭제할 수 있는 권한을 부여하였습니다.

관리자 계정으로 로그인할 경우, 상단 navbar에 UserList(회원관리 페이지) 링크가 추가된 것을 확인할 수 있습니다. 

![관리자 권한 로그인](https://user-images.githubusercontent.com/80450262/135645997-e82bfcb3-0e0c-43c0-9c59-c115fc532770.png)

관리자만 접속 가능한 URI는 ```SecurityConfig``` 의 ```configure(HttpSecurity http)``` 메서드에 다음과 같이 작성하여 간단하게 접속 권한을 설정할 수 있었습니다.

**SecurityConfig.java**

```java
http
  .authorizeRequests()
  .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
  .antMatchers("/api/admin/**").hasAuthority("ROLE_ADMIN")
```

<br/>

## [🔝](#toc)<a name="3">3. 트러블 슈팅</a>

### 3-1. 의존성 순환 참조 오류

**SecurityConfig.java**

```java
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PrincipalDetailsService principalDetailsService;
    private final PrincipalOAuth2UserService principalOAuth2UserService;

    @Bean
    public BCryptPasswordEncoder pwdEncoder() {
        return new BCryptPasswordEncoder();
    }
  
  	(후략)
}
```

**PrincipalOAuth2UserService.java**

```java
@Service
@RequiredArgsConstructor
public class PrincipalOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
  
  	(후략)
}
```

스프링 시큐리티를 적용하여 구글 소셜 로그인 기능을 추가하는 과정에서 ```SecurityConfig```와 ```PrincipalOAuth2UserService```간에 순환 참조 오류가 발생하는 문제가 있었습니다. ```SecurityConfig```에서는 ```PrincipalOAuth2UserService```를 필요로 하고, ```PrincipalOAuth2UserService```는 다시 ```SecurityConfig```에 빈으로 등록되어 있는 ```BCryptPasswordEncoder```를 필요로 하여 아래와 같이 순환 참조 오류가 발생하는 것으로 생각되었습니다.

![](https://user-images.githubusercontent.com/80450262/135112294-a261b6a0-5493-464d-83bf-4f9d57c43ece.png)

스프링 레퍼런스에서는 형광색 표시된 부분과 같이 "생성자 주입 대신 수정자 주입을 사용하여 순환참조를 해결할 수 있다"고 되어 있었습니다.

![](https://user-images.githubusercontent.com/80450262/135119502-30127b88-6422-4004-b662-dc96e7a738be.png)

개발 당시에는 ```SecurityConfig```에서 ```PrincipalOAuth2UserService```, ```PrincipalOAuth2UserService```에서 ```BCryptPasswordEncoder```의 주입 방식을 생성자 주입 대신 필드 주입(```@Autowired```)으로 변경하였고, 그 결과 순환 참조가 발생하지 않았습니다.

그러나 스프링 레퍼런스에는 생성자 주입을 수정자나 필드 주입 방식으로 변경하는 것을 권장하지 않는다고 되어 있었습니다. 수정자/필드 주입은 먼저 빈을 생성한 후, 주입하려는 빈을 찾아서 주입하여 메서드 실행 시점 전까지 순환참조가 있더라도 알 수 없기 때문에 서버가 실행 중 순환참조로 인해 죽어버릴 가능성이 있기 때문에, 어떻게 하면 더 바람직한 방향으로 수정할 수 있을지 고민해보았습니다.

```PrincipalOAuth2UserService``` 에서는 ```BCryptPasswordEncoder``` 를 ```loadUser()``` 에서 단 1번 사용하기 때문에, 빈을 주입하지 않고, 필요한 부분에서 ```new BCryptPasswordEncoder()``` 를 하는 것으로 변환하여 순환참조를 해결할 수 있었습니다.

<br/>

## [🔝](#toc)<a name="4">4. 프로젝트를 통해 배운 것</a>

### 4-1. JPA의 장점

MyBatis를 사용하더라도 매번 반복적으로 SQL을 작성해야 하는 불편함이 있었지만 JpaRepository 인터페이스를 상속받는 것만으로 SQL에 소모하는 시간을 줄일 수 있어서 편리하게 개발에 임할 수 있었습니다. 또한 메서드에 지정된 표현을 사용하여 네이밍하는 것으로 쿼리가 자동으로 생성되는 경험이 무척 흥미로웠습니다.

### 4-2. Spring Boot와 JSP

**스프링 부트에서 JSP 대신 Thymeleaf나 Mustache와 같은 템플릿 엔진을 권장한다**는 사실을 알게 되었습니다. 서버 배포 시, JSP는 jar 패키징을 지원하지 않아 "Whitelabel Error Page"가 나오는 걸 확인할 수 있었습니다. 이 때문에 war를 사용해야 했고, 이를 스프링 부트의 기본 메인 클래스를 외부 톰캣에서 구동하기 위해 @SpringBootApplication 클래스를 다음과 같이 변경해야 했습니다.

```java
@SpringBootApplication
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ServletInitializer.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ServletInitializer.class, args);
    }
}
```

JSP가 jar 패키징을 이용할 수 없는 이유는 다음과 같다고 합니다:

> 프로젝트에서 JSP 생성 위치는 <u>"**/src/main/webapp/WEB-INF/~~~**"</u> 로 되어 있습니다.
>
> ![](https://user-images.githubusercontent.com/80450262/134775115-99eb5b89-f0b8-42b6-965d-191cc03227e1.png)
>
> WEB-INF 디렉토리가 Tomcat에 기본 정의된 구조이기 때문에 배포할 때도 이러한 구조가 유지되어야 하지만, jar은 WEB-INF 대신 BOOT-INF 디렉토리가 존재하고, 어느 폴더에도 JSP 파일들을 찾을 수 없어서 배포시에 Whitelabel Error Page가 뜨는 것입니다.
>
> |                        jar 파일 구조                         |                        war 파일 구조                         |
> | :----------------------------------------------------------: | :----------------------------------------------------------: |
> | ![](https://user-images.githubusercontent.com/80450262/134775743-0d6adfa8-84d5-40eb-b565-6763a75ec808.png) | ![](https://user-images.githubusercontent.com/80450262/134775748-2f6612dd-dfd4-4872-b3ab-1382d4453f2f.png) |

### 4-3. 단위 테스트 작성의 필요성

개발을 하면서 단위 테스트를 진행하지 않았습니다. 잊고 말았습니다. 꼼꼼하지 못한 불찰이었습니다.

초반에는 크게 불편함을 느끼지 못해 잊고 있었지만, 개발이 진행되면서 기능을 하나 추가할수록, 동작이 되는지를 일일이 화면 단에서 확인하기 위해 그때마다 페이지를 추가하고, 버튼을 추가하고, 서버를 재시작해야 했기 때문에 여간 불편한 일이 아니었습니다.

이번 일을 반면교사 삼아 개발할 때 단위 테스트를 습관화하도록 하겠습니다.

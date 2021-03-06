# ๐ Bon Voyage

> ๊ผญ ๊ฐ๋ณด๊ณ  ์ถ์ ์ฌํ์ง๊ฐ ์๋์? Bon Voyage์ ๊ธฐ๋กํด๋์ธ์!

![](https://user-images.githubusercontent.com/80450262/134696774-13b2f76f-a4fd-4176-96d0-07690a4c8581.png)

## <a name="toc">๐ ๋ชฉ์ฐจ</a>

1. [๊ธฐ์  ์คํ](#1)
2. [ํต์ฌ ๊ธฐ๋ฅ](#2)
3. [ํธ๋ฌ๋ธ ์ํ](#3)
4. [ํ๋ก์ ํธ๋ฅผ ํตํด ๋ฐฐ์ด ๊ฒ](#4)

<br/>

## [๐](#toc)<a name="1">1. ๊ธฐ์  ์คํ</a>

- Front-end
  
  <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"><img src="https://img.shields.io/badge/css3-1572B6?style=for-the-badge&logo=css3&logoColor=white"><img src="https://img.shields.io/badge/bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white"><img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white"><img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=white">
  
- Back-end

  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/spring boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> <img src="https://img.shields.io/badge/spring security-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> <img src="https://img.shields.io/badge/spring data jpa-6DB33F?style=for-the-badge&logo=spring&logoColor=white">

  <img src="https://img.shields.io/badge/mariadb-003545?style=for-the-badge&logo=mariadb&logoColor=white"> <img src="https://img.shields.io/badge/aws-FF9900?style=for-the-badge&logo=amazonaws&logoColor=white"> 

<br/>

## [๐](#toc)<a name="2">2. ํต์ฌ ๊ธฐ๋ฅ</a>

- [๋ฉ์ธ ํ์ด์ง์ ์กฐํ์ ๊ฐ์ฅ ๋์ 4๊ฐ ๊ฒ์๋ฌผ ๋ธ์ถ](#2-1)
- [๊ฒ์๋ฌผ ์ต์ ์์ผ๋ก ์ ๋ ฌ ๋ฐ 5๊ฐ ๋จ์๋ก ํ์ด์ง](#2-2)
- [๊ด๋ฆฌ์ ๊ณ์ (ROLE_ADMIN)์ ๊ถํ ๋ถ์ฌ](#2-3)

  

### <a name="2-1">2-1. ๋ฉ์ธ ํ์ด์ง์ ์กฐํ์ ๊ฐ์ฅ ๋์ 4๊ฐ ๊ฒ์๋ฌผ ๋ธ์ถ</a>

![](src/main/resources/static/docs/2-1.gif)

๊ฒ์ํ์์ ์กฐํ์๊ฐ ๊ฐ์ฅ ๋์ 4๊ฐ์ ๊ฒ์๋ฌผ์ ๋ฉ์ธ ํ์ด์ง์ ๋ธ์ถ์ํค๋ ๋ก์ง์ ๊ตฌํํ์ต๋๋ค. Repository์ JPA์ ๋ฉ์๋ ๋ค์ด๋ฐ์ ํ์ฉํ์ฌ ์กฐํ์ ๋ด๋ฆผ์ฐจ์(OrderByCountDesc)์ผ๋ก ์์ 4๊ฐ ๊ฒ์๋ฌผ(Top4By)์ ๋ถ๋ฌ์ค๋ ๋ฉ์๋๋ฅผ ์ ์ธํ์ต๋๋ค.

```java
public interface PlacesRepository extends JpaRepository<Places, Long> {
    List<Places> findTop4ByOrderByCountDesc();
}
```

```findTop4ByOrderByCountDesc()``` ๋ฅผ ์ ์ธํ๋ฉด Hibernate์์ ์๋์ผ๋ก ๋ค์๊ณผ ๊ฐ์ ์ฟผ๋ฆฌ๋ฅผ ์์ฑํฉ๋๋ค.

```sql
SELECT * FROM places ORDER BY count DESC LIMIT 4;
```

application.yml์ ์๋์ ๊ฐ์ด ์ค์ ํจ์ผ๋ก์จ ์๋ ์์ฑ๋ ์ฟผ๋ฆฌ๋ฅผ ์ฝ์์์ ํ์ธํ  ์ ์์์ต๋๋ค.

```yaml
spring:
	jpa:
		show-sql: true
```

![Hibernate๊ฐ ์๋ ์์ฑํ ์ฟผ๋ฆฌ](https://user-images.githubusercontent.com/80450262/135632991-4f90ad33-f9ba-4ac3-a6e6-744567531953.png)

### <a name="2-2">2-2. ๊ฒ์๋ฌผ ์ต์ ์์ผ๋ก ์ ๋ ฌ ๋ฐ 5๊ฐ ๋จ์๋ก ํ์ด์ง</a>

![image](https://user-images.githubusercontent.com/80450262/135636400-32bfc8f3-d81b-4331-b42a-8381ed4d974a.png)

๊ฒ์๋ฌผ์ ๋ฑ๋ก๋ฒํธ(#)์ ์ญ์์ผ๋ก ์ ๋ ฌํ์๊ณ , ํ์ด์ง๋น ๊ฒ์๋ฌผ 5๊ฐ์ฉ ๋๋์ด ๋ณผ ์ ์๋๋ก ํ์ด์ง์ ๊ตฌํํ์์ต๋๋ค.

JpaRepository ๋ฅผ ์์๋ฐ์ ```PlacesRepository```์์```findAll()``` ๋ฉ์๋์ ๋งค๊ฐ๋ณ์๋ก ```Pageable``` ์ธํฐํ์ด์ค๋ฅผ ๋ฐ์ ํ์ด์ง์ ๊ตฌํํ  ์ ์์์ต๋๋ค.

![image](https://user-images.githubusercontent.com/80450262/135636976-b4f74b10-afab-45d9-bb7b-71093e488137.png)

**PlacesController.java**

```java
@GetMapping("/places")
    public String placeList(Model model, @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Places> places = placesService.getList(pageable);

        int pageNum = places.getPageable().getPageNumber(); // ํ์ฌ ํ์ด์ง
        int totalPages = places.getTotalPages();// ์ด ํ์ด์ง์
        int pageBlock = 5; // ๋ธ๋ญ์ ์
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

์ปจํธ๋กค๋ฌ์์๋ ```@PageableDefault``` ์ด๋ธํ์ด์์ ํตํด ํ ํ์ด์ง์ ๋ณด์ฌ์ค ๊ฒ์๋ฌผ ๊ฐ์(size)์ ์ ๋ ฌ ๊ธฐ์ค(sort), ๊ทธ๋ฆฌ๊ณ  ์ ๋ ฌ ์์(direction)์ ์ค์ ํ์ต๋๋ค.

Repository์ ```findAll(Pageable pageable)```์ ๋ฆฌํดํ์์ผ๋ก ```Page```๋ฅผ ์ฌ์ฉํ๊ฒ ๋ฉ๋๋ค. ```Page```๋ฅผ ์ฌ์ฉํ๋ฉด ํ์ด์ง ๊ธฐ๋ฅ์ ์ ๊ณตํ๊ธฐ ์ํด ์ฟผ๋ฆฌ์์ COUNT ํจ์๋ฅผ ์ฌ์ฉํ๊ฒ ๋ฉ๋๋ค. COUNT ํจ์๋ places ํ์ด๋ธ์์ id ์ปฌ๋ผ์ ๋ฐ์ดํฐ ๊ฐ์๋ฅผ ๊ฐ์ ธ์ต๋๋ค. Hibernate๊ฐ ์๋์ผ๋ก ์์ฑํ๋ ์ฟผ๋ฆฌ๋ ๋ค์๊ณผ ๊ฐ์ต๋๋ค.

```sql
SELECT COUNT(id) FROM places;
```

![image](https://user-images.githubusercontent.com/80450262/135644937-1c2aa9bc-d670-4367-88f7-bc9a2e80d8d4.png)

ํ์ด์ง ๋ธ๋ญ์ผ๋ก ๋ณด์ฌ์ฃผ๊ธฐ ์ํด ```getPageNumber()``` , ```getTotalPages()``` ๋ฉ์๋๋ฅผ ์ฌ์ฉํ์ฌ ํ์ฌ ํ์ด์ง์ ์ด ํ์ด์ง์๋ฅผ ๊ตฌํ๊ณ , ์ต๋๋ก ๋ณด์ฌ์ค ํ์ด์ง ๋ธ๋ญ ์๋ฅผ ์ค์ ํ์์ต๋๋ค. ์ด๋ฅผ ํตํด ๊ฒ์๋ฌผ ๊ฐ์์ ๋ฐ๋ผ ์ฒซ ํ์ด์ง์ ๋ ํ์ด์ง์ ๋ฒํธ๋ฅผ ๊ฒฐ์ ํ๋ ์์ ๊ฐ๊ฐ ```startBlockPage```์ ```endBlockPage``` ์ ๋ด์ view๋ก ์ ๋ฌํ์ต๋๋ค.

### <a name="2-3">2-3. ๊ด๋ฆฌ์ ๊ณ์ (ROLE_ADMIN)์ ๊ถํ ๋ถ์ฌ</a>

![image](https://user-images.githubusercontent.com/80450262/135647529-a1ae2e95-0e05-4e45-8412-1e26176616b7.png)

Enum ํ์์ Role์ด ROLE_ADMIN ์ธ ๊ณ์ (์ดํ ๊ด๋ฆฌ์ ๊ณ์ )์๋ ๋ค๋ฅธ ํ์์ Role์ ๋ณ๊ฒฝํ๊ฑฐ๋, ํ์์ ํํด์ํฌ ์ ์์ผ๋ฉฐ, ๊ฒ์๋ฌผ์ ์ญ์ ํ  ์ ์๋ ๊ถํ์ ๋ถ์ฌํ์์ต๋๋ค.

๊ด๋ฆฌ์ ๊ณ์ ์ผ๋ก ๋ก๊ทธ์ธํ  ๊ฒฝ์ฐ, ์๋จ navbar์ UserList(ํ์๊ด๋ฆฌ ํ์ด์ง) ๋งํฌ๊ฐ ์ถ๊ฐ๋ ๊ฒ์ ํ์ธํ  ์ ์์ต๋๋ค. 

![๊ด๋ฆฌ์ ๊ถํ ๋ก๊ทธ์ธ](https://user-images.githubusercontent.com/80450262/135645997-e82bfcb3-0e0c-43c0-9c59-c115fc532770.png)

๊ด๋ฆฌ์๋ง ์ ์ ๊ฐ๋ฅํ URI๋ ```SecurityConfig``` ์ ```configure(HttpSecurity http)``` ๋ฉ์๋์ ๋ค์๊ณผ ๊ฐ์ด ์์ฑํ์ฌ ๊ฐ๋จํ๊ฒ ์ ์ ๊ถํ์ ์ค์ ํ  ์ ์์์ต๋๋ค.

**SecurityConfig.java**

```java
http
  .authorizeRequests()
  .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
  .antMatchers("/api/admin/**").hasAuthority("ROLE_ADMIN")
```

<br/>

## [๐](#toc)<a name="3">3. ํธ๋ฌ๋ธ ์ํ</a>

### 3-1. ์์กด์ฑ ์ํ ์ฐธ์กฐ ์ค๋ฅ

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
  
  	(ํ๋ต)
}
```

**PrincipalOAuth2UserService.java**

```java
@Service
@RequiredArgsConstructor
public class PrincipalOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
  
  	(ํ๋ต)
}
```

์คํ๋ง ์ํ๋ฆฌํฐ๋ฅผ ์ ์ฉํ์ฌ ๊ตฌ๊ธ ์์ ๋ก๊ทธ์ธ ๊ธฐ๋ฅ์ ์ถ๊ฐํ๋ ๊ณผ์ ์์ ```SecurityConfig```์ ```PrincipalOAuth2UserService```๊ฐ์ ์ํ ์ฐธ์กฐ ์ค๋ฅ๊ฐ ๋ฐ์ํ๋ ๋ฌธ์ ๊ฐ ์์์ต๋๋ค. ```SecurityConfig```์์๋ ```PrincipalOAuth2UserService```๋ฅผ ํ์๋ก ํ๊ณ , ```PrincipalOAuth2UserService```๋ ๋ค์ ```SecurityConfig```์ ๋น์ผ๋ก ๋ฑ๋ก๋์ด ์๋ ```BCryptPasswordEncoder```๋ฅผ ํ์๋ก ํ์ฌ ์๋์ ๊ฐ์ด ์ํ ์ฐธ์กฐ ์ค๋ฅ๊ฐ ๋ฐ์ํ๋ ๊ฒ์ผ๋ก ์๊ฐ๋์์ต๋๋ค.

![](https://user-images.githubusercontent.com/80450262/135112294-a261b6a0-5493-464d-83bf-4f9d57c43ece.png)

์คํ๋ง ๋ ํผ๋ฐ์ค์์๋ ํ๊ด์ ํ์๋ ๋ถ๋ถ๊ณผ ๊ฐ์ด "์์ฑ์ ์ฃผ์ ๋์  ์์ ์ ์ฃผ์์ ์ฌ์ฉํ์ฌ ์ํ์ฐธ์กฐ๋ฅผ ํด๊ฒฐํ  ์ ์๋ค"๊ณ  ๋์ด ์์์ต๋๋ค.

![](https://user-images.githubusercontent.com/80450262/135119502-30127b88-6422-4004-b662-dc96e7a738be.png)

๊ฐ๋ฐ ๋น์์๋ ```SecurityConfig```์์ ```PrincipalOAuth2UserService```, ```PrincipalOAuth2UserService```์์ ```BCryptPasswordEncoder```์ ์ฃผ์ ๋ฐฉ์์ ์์ฑ์ ์ฃผ์ ๋์  ํ๋ ์ฃผ์(```@Autowired```)์ผ๋ก ๋ณ๊ฒฝํ์๊ณ , ๊ทธ ๊ฒฐ๊ณผ ์ํ ์ฐธ์กฐ๊ฐ ๋ฐ์ํ์ง ์์์ต๋๋ค.

๊ทธ๋ฌ๋ ์คํ๋ง ๋ ํผ๋ฐ์ค์๋ ์์ฑ์ ์ฃผ์์ ์์ ์๋ ํ๋ ์ฃผ์ ๋ฐฉ์์ผ๋ก ๋ณ๊ฒฝํ๋ ๊ฒ์ ๊ถ์ฅํ์ง ์๋๋ค๊ณ  ๋์ด ์์์ต๋๋ค. ์์ ์/ํ๋ ์ฃผ์์ ๋จผ์  ๋น์ ์์ฑํ ํ, ์ฃผ์ํ๋ ค๋ ๋น์ ์ฐพ์์ ์ฃผ์ํ์ฌ ๋ฉ์๋ ์คํ ์์  ์ ๊น์ง ์ํ์ฐธ์กฐ๊ฐ ์๋๋ผ๋ ์ ์ ์๊ธฐ ๋๋ฌธ์ ์๋ฒ๊ฐ ์คํ ์ค ์ํ์ฐธ์กฐ๋ก ์ธํด ์ฃฝ์ด๋ฒ๋ฆด ๊ฐ๋ฅ์ฑ์ด ์๊ธฐ ๋๋ฌธ์, ์ด๋ป๊ฒ ํ๋ฉด ๋ ๋ฐ๋์งํ ๋ฐฉํฅ์ผ๋ก ์์ ํ  ์ ์์์ง ๊ณ ๋ฏผํด๋ณด์์ต๋๋ค.

```PrincipalOAuth2UserService``` ์์๋ ```BCryptPasswordEncoder``` ๋ฅผ ```loadUser()``` ์์ ๋จ 1๋ฒ ์ฌ์ฉํ๊ธฐ ๋๋ฌธ์, ๋น์ ์ฃผ์ํ์ง ์๊ณ , ํ์ํ ๋ถ๋ถ์์ ```new BCryptPasswordEncoder()``` ๋ฅผ ํ๋ ๊ฒ์ผ๋ก ๋ณํํ์ฌ ์ํ์ฐธ์กฐ๋ฅผ ํด๊ฒฐํ  ์ ์์์ต๋๋ค.

<br/>

## [๐](#toc)<a name="4">4. ํ๋ก์ ํธ๋ฅผ ํตํด ๋ฐฐ์ด ๊ฒ</a>

### 4-1. JPA์ ์ฅ์ 

MyBatis๋ฅผ ์ฌ์ฉํ๋๋ผ๋ ๋งค๋ฒ ๋ฐ๋ณต์ ์ผ๋ก SQL์ ์์ฑํด์ผ ํ๋ ๋ถํธํจ์ด ์์์ง๋ง JpaRepository ์ธํฐํ์ด์ค๋ฅผ ์์๋ฐ๋ ๊ฒ๋ง์ผ๋ก SQL์ ์๋ชจํ๋ ์๊ฐ์ ์ค์ผ ์ ์์ด์ ํธ๋ฆฌํ๊ฒ ๊ฐ๋ฐ์ ์ํ  ์ ์์์ต๋๋ค. ๋ํ ๋ฉ์๋์ ์ง์ ๋ ํํ์ ์ฌ์ฉํ์ฌ ๋ค์ด๋ฐํ๋ ๊ฒ์ผ๋ก ์ฟผ๋ฆฌ๊ฐ ์๋์ผ๋ก ์์ฑ๋๋ ๊ฒฝํ์ด ๋ฌด์ฒ ํฅ๋ฏธ๋ก์ ์ต๋๋ค.

### 4-2. Spring Boot์ JSP

**์คํ๋ง ๋ถํธ์์ JSP ๋์  Thymeleaf๋ Mustache์ ๊ฐ์ ํํ๋ฆฟ ์์ง์ ๊ถ์ฅํ๋ค**๋ ์ฌ์ค์ ์๊ฒ ๋์์ต๋๋ค. ์๋ฒ ๋ฐฐํฌ ์, JSP๋ jar ํจํค์ง์ ์ง์ํ์ง ์์ "Whitelabel Error Page"๊ฐ ๋์ค๋ ๊ฑธ ํ์ธํ  ์ ์์์ต๋๋ค. ์ด ๋๋ฌธ์ war๋ฅผ ์ฌ์ฉํด์ผ ํ๊ณ , ์ด๋ฅผ ์คํ๋ง ๋ถํธ์ ๊ธฐ๋ณธ ๋ฉ์ธ ํด๋์ค๋ฅผ ์ธ๋ถ ํฐ์บฃ์์ ๊ตฌ๋ํ๊ธฐ ์ํด @SpringBootApplication ํด๋์ค๋ฅผ ๋ค์๊ณผ ๊ฐ์ด ๋ณ๊ฒฝํด์ผ ํ์ต๋๋ค.

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

JSP๊ฐ jar ํจํค์ง์ ์ด์ฉํ  ์ ์๋ ์ด์ ๋ ๋ค์๊ณผ ๊ฐ๋ค๊ณ  ํฉ๋๋ค:

> ํ๋ก์ ํธ์์ JSP ์์ฑ ์์น๋ <u>"**/src/main/webapp/WEB-INF/~~~**"</u> ๋ก ๋์ด ์์ต๋๋ค.
>
> ![](https://user-images.githubusercontent.com/80450262/134775115-99eb5b89-f0b8-42b6-965d-191cc03227e1.png)
>
> WEB-INF ๋๋ ํ ๋ฆฌ๊ฐ Tomcat์ ๊ธฐ๋ณธ ์ ์๋ ๊ตฌ์กฐ์ด๊ธฐ ๋๋ฌธ์ ๋ฐฐํฌํ  ๋๋ ์ด๋ฌํ ๊ตฌ์กฐ๊ฐ ์ ์ง๋์ด์ผ ํ์ง๋ง, jar์ WEB-INF ๋์  BOOT-INF ๋๋ ํ ๋ฆฌ๊ฐ ์กด์ฌํ๊ณ , ์ด๋ ํด๋์๋ JSP ํ์ผ๋ค์ ์ฐพ์ ์ ์์ด์ ๋ฐฐํฌ์์ Whitelabel Error Page๊ฐ ๋จ๋ ๊ฒ์๋๋ค.
>
> |                        jar ํ์ผ ๊ตฌ์กฐ                         |                        war ํ์ผ ๊ตฌ์กฐ                         |
> | :----------------------------------------------------------: | :----------------------------------------------------------: |
> | ![](https://user-images.githubusercontent.com/80450262/134775743-0d6adfa8-84d5-40eb-b565-6763a75ec808.png) | ![](https://user-images.githubusercontent.com/80450262/134775748-2f6612dd-dfd4-4872-b3ab-1382d4453f2f.png) |

### 4-3. ๋จ์ ํ์คํธ ์์ฑ์ ํ์์ฑ

๊ฐ๋ฐ์ ํ๋ฉด์ ๋จ์ ํ์คํธ๋ฅผ ์งํํ์ง ์์์ต๋๋ค. ์๊ณ  ๋ง์์ต๋๋ค. ๊ผผ๊ผผํ์ง ๋ชปํ ๋ถ์ฐฐ์ด์์ต๋๋ค.

์ด๋ฐ์๋ ํฌ๊ฒ ๋ถํธํจ์ ๋๋ผ์ง ๋ชปํด ์๊ณ  ์์์ง๋ง, ๊ฐ๋ฐ์ด ์งํ๋๋ฉด์ ๊ธฐ๋ฅ์ ํ๋ ์ถ๊ฐํ ์๋ก, ๋์์ด ๋๋์ง๋ฅผ ์ผ์ผ์ด ํ๋ฉด ๋จ์์ ํ์ธํ๊ธฐ ์ํด ๊ทธ๋๋ง๋ค ํ์ด์ง๋ฅผ ์ถ๊ฐํ๊ณ , ๋ฒํผ์ ์ถ๊ฐํ๊ณ , ์๋ฒ๋ฅผ ์ฌ์์ํด์ผ ํ๊ธฐ ๋๋ฌธ์ ์ฌ๊ฐ ๋ถํธํ ์ผ์ด ์๋์์ต๋๋ค.

์ด๋ฒ ์ผ์ ๋ฐ๋ฉด๊ต์ฌ ์ผ์ ๊ฐ๋ฐํ  ๋ ๋จ์ ํ์คํธ๋ฅผ ์ต๊ดํํ๋๋ก ํ๊ฒ ์ต๋๋ค.

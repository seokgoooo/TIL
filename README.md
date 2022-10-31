# TIL (Today I Learned)
- 정리중입니다~
- 중요한 것은 재미, 흥미를 유지하면서 일을 지속하는 것
- 하다 보면 그냥 하게 된다.
- 어떤 기술을 쓰던 관심 있었던 서비스를 만들어보자
- Intellij, Typescript, Node.js ing...

## Java
> * 자바 가상 기계 (JVM / Java Virtual Machine) : 자바 프로그램은 완전한 기계어가 아닌 중간 단계의 바이트 코드이기 때문에, 이것을 해석하고 실행할 수 있게 해주는 가상의 운영체제
>   JVM의 메모리 영역
>   * 메소드 영역 : 클래스들을 클래스 로더로 읽어 클래스별로 런타임 상수 풀, 필드 데이터, 메소드 데이터, 메소드 코드, 생성자 코드 등을 분류해서 저장한다.
>   * 힙 영역 : 객체와 배열이 생성되는 영역. JVM 스택 영역에서 생성된 변수나 다른 객체의 필드에서 이 곳에 있는 객체와 배열을 참조한다.
>   * JVM 스택 영역 : 스레드마다 하나씩 존재. 스레드가 시작할 때마다 JVM 스택 영역이 할당된다.
> * Java는 기본적으로 모든 객체 변수를 nullable로 정의하고있다. 그래서 null 안정성에 대한 검사는 모두 개발자가 해야할일이다. 그래서 생기는 고질적인 문제가 null 안정성이다~
> * getter/setter도 개발자가 만들어줘야한다.

> * process : 운영체제로부터 메모리를 할당받아 실행하는 애플리케이션의 코드
> * thread : 한 가지 작업을 실행하기 위해 순차적으로 실행할 코드를 실처럼 이어 놓았다고 해서 유래된 이름. 하나의 스레드는 하나의 코드 실행 흐름. 때문에 한 프로세스 내에 스레드가 두 개라면 두 개의 코드 실행 흐름이 생긴다는 의미.

> * 멀티 스레드는 동시성 또는 병렬성으로 실행된다.
>   * 동시성 (concurrency) : 멀티 작업을 위해 하나의 코어에서 멀티 스레드가 번갈아가며 실행하는 성질
>   * 병렬성 (parallelism) : 멀티 작업을 위해 멀티 코어에서 개별 스레드를 동시에 실행하는 성질
> * 트랜잭션 - 로직이 처음부터 끝까지 완료되어야 하는 작업(과정)? ex) 구매과정

> API (Application Programming Interface) : 프로그램들이 서로 상호작용하는 것들 도와주는 매개체. 서버와 DB에 대한 출입구 역할. 애플리케이션과 기기가 원활하게 통신할 수 있도록 도와준다. 모든 네트워크 접속을 표준화하는 역할. 이러한 표준화 과정을 통해 개발과정을 간소화시키고 개발자들 간 협업을 용이하게 한다.
> * RESTful API : HTTP 통신에서 어떤 차원에 대한 CRUD 요청을 Resource와 Method로 표현하여 특정한 형태로 전달하는 방식. Resource (자원, URI), Method (요청 방식, GET or POST 등), Representation of Resource (자원의 형태, JSON or XML 등) 으로 구성된다
> * 쿠키 vs 세션
>   * 모두 인증방식 중 하나에 해당 된다.
>   * 둘의 가장 큰 차이는 정보가 저장되는 위치 쿠키 - 클라이언트 / 세션 - 서버
>   * 보안이 필요하거나 서비스 제공자가 직접 관리해야 하는 정보는 세션에 저장하지만 모두 세션에 저장하게 된다면 요청이 많을 때 서버에 부담이 커지므로 적절하게 쿠키와 분배해서 저장할 필요가 있다

>  Entity vs DTO
>   * Entity : 실제 DB 테이블과 매핑되는 클래스, DB의 테이블에 존재하는 컬럼 그대로 필드로 가지는 객체
>   * DTO : 레이어간 데이터 교환이 이루어질 수 있도록 하는 객체. 주로 View와 Controller 사이에서 데이터를 주고받을 때 활용성이 높다.
>   * Entity와 DTO를 분리하는 이유는 DB와 View 사이의 역할 분리를 위해

> * 기본키 설정 이유
> 1. 데이터의 중복 방지
> 2. 데이터를 매우 빠르게 찾을 수 있게 도와준다.
> (기본키를 설정하면 DBMS는 인덱스를 만든다)

## Javascript
* Boolean 변환표

|자료형|True|False|
|:--|:--:|:--:|
|Boolean|True|False|
|String|""을 제외한 모든 값|""일 때|
|Number|0 보다 큰 모든 수|0 or NaN|
|Object|null 을 제외한 모든 object|null|
|Undefined|해당 사항 없음|undefined|
|Null|해당 사항 없음|null|

* !! 연산자는 Boolean 타입으로 명시적으로 형변환해주기 위해 사용한다.

1. let : 값 재할당 가능
2. const : 값 재할당 불가능
3. var : 거의 쓰지 않는 문법 (구버전)

1. npm : readline-sync 라이브러리
    * keyIn : ( Yes / No ) 를 입력받아야할 때 사용
    * 이외에도 email, phoneNumber 등 사용자의 입력을 비동기로 처리하고 싶을 때 유용한 방법이 많다.
2. this 는 가리키는 것이 많다. 잘 파악할 줄 알아야 할 듯

1. Array Method
    * map : 배열의 각 원소별로 지정된 함수를 실행된 결과로 구성된 새로운 배열을 반환한다.
    * filter : 지정된 함수의 결과 값을 true로 만드는 원소들로만 구성된 별도의 배열을 반환한다.
2. return vs break
    * return : 함수 실행 종료하고 함수를 빠져 나온다.
    * break : 현재 루프를 종료하고 루프에서 빠져 나온다.

## Typescript
1. Enum
2. this로 자기자신을 참조하는 방법
3. readonly
4. 타입을 엄격하게 선언해주는편이 좋은게 아닌가 하는 생각 (catch의 e에 any 타입 명시)
5. as 문법 : 타입 표명 (Type Assertion) 이라고 한다. 프로그래머가 컴파일러에게 이 타입이라고 명시해주는 것. 되도록 사용이 권장되지는 않는다. 선언해준다고해서 타입이 반드시 보장되지 않는다. typeof, instanceof 등으로 타입가드를 해줄 수도 있다.
6. null vs undefined
    * 둘 다 값이 '없는 상태'를 말한다.
    * null 은 null 타입이라고 명시해주는 것.
    * undefined 는 타입도 명확하지 않은 상태.
1. in 연산자 narrowing (타입가드)
    * 타입을 추론할 수 있다.
    
## Git
> * [markdown 기본 문법](/Git/markdownBasic.md)
> * 커밋(Commit) **신중하게** 의미있는것만! 설명 꼭 달아서!!

## :egg: 완성되면 >>> :fried_egg: 로 나간다
* [ ] 백준 문제 풀이 100
* [ ] 내가 만들고 싶은 앱, 웹
* https://brunch.co.kr/@cg4jins

## TDD / Test code implementation
* 테스트라는건 코드에 변경이 가해질 경우, 기존의 의도와 다르게 돌아가는 부분이 있는지 빠르게 파악하는게 핵심.
* 그냥 무작정 하는 Unit test 는 오히려 안 하는게 낫다.
* 필요한 기능들이 잘 동작하는지 알아볼 수 있는 테스트가 무엇일지를 위주로 고민하면 도움이 될 것이다.
  * Testable / Flexible architecture
    * 다음으로는 테스트가 가능한 어플리케이션의 구조.
    * 한국은 아직까지도 자바가 메인.
    * 테스트가 용이하며 변화에 열려있는 아키텍처를 구성하는게 중요.
    * 어플리케이션의 세부 구성부분들을 잘 나누어 유지보수가 용이하게 하는것이 중요.

## Book
- [x] 프로그래머의 길 멘토에게 묻다
- [ ] 커리어 스킬
- [ ] 객체지향의 사실과 오해
- [ ] 클린 코드(Clean code)
- [ ] 모던 자바스크립트 Deep Dive
- [x] 비전공자를 위한 이해할 수 있는 IT 지식
- [ ] 누워서 읽는 알고리즘
- [ ] 자바로 배우는 쉬운 자료구조
- [ ] 테스트 주도 개발

## Site
- [도로락님] (https://dololak.tistory.com/)
- [뇌 채우기 공간] (https://sso-feeling.tistory.com/)
- [자바캔] (https://javacan.tistory.com/)
- [st-lab] (https://st-lab.tistory.com/)
- https://devmoony.tistory.com/category/Programming/Java
- https://level.goorm.io/
- https://uxgjs.tistory.com/
- https://wikidocs.net/book/31
- https://leetcode.com/
- https://velog.io/@josworks27/series/TILToday-I-Learned
- https://velog.io/@sham
- https://lena-chamna.netlify.app/post/http_multipart_form-data/
- https://xzio.tistory.com/484?category=845469
- https://myjamong.tistory.com/154
- https://itstudyroom.tistory.com/entry/MVC2-%EA%B2%8C%EC%8B%9C%ED%8C%90-4-%ED%8C%8C%EC%9D%BC-%EC%97%85%EB%A1%9C%EB%93%9C
- https://velog.io/@hyeon4137
- https://www.codingfactory.net/mariadb-tutorial-table-of-contents
- https://7942yongdae.tistory.com/86
- https://velog.io/@bining/%EC%9D%B8%EC%8A%A4%ED%83%80-%EC%8A%A4%ED%82%A4%EB%A7%88-%EB%94%94%EC%9E%90%EC%9D%B8
- https://velog.io/@rorohyun132/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EC%8B%B8%EC%9D%B4%EC%9B%94%EB%93%9C-%EA%B0%90%EC%84%B1%EC%9D%98-%EC%BB%A4%ED%94%8Csns-%EB%B0%8F-%EC%87%BC%ED%95%91%EB%AA%B0#%ED%8E%98%EC%9D%B4%EC%A7%80%EB%B3%84--%EC%84%A4%EB%AA%85-react
- https://multifrontgarden.tistory.com/97
- https://laycoder.tistory.com/109?category=846100
- https://devfolio.kr/
- https://euncho.medium.com/%EA%B0%9C%EB%B0%9C%EC%9E%90%EC%9D%98-%EC%84%B1%EC%9E%A5-%EA%B0%80%EB%8A%A5%EC%84%B1%EC%9D%80-%EC%96%B4%EB%96%BB%EA%B2%8C-%EC%B8%A1%EC%A0%95-%EA%B0%80%EB%8A%A5%ED%95%9C%EA%B0%80-238dd3f0f33
- https://brunch.co.kr/@jihyun-um/39
- https://yozm.wishket.com/magazine/detail/1585/
- https://yozm.wishket.com/magazine/detail/1555/
- https://jang-sn.tistory.com/4?category=953765
- https://steady-coding.tistory.com/
- https://tech.kakao.com/2020/07/22/recruit-kakaotalk-backend/
- https://jojoldu.tistory.com/661
- [백엔드] (https://velog.io/@city7310?tag=Backend)
- [자바 스프링 공부 Bluesky_님] (https://luvstudy.tistory.com/category/Study/Java)
- [비전공자 ruckus님] (https://ruckus.tistory.com/)
- [무니의 개발로그] (https://devmoony.tistory.com/)
- [KOCW 객체지향 강의] (http://www.kocw.net/home/search/search.do?query=%EA%B0%9D%EC%B2%B4%20%EC%A7%80%ED%96%A5)
- [IT기술 과거글 정리] (https://blog.naver.com/myca11)
- [SQL 연습] (https://sqlzoo.net/wiki/SQL_Tutorial)
- [스프링] (https://velog.io/@sgwon1996)
- [공부] (https://velog.io/@alstjdwo1601)
- [면접] (https://dev-coco.tistory.com/153)
- (https://mungto.tistory.com/)
- (https://velog.io/@csw98213)
- https://medium.com/@leejukyung/%EC%8A%A4%ED%83%80%ED%8A%B8%EC%97%85-%EC%83%9D%ED%99%9C-%EA%B7%B8%EB%A6%AC%EA%B3%A0-%EC%84%B1%EC%9E%A5-aadd15eda833
- https://preamtree.tistory.com/
- https://medium.com/@totuworld/%ED%86%A0%EC%9D%B4-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EC%A3%BC%EB%8F%84-%ED%95%99%EC%8A%B5-%EC%84%B1%EC%9E%A5-94fc304984b0
- [자료구조~] https://hanamon.kr/category/data-structure-algorithm/
- https://velog.io/@yukina1418

# TIL (Today I Learned)
- '##'을 하나씩 떼서 레포 정리를 천천히 해보자
- 개발자는 실력을 키우는게 답이다
- 할일 : 이력서 초안 마무리, 레포 정리

## 느낀점
- 프로젝트 진행시 변수 상황? 이 생길때 어떻게 대처해야 좋을지 생각을 해둘 필요가 있을듯....
- 변수 때문에 예상 개발기간을 2배로 잡는다고 하는데 일리가 있는 말이다

## Java
> * 자바 가상 기계 (JVM / Java Virtual Machine) : 자바 프로그램은 완전한 기계어가 아닌 중간 단계의 바이트 코드이기 때문에, 이것을 해석하고 실행할 수 있게 해주는 가상의 운영체제
>   JVM의 메모리 영역
>   * 메소드 영역 : 클래스들을 클래스 로더로 읽어 클래스별로 런타임 상수 풀, 필드 데이터, 메소드 데이터, 메소드 코드, 생성자 코드 등을 분류해서 저장한다.
>   * 힙 영역 : 객체와 배열이 생성되는 영역. JVM 스택 영역에서 생성된 변수나 다른 객체의 필드에서 이 곳에 있는 객체와 배열을 참조한다.
>   * JVM 스택 영역 : 스레드마다 하나씩 존재. 스레드가 시작할 때마다 JVM 스택 영역이 할당된다.
> * Java는 기본적으로 모든 객체 변수를 nullable로 정의하고있다. 그래서 null 안정성에 대한 검사는 모두 개발자가 해야할일이다. 그래서 생기는 고질적인 문제가 null 안정성이다~
> * getter/setter도 개발자가 만들어줘야한다.

> * Spring : 자바의 특성을 최대한으로 끌어내 여러 디자인 패턴으로 정교하게 빚어낸 프레임워크

> * process : 운영체제로부터 메모리를 할당받아 실행하는 애플리케이션의 코드
> * thread : 한 가지 작업을 실행하기 위해 순차적으로 실행할 코드를 실처럼 이어 놓았다고 해서 유래된 이름. 하나의 스레드는 하나의 코드 실행 흐름. 때문에 한 프로세스 내에 스레드가 두 개라면 두 개의 코드 실행 흐름이 생긴다는 의미.

> * 멀티 스레드는 동시성 또는 병렬성으로 실행된다.
>   * 동시성 (concurrency) : 멀티 작업을 위해 하나의 코어에서 멀티 스레드가 번갈아가며 실행하는 성질
>    * 병렬성 (parallelism) : 멀티 작업을 위해 멀티 코어에서 개별 스레드를 동시에 실행하는 성질
> * 트랜잭션 - 로직이 처음부터 끝까지 완료되어야 하는 작업(과정)? ex) 구매과정

> API (Application Programming Interface) : 프로그램들이 서로 상호작용하는 것들 도와주는 매개체. 서버와 DB에 대한 출입구 역할. 애플리케이션과 기기가 원활하게 통신할 수 있도록 도와준다. 모든 네트워크 접속을 표준화하는 역할. 이러한 표준화 과정을 통해 개발과정을 간소화시키고 개발자들 간 협업을 용이하게 한다.

> * 쿠키 vs 세션
>   * 모두 인증방식 중 하나에 해당 된다.
>   * 둘의 가장 큰 차이는 정보가 저장되는 위치 쿠키 - 클라이언트 / 세션 - 서버
>   * 보안이 필요하거나 서비스 제공자가 직접 관리해야 하는 정보는 세션에 저장하지만 모두 세션에 저장하게 된다면 요청이 많을 때 서버에 부담이 커지므로 적절하게 쿠키와 분배해서 저장할 필요가 있다

> * 기본키 설정 이유
> 1. 데이터의 중복 방지
> 2. 데이터를 매우 빠르게 찾을 수 있게 도와준다.
> (기본키를 설정하면 DBMS는 인덱스를 만든다)

## Git
> * [markdown 기본 문법](/Git/markdownBasic.md)
> * 커밋(Commit) **신중하게** 의미있는것만! 설명 꼭 달아서!!

## :egg: 완성되면 >>> :fried_egg: 로 나간다
* OOP (Object Oriented Programming)
* [ ] 백준 문제 풀이 100
* [ ] 내가 만들고 싶은 앱, 웹
* https://brunch.co.kr/@cg4jins

## CS 6대 과목
1. 자료구조
2. 알고리즘
3. 컴퓨터구조
4. 운영체제
5. 네트워크
6. 데이터베이스

## 코테
* 자료구조
* 알고리즘 
* Big O 표기법
* 시간복잡도 / 공간복잡도
  * 책 : 자바로 배우는 쉬운 자료구조
  * 엔지니어대한민국 Youtube 채널 (자료구조 코드 구현 부분 혼자서 작성할 수 있도록 학습)
  * 영리한 프로그래밍을 위한 알고리즘 강좌 (특히 Recursion)
  * LeetCode 문제풀기
  * 이래도 모르겠으면 알 때까지 링크된 미국쪽 사이트로 가서 계속 공부
* Codility 연습문제 풀이 집중 (읽기 자료부터 읽고)
* Youtube 문제 풀이 영상
* 시간복잡도 생각하며 문제 풀기 (for 중첩하는 순간 틀린 방법으로 취급 -> 다양한 자료구조 활용도 증가시키기)
* 안 풀려도 최소 1시간은 고민하기 (오답을 직접 해보면서 정답 깨닫기)
* 출퇴근길 혼자 타임어택 (약 30분씩) (집중력을 키워보자)
* 운도 필요하다.
  * 절대 평가인 회사도 있다.
  * 코테 본 직후, 문제 복기해서 다시 풀어보면서 실수한 부분들을 기록함.
  * 기술 면접에서 코드를 다시 보여주면서 문제점을 찾아보라는 질문을 받음.

## Book
- [x] 프로그래머의 길 멘토에게 묻다
- [ ] 커리어 스킬
- [ ] 객체지향의 사실과 오해
- [ ] 클린 코드(Clean code)
- [ ] 모던 자바스크립트 Deep Dive
- [x] 비전공자를 위한 이해할 수 있는 IT 지식
- [ ] 누워서 읽는 알고리즘
- [ ] 자바로 배우는 쉬운 자료구조

## site
- https://dololak.tistory.com/category/%EC%9E%90%EB%B0%94%5BJava%5D
- https://sso-feeling.tistory.com/
- https://javacan.tistory.com/entry/37
- https://st-lab.tistory.com/41
- https://devmoony.tistory.com/category/Programming/Java
- https://level.goorm.io/
- https://uxgjs.tistory.com/
- http://www.kocw.net/home/search/search.do?query=%EA%B0%9D%EC%B2%B4%20%EC%A7%80%ED%96%A5
- https://wikidocs.net/book/31
- https://leetcode.com/
- https://www.acmicpc.net/step
- https://velog.io/@josworks27/series/TILToday-I-Learned
- https://aws.amazon.com/ko/blogs/korea/what-happens-when-you-type-a-url-into-your-browser/
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
- 빅분기 준비
- http://dwarfintheflask.xyz/17

# TIL (Today I Learned)
- 정리중입니다~

## Java
> * 자바 가상 기계 (JVM / Java Virtual Machine) : 자바 프로그램은 완전한 기계어가 아닌 중간 단계의 바이트 코드이기 때문에, 이것을 해석하고 실행할 수 있게 해주는 가상의 운영체제
>   JVM의 메모리 영역
>   * 메소드 영역 : 클래스들을 클래스 로더로 읽어 클래스별로 런타임 상수 풀, 필드 데이터, 메소드 데이터, 메소드 코드, 생성자 코드 등을 분류해서 저장한다.
>   * 힙 영역 : 객체와 배열이 생성되는 영역. JVM 스택 영역에서 생성된 변수나 다른 객체의 필드에서 이 곳에 있는 객체와 배열을 참조한다.
>   * JVM 스택 영역 : 스레드마다 하나씩 존재. 스레드가 시작할 때마다 JVM 스택 영역이 할당된다.

> * 클래스 : 2. 필드 + 메소드 (여기서는 객체 생성은 문장으로 취급해 쓸 수 없다~)
> * new 인스턴스는 main에서 만들자~

> * process : 운영체제로부터 메모리를 할당받아 실행하는 애플리케이션의 코드

> * thread : 한 가지 작업을 실행하기 위해 순차적으로 실행할 코드를 실처럼 이어 놓았다고 해서 유래된 이름. 하나의 스레드는 하나의 코드 실행 흐름. 때문에 한 프로세스 내에 스레드가 두 개라면 두 개의 코드 실행 흐름이 생긴다는 의미.

> * 멀티 스레드는 동시성 또는 병렬성으로 실행된다.
>   * 동시성 (concurrency) : 멀티 작업을 위해 하나의 코어에서 멀티 스레드가 번갈아가며 실행하는 성질
>    * 병렬성 (parallelism) : 멀티 작업을 위해 멀티 코어에서 개별 스레드를 동시에 실행하는 성질

> * 스택 (stack) : 후입선출 (LIFO / Last In First Out) 자료구조. 나중에 넣은 객체가 먼저 빠져나간다.
> * 큐 (queue) : 선입선출 (FIFO / First In First Out) 자료구조. 먼저 넣은 객체가 먼저 빠져나간다.

> * 스트림 (stream) : 프로그램이 외부 파일, 외부 네트워크 등과 통신할 때 데이터가 흐르는 길. 이 때 외부란 같은 컴퓨터 내부라도 프로그램의 바깥에 별도로 존재 하는 것을 말한다.
> * 버퍼 (buffer) : 데이터를 한 곳에서 다른 한 곳으로 전송하는 동안 일시적으로 그 데이터를 보관하는 메모리의 영역
>   버퍼는 큐의 한 형태로, 요청된 자료는 버퍼에 도착한 순서대로 처리된다.

## Git
> * [markdown 기본 문법](/Git/markdownBasic.md)
> * 커밋(Commit) **신중하게** 의미있는것만! 설명 꼭 달아서!!
> * 커밋 히스토리 고치기 무~~~지하게 힘들다 

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

## Book
- [x] 혼자 공부하는 자바
- [x] Power JAVA
- [x] 프로그래머의 길 멘토에게 묻다
- [ ] 커리어 스킬
- [ ] 객체지향의 사실과 오해
- [ ] 클린 코드(Clean code)
- [ ] 모던 자바스크립트 Deep Dive
- [x] 비전공자를 위한 이해할 수 있는 IT 지식

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

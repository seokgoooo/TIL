<!-- Heading -->
1. 제목
# Heading 1
## Heading 2
### Heading 3
#### Heading 4
##### Heading 5
###### Heading 6
* html의 h1 ~ h6 태그와 비슷하다
#1은 밑줄이 자동으로 생긴다
<!-- Line -->
2. 밑줄
___
* _ 언더바 (언더스코어?) 3번 입력하면 줄이 생성된다.

<!-- Text attributes -->
3. 문자 꾸미기

This is the **bold** text and this is the *italic* text and let's do ~~strikethrough~~.

* ' * ' 별 1개로 감싸주면 italic (기울임) 표현
* ' * ' 별 2개로 감싸주면 bold (굵게) 표현
* ' ~~ ' 물결 2개로 감싸주면 strikethrough (줄긋기) 표현

<!-- Quote -->
4. 인용
> Don't forget.
* ' > ' 뒤에 글을 쓰면 quote (인용구) 로 사용.

<!-- Bullet list -->
5. 목록 (리스트)

Fruits:
* 사과
* 레몬

Other fruits:
- 복숭아
- 청사과

<!-- Numbered list -->
Numbers:
1. first
2. second
3. third


* ' * ' 별 + space
- ' - ' - + space
* 후에 글을 쓰면 목록으로 표현
* 1. 2. 3. 뒤에 쓰면 순서 목록 표현

<!-- Link -->
6. 링크

* [링크 설명]'( 링크 주소 )' 

Click [here](URL.link)

<!-- Image -->
7. 이미지 링크
* ' ![이미지 설명](이미지 링크) '

![image description](image.link)

<!-- Table -->
8. 표

|Header|Description|
|:--:|--:|
|Cell1|Cell2|
|Cell1|Cell2|
|Cell1|Cell2|
|Cell1|Cell2|

* ||| 세로바 3개 만 있으면 테이블 (표) 표현 가능
* 다음 줄에 |--|--| <-- 이렇게 써주고 : (콜론)으로 정렬 가능
* :--: 이렇게 감싸주면 가운데 정렬 :-- 왼쪽 정렬 --: 오른쪽 정렬 

<!-- Code -->
9. 코드

To print message in the console, use

`console.log('your message')` and ..

```java
console.log('your message')
```
* `(백틱) <-- ! 왼쪽에 있는 키 1개로 감싸주면 글과 같이 쓰면서 코드로 표현

* `(백틱) 3개로 감싸주면 코드블럭 형태로 표현

* 그 사이에 java, js, ts, kotlin 등 해당 언어를 써주면 그 언어의 문법에 맞게 알아서 보기 쉽게 변한다.

10. 체크박스
- [ ] 빈 체크박스
- [x] 체크된 체크박스
* [] 사이에 space 꼭 넣어주자 '[x]' x를 넣어주면 체크! 

Thanks for Dreamcoding
// 도서관리 프로그램
//
// 목록보기 
// 1. 가격순으로(오름차순, 내림차순 선택가능) - 제목, 가격만 표시
// 2. 분야를 선택해서 해당 분야만 보기 - 제목, 분야만
// 3. 상세보기
// 4. 도서 정보 수정
// 5. 도서 정보 추가

public class Main {
	public static void main(String[] args) {
		BookManage m = new BookManage();
		
		m.Start();
	}
}

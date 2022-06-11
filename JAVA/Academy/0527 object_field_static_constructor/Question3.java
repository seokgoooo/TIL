// 3번
// 영화
// 제목, 평점, 감독, 발표된 연도
// 모든 값을 콘솔 출력하는 기능

class Movie {
	String title;
	double score;
	String director;
	int year;
	void printAll() {
		System.out.println(title);
		System.out.println(score);
		System.out.println(director);
		System.out.println(year);
	}
	
	public Movie(String t, double s, String d, int p) {
		// 필드 초기화 << 주 목적
		title = t;
		score = s;
		director = d;
		year = p;
	}
}
public class Question3 {
	public static void main(String[] args) {
		// 생성자(constructor)
		// 기본 생성자
		// 기본값으로 초기화
		// 정수형 -> 0
		// 실수형 -> 0.0
		// 논리형 -> false
		// 참조형 -> null
		Movie m = new Movie("새영화", 7.5, "새감독", 2022);
		System.out.println(m.title);
		System.out.println(m.score);
		System.out.println(m.year);
		
		
		// Movie printMovie = new Movie();
		// printMovie.title = "기생충";
		// printMovie.score = 7.9;
		// printMovie.director = "봉준호";
		// printMovie.year = 2019;
		// printMovie.printAll();
	}
}
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
}
public class Question3 {
	public static void main(String[] args) {
		Movie printMovie = new Movie();
		printMovie.title = "기생충";
		printMovie.score = 7.9;
		printMovie.director = "봉준호";
		printMovie.year = 2019;
		printMovie.printAll();
	}
}
import java.util.Arrays;

//도서 관리 프로그램
//목록 보기 (가격순으로, 분야를 선택해서 해당 분야만)

//1. 이방인 / 알베르 카뮈/ 민음사/ 소설/ 9,000원
//2. 실천이성비판 / 임마누엘 칸트/ 아카넷/ 철학서 / 22,500 원
//3. 군주론 / 마키아벨리 / 까치 / 철학서 / 9,000 원
//4. 차라투스트라는 이렇게 말했다 / 프레드리히 니체 / 사색의 숲/ 철학서 / 21,600 원
//5. 노인과 바다/ 어니스트 헤밍웨이/ 민음사 / 소설 / 7,200 원
// 제목, 작가, 출판사, 분야, 가격
// 도서 관리 프로그램 목록 : 1전체 책 보기, 2가격순으로 보기, 3장르별로 보기, 4상세정보 

public class Books {
   private String title;
   private String author;
   private String pub;
   private String genre;
   private int price;

   public Books(String title, String author, String pub, String genre, int price) {
      this.title = title;
      this.author = author;
      this.pub = pub;
      this.genre = genre;
      this.price = price;
      
      
   }


   public String getTitle() {
      return title;
   }


   public void setTitle(String title) {
      this.title = title;
   }


   public String getAuthor() {
      return author;
   }


   public void setAuthor(String author) {
      this.author = author;
   }


   public String getPub() {
      return pub;
   }


   public void setPub(String pub) {
      this.pub = pub;
   }


   public String getGenre() {
      return genre;
   }


   public void setGenre(String genre) {
      this.genre = genre;
   }


   public int getPrice() {
      return price;
   }


   public void setPrice(int price) {
      this.price = price;
   }

   public void printPrice () {
      System.out.println();
   }

   public void printAll () {
      System.out.print(getTitle() + " / ");
      System.out.print(getAuthor() + " / ");
      System.out.print(getPub()+ " / ");
      System.out.print(getGenre()+ " / ");
      System.out.print(getPrice()+ " / " + "\n");
   }
   
   public void printName () {
      System.out.println(getTitle());
   }
   
   

}
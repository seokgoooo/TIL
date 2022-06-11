import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BookMain {

   public static void bookHtoL(Integer[] index, String sil, String zha, String pri, String str, String old) {
      Integer[] copy = new Integer[index.length];

      for (int i = 0; i < index.length; i++) {
         copy[i] = index[i];
      }
      for (int i = 0; i < copy.length; i++) {
         if (copy[i] == 22500) {
            System.out.println(sil + " " + copy[i]);
         } else if (copy[i] == 21600) {
            System.out.println(zha + " " + copy[i]);
         } else if (copy[i] == 9000) {
            System.out.println(pri + " " + copy[i]);
         } else if (copy[i] == 8800) {
            System.out.println(str + " " + copy[i]);
         } else if (copy[i] == 7200) {
            System.out.println(old + " " + copy[i]);
         }
      } 

   }
   
   public static void bookLtoH(int[] index, String sil, String zha, String pri, String str, String old) {
      int[] copy = new int[index.length];

      for (int i = 0; i < index.length; i++) {
         copy[i] = index[i];
      }
      for (int i = 0; i < copy.length; i++) {
         if (copy[i] == 22500) {
            System.out.println(sil + " " + copy[i]);
         } else if (copy[i] == 21600) {
            System.out.println(zha + " " + copy[i]);
         } else if (copy[i] == 9000) {
            System.out.println(pri + " " + copy[i]);
         } else if (copy[i] == 8800) {
            System.out.println(str + " " + copy[i]);
         } else if (copy[i] == 7200) {
            System.out.println(old + " " + copy[i]);
         }
      } 

   }

   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      Books[] books = new Books[5];
      books[0] = new Books("노인과 바다", "어니스트 헤밍웨이", "민음사", "소설", 7200);
      books[1] = new Books("실천이성비판", "임마누엘 칸트", "아카넷", "철학서", 22500);
      books[2] = new Books("군주론", "마키아벨리", "까치", "철학서", 9000);
      books[3] = new Books("차라투스트라는 이렇게 말했다", "프레드리히 니체", "사색의 숲", "철학서", 21600);
      books[4] = new Books("이방인", "알베르 카뮈", "열린 책들", "소설", 8800);
      Books old = books[0];
      Books sil = books[1];
      Books pri = books[2];
      Books zha = books[3];
      Books str = books[4];

      boolean y = true;
      while (y) {
         System.out.println("도서 관리 프로그램 입니다.\n 1 : 책 목록, 2 : 비싼 가격순, 3 : 싼 가격순,  4 : 책 분야, 5 : 상세정보, 6 : 프로그램 종료");

         int chart = s.nextInt();

         switch (chart) {
         case 1:
//        	 for (int i = 0; i < books.length; i++) {
//        	 }
        	 
            old.printName();
            sil.printName();
            pri.printName();
            zha.printName();
            str.printName();
            System.out.println();
            break;

         case 2:
            int a = old.getPrice();
            int b = sil.getPrice();
            int c = pri.getPrice();
            int d = zha.getPrice();
            int e = str.getPrice();
            Integer[] price = { a, b, c, d, e };
            Arrays.sort(price, Collections.reverseOrder());

            bookHtoL(price, sil.getTitle(), zha.getTitle(), pri.getTitle(), str.getTitle(), old.getTitle());
            System.out.println();
            break;

         case 3:
            int aa = old.getPrice();
            int bb = sil.getPrice();
            int cc = pri.getPrice();
            int dd = zha.getPrice();
            int ee = str.getPrice();
            int[] price2 = { aa, bb, cc, dd, ee };
            Arrays.sort(price2);
            bookLtoH(price2,sil.getTitle(), zha.getTitle(), pri.getTitle(), str.getTitle(), old.getTitle() );
            System.out.println();
            break;

         case 4:
            String p1 = old.getGenre();
            String p2 = sil.getGenre();
            String p3 = pri.getGenre();
            String p4 = zha.getGenre();
            String p5 = str.getGenre();
            String[] publisher = { p1, p2, p3, p4, p5 };
            System.out.println("철학서 : " + "[" + sil.getTitle() + "] , " + "[" + pri.getTitle() + "] , " + "["
                  + zha.getTitle() + "]");
            System.out.println("소설 : " + "[" + old.getTitle() + "] , " + "[" + str.getTitle() + "]");
            System.out.println();
            break;

         case 5:
            old.printAll();
            sil.printAll();
            pri.printAll();
            zha.printAll();
            str.printAll();
            System.out.println();
            break;

         case 6:
            System.out.println("프로그램을 종료합니다.");
            y = false;
         }

      }

   }
}
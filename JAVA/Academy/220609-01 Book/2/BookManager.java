package Bookc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//  <제목>   <저자>  <출판사> <장르> <가격>
//   가       가      가     공포    5
//    나        나       나      다큐    8
//    다        다      다     애니    1 
//   라         라      라     소설    3
//    마      마      마     시집     7
//

public class BookManager
{
    Scanner sc = new Scanner(System.in);
    Book[] books = new Book[100];
    String[] GenreSet = new String[100];
    List<String> used_Genre = new ArrayList<String>();

    int count = 1;
    
    public BookManager()
    {
        run();
    }

    public void run()
    {
    	int cnt = 1;
        while(true)
        {
           System.out.println("=====================목록=========================");
          System.out.println("| 1. 가격순으로 책 보기 (오름차순, 내림차순 선택가능)   |");
          System.out.println("| 2. 해당 장르별로  목록 보기                     |");
          System.out.println("| 3. 등록된 도서 상세보기            |");
          System.out.println("| 4. 도서 정보 수정               |");
          System.out.println("| 5. 도서 정보 추가               |");
          System.out.println("| 6. 종료                  |");
          System.out.println("=================================================");
           
          System.out.print(" 목록 번호 입력 하세요 : ");
          int number = 0;
          number = sc.nextInt();
      
          
          
          System.out.println();
          
          if(number == 1) {
             int choice = Integer.parseInt(getData("오름차순 : 1, 내림차순 : 2"));
             
             if(choice == 1) {
                RisingSort();
             }else if (choice == 2) {
                DescendingSort();
             }
             
             
          }
          
          else if(number == 2)
          {
              SelectGenre();
          }
          else if(number == 3)
          {
              selectBook();
             
          }
          else if(number == 4) {
             updateBook();
          
          }
          else if(number == 5) {
             registerBook();
             
          }
          else if(number == 6) {
             System.out.println("\n <도서 관리 프로그램을 종료합니다.>");
             break;
          }
          else {
             System.out.println("<범위에 없는 목록 번호를 입력하셨습니다.>");
             System.out.println("<다시 입력해주세요.>");
             
          
          }
          System.out.println("----------------------------------------------------------------------------프로그램" + cnt +"번 실행 완료");
          System.out.println();
          cnt++;
            
        }
    }
    
    public void SelectGenre() {
       
       for(int i = 0; i < count - 1; i++) {
          if(!used_Genre.contains(GenreSet[i])){
             used_Genre.add(GenreSet[i]);
             System.out.println("< " + GenreSet[i] + " >");
          
             for(int j = 0;  j< count - 1; j++) {
                if(books[j] != null && books[j].getGenre().equals(GenreSet[i])){
                   System.out.print(books[j].getTitle() + "  ");
                   System.out.println();
             }
          }
       }   
     }
   }
    public void DescendingSort() {
       int prices[] = new int[count-1];
       
       for(int i = 0; i <count-1; i++) {
          if(books[i] != null) {
             prices[i] = books[i].getPrice(); 
          }
       }
       
       Arrays.sort(prices); 
        System.out.println("제목\t저자\t출판사\t장르\t가격");
        for(int i = count -2; 0 <= i ; i--) {
           for(int j = count - 2; 0 <= j ; j--) {
              if(books[j].getPrice() == prices[i]) {
              System.out.println(books[j].PrintAll());
              }
           }
        }
       
    }
    
    public void RisingSort() {
       int prices[] = new int[count-1];
       
       for(int i = 0; i <count-1; i++) {
          if(books[i] != null) {
             prices[i] = books[i].getPrice(); //{5,34,2,1,8}
          }
       }
       
       Arrays.sort(prices); //{1,2,5,8,34}

       System.out.println("제목\t저자\t출판사\t장르\t가격");
       
       for(int i = 0; i < count - 1 ; i++) {
           for(int j  = 0; j< count - 1; j++) {
              if(books[j].getPrice() == prices[i]) {
                 System.out.println(books[j].PrintAll());
              }
           }
      
         }
    }
    
    public void registerBook()
    {
        System.out.println("몇 개의 책을 등록하시겠습니까? ");
        int register_cnt = sc.nextInt();
      
        
        for(int j = 0; j < register_cnt; j++) {
        String Title = getData("등록할 도서의 제목을 입력해주세요  :");
   
        String Author = getData("등록할 도서의 저자를 입력해주세요 : ");
        String Publisher = getData("등록할 도서의 출판사를 입력해주세요 : ");
        String Genre = getData("등록할 도서의 장르를 입력해주세요 : ");
        GenreSet[count-1] = Genre;
        int Price = Integer.parseInt(getData("등록할 도서의 가격 입력해주세요 : "));

        for(int i = 0; i < books.length; i++)
        {
            if(books[i] == null)
            {
               
                books[i] = new Book(Title, Author, Publisher, Genre, Price);
                System.out.println("=================================================" + count + "권 등록완료");
                System.out.println();
             count++;
                break;
            }
         
        }
      }
 
    }
    
    public void selectBook()
    {
        System.out.println("현재까지 등록된 도서목록");
        System.out.println("제목\t저자\t출판사\t장르\t가격");
       
        for(int i = 0; i < books.length; i++) {
           if(books[i] != null) {
           System.out.println(books[i].PrintAll());
           }
        }
    }
    
    public void updateBook()
    {
        System.out.print("수정할 도서의 제목을 입력하세요. : ");
        String bookTitle = sc.next(); 
        
        Book b = findBook(bookTitle);
        if(b == null)
        {
            System.out.println("입력하신 책이 존재하지 않습니다.");
            return;
        }
        
        int selectNum = 0;
        
        while(true) 
        {
            System.out.println("============================================================================");
            System.out.println("| 1. 제목 수정 | 2. 저자수정 | 3. 출판사 수정 | 4. 장르 수정 | 5. 가격 수정 | 6. 수정 완료 |");
            System.out.println("============================================================================");
            System.out.println("번호 입력 : ");
            selectNum = sc.nextInt();
            
           if(selectNum == 1){
              System.out.println("제목을 수정해주세요 : ");
              String Title = sc.next();          
                b.setTitle(Title);
                System.out.println("제목 수정 완료 ");
            }
           
           else if(selectNum == 2){
              System.out.println("저자를 수정해주세요 : ");
              String Author = sc.next();          
               b.setAuthor(Author);
               System.out.println("저자 수정 완료 ");
           } 
           
           else if(selectNum == 3){
              System.out.println("출판사를 수정해주세요 : ");
              String Publisher = sc.next();          
               b.setPublisher(Publisher);
               System.out.println("출판사 수정 완료 ");
           } 
           else if(selectNum == 4){
              System.out.println("장르를 수정해주세요 : ");
              String Genre = sc.next();          
               b.setGenre(Genre);
               
               System.out.println("장르 수정 완료 ");
           } 
           
           else if(selectNum == 5){
              System.out.println("가격을 수정해주세요 : ");
              int Price = sc.nextInt();          
               b.setPrice(Price);
               System.out.println("가격 수정 완료 ");
           } 
           else if(selectNum == 6) {
              System.out.println("수정 종료");
              break;
           }
            }
        }
    
    

    

    
    public Book findBook(String bookTitle)
    {
        for(int i = 0; i< books.length; i++)
        {
            if(books[i] != null && books[i].getTitle().equals(bookTitle))
            {
                return books[i];
            }
        }
        
        return null;
    }
    
    String getData(String message)
    {
        System.out.println(message);
        return sc.next();
    }
    

    
    public static void main(String[] args)
    {
        new BookManager();
    
    }
}
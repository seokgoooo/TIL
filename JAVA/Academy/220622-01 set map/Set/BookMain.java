package Set;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

class Book implements Comparable<Book>{
	private String title;
	private int price;

	public Book(String title, int price) {
		super();
		this.title = title;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + "]";
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + price;
//		result = prime * result + ((title == null) ? 0 : title.hashCode());
//		return result;
//	}
	
	@Override
	public int hashCode() {
		// Objects.hash : 필드값을 넣어주면 객체끼리 같은 값이면 같은 숫자가 나오고 다르면 다른 숫자가 나와서 구별이 가능하다.
		return Objects.hash(title, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Book))
			return false;
		Book other = (Book) obj;
		if (price != other.price)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public int compareTo(Book o) {
		return title.compareTo(o.title);
	}
}

public class BookMain {
	public static void main(String[] args) {
		Book b1 = new Book("책1", 5000);
		Book b2 = new Book("책1", 5000);
		Book b3 = new Book("책2", 7000);
		Book b4 = new Book("책3", 4000);

		System.out.println(b1.equals(b2));
		System.out.println(b1.equals(b3));
		
		Set<Book> set = new HashSet<>();
		set.add(b1);
		set.add(b2);
		set.add(b3);
		System.out.println(set.size());
		System.out.println(set);
		
//		hash 값은 무작위이기 때문에 바로 add하면 대소비교를 할수가 없어서 TreeSet에 넣을수가 없다.
//		객체의 필드에서 기준을 잡아주면 대소비교가 가능하기 때문에 Comparable 구현해서 compareTo 메소드에서 기준을 잡아주자 
		Set<Book> setTree = new TreeSet<>();
		setTree.add(b1);
		setTree.add(b2);
		setTree.add(b3);
		setTree.add(b4);
		System.out.println(setTree);
		
		Comparator<Book> com = new Comparator<Book>() {
			@Override
			public int compare(Book o1, Book o2) {
				return o1.getPrice() - o2.getPrice();
			}
		};
		
//		Set에서 Comparator 활용할 때는 Set 생성자에 만들어놓은 기준을 넣어주자.
		Set<Book> treeByPrice = new TreeSet<>(com);
		treeByPrice.add(b1);
		treeByPrice.add(b2);
		treeByPrice.add(b3);
		treeByPrice.add(b4);
		
		System.out.println(treeByPrice);
		

	}
}

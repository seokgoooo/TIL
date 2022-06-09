import java.util.Scanner;

public class BookData {
	private String name;
	private String author;
	private String publisher;
	private String group;
	private int price;
	public int compareValue;
	
	public BookData() {

	}

	public BookData(String name, String author, String publisher, String group, int price) {
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.group = group;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void printMainView() {
		System.out.println("*** 도서 관리 프로그램 ***");
		System.out.println("--------------------");
		System.out.println("0. 종료");
		System.out.println("1. 가격순 (오름차순)");
		System.out.println("2. 가격순 (내림차순)");
		System.out.println("3. 분야별");
	}
	
	public void exit() {
		System.out.println("프로그램 종료");
	}

	public void printCostAscendingOrder() {
	
	}

	public void printCostDescendingOrder() {

	}

	public void choiceGroup(int inputGroupNumber) {
		
	}

	public void detailList() {

	}

	public void bookDataChange() {

	}

	public void bookDataAdd() {

	}
}
package fourletters;

import java.util.List;

public class fourletters {
	int number;
	String question;
	String awnser;
	String hint;
	String id;

	public fourletters(int number, String question, String awnser, String hint) {
		super();
		this.number = number;
		this.question = question;
		this.awnser = awnser;
		this.hint = hint;
	}
	
	public fourletters(String id, int number) {
		super();
		this.id = id;
		this.number = number;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public fourletters(int number) {
		super();
		this.number = number;
	}

	public fourletters(String question) {
		super();
		this.question = question;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAwnser() {
		return awnser;
	}

	public void setAwnser(String awnser) {
		this.awnser = awnser;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}
	
	@Override
	public String toString() {
		return number + ", 문제=" + question + ", 정답=" + awnser + ", 힌트=" + hint
				+ "\n";

	}
	
	public String toString2() {
		return number + "," + question + "," +  awnser + "," + hint;
	}

	public int toNumber() {
		return number;
		
	}
	public String toQuestion() {
		return question;

	}
	public String toAwnser() {
		return awnser;
	}
	
	public String toHint() {
		return hint;
	}
	public String ManagerToString() {
		return question + "," + awnser + "," + hint ;
	}
}

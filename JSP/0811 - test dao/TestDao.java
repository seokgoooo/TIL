import java.util.List;

import hello.Persons;
import hello.PersonsDAO;

// WEB에서 바로 테스트해도 되지만 환경 제약이 많고 테스트할 때 마다 WEB에 바로바로 반영이 되기 때문에
// Java만 따로 떼서 테스트를 하고 싶다.
// 왜 Why 가능한가?? 객체로 만들어 놓아서 환경에 구애 받지 않고 어디서든 테스트 && 유지보수 하기 편해진다.
// 코드 테스트도구 사용할때도 코드가 똑같이 들어가서 이런 방식으로 하면 좋다.
// 그러면 Java 프로젝트를 만들어서 DAO를 테스트 해보자

public class TestDao {
	public static void main(String[] args) {
		PersonsDAO dao = new PersonsDAO();
		List<Persons> list = null;

		try {
			list = dao.getPersons();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list);
	}
}

// 입력값 유효성 검사 필요
// DB로 보고 다 써보자
// 모든 값은 필수로 들어가야함
// 이름, 성 10자
// 나이 정수
// 이메일 고유 50자

// 예외 생길때 (잘못된 값일 때 사용자에게 보여줄 것)
package hello;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 한글 깨지는 문제 - 인코딩 설정을 해주자
		req.setCharacterEncoding("utf-8");

		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String age = req.getParameter("age");
		String mail = req.getParameter("mail");

		PersonsValidator validator = new PersonsValidator();
		Map<String, String> errors = new HashMap<String, String>();
		errors.putAll(validator.isValidName(firstName));
		errors.putAll(validator.isValidName(lastName));
		errors.putAll(validator.isValidAge(age));
		errors.putAll(validator.isValidEmail(mail));

		if (errors.size() > 0) {
			req.setAttribute("errors", errors);
			req.getRequestDispatcher("insert.jsp").forward(req, resp);
		} else {

//		이렇게 Map 4개가 나오면 또 복잡하기 때문에 하나의 Map을 만들어서 다 집어넣어버리자.
//		Map<String, String> firstNameError = validator.isValidName(firstName);
//		Map<String, String> lastNameError = validator.isValidName(lastName);
//		Map<String, String> ageError = validator.isValidAge(age);
//		Map<String, String> mailError = validator.isValidEmail(mail);

			PersonsDAO dao = new PersonsDAO();
			List<Persons> list = null;

			try {
				list = dao.setInsertPersons(firstName, lastName, Integer.valueOf(age), mail);
			} catch (Exception e) {
				e.printStackTrace();
			}

			req.setAttribute("list", list);
			resp.sendRedirect("./view");
//		req.getContextPath를 이용하면 index.html로 간다
//		resp.sendRedirect(req.getContextPath());
		}
	}
}
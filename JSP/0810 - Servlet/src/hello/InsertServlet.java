package hello;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		int age = Integer.parseInt(req.getParameter("age"));
		String mail = req.getParameter("mail");

		PersonsDAO dao = new PersonsDAO();
		List<Persons> list = null;

		try {
			list = dao.setInsertPersons(firstName, lastName, age, mail);
		} catch (Exception e) {
			e.printStackTrace();
		}

		req.setAttribute("list", list);
		resp.sendRedirect("./view");
//		req.getContextPath를 이용하면 index.html로 간다
//		resp.sendRedirect(req.getContextPath());
	}
}
package hello;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PersonsDAO dao = new PersonsDAO();
		List<Persons> list = null;

		try {
			list = dao.getPersons();
		} catch (Exception e) {
			e.printStackTrace();
		}

		req.setAttribute("list", list);
		req.getRequestDispatcher("./view.jsp").forward(req, resp);
	}
}
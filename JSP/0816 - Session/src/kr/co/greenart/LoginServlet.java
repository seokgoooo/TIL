package kr.co.greenart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Loginservice")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		if (password != null && password.equals("qwer")) {
			// 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("loginid", id);
		} else {
			// 로그인 실패
		}

		request.getRequestDispatcher("./Loginresult.jsp").forward(request, response);
	}
}
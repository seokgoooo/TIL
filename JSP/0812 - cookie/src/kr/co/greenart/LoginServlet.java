package kr.co.greenart;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/idremember.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String rememberme = request.getParameter("rememberme");

		if (password.equals("1234")) {
			// 로그인 성공
			// 쿠키(아이디)를 담은 성공 메시지 응답
			if (rememberme != null && rememberme.equals("on")) {
				Cookie c = new Cookie("rememberme", URLEncoder.encode(id, "utf-8"));
				c.setMaxAge(60 * 60 * 24);
				response.addCookie(c);

				Cookie c2 = new Cookie("login", URLEncoder.encode(id, "utf-8"));
				c2.setMaxAge(60 * 60 * 24);
				response.addCookie(c2);
			}
			request.getRequestDispatcher("ok.jsp").forward(request, response);
		} else {
			// 실패
		}
	}
}
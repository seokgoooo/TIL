package kr.co.greenart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editcookie")
public class EditCookieServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie c = new Cookie("yourname", "edit");
		response.addCookie(c);

//		cookie는 기간이 만료될 때 삭제가 된다.
		Cookie c2 = new Cookie("korname", "");
//		setMaxAge는 second 단위로 설정한다. 0은 바로 삭제
		c2.setMaxAge(0);
		response.addCookie(c2);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
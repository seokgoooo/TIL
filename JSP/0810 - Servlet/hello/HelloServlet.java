package hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
//	필드를 가지면 사용자가 요청할 때 마다 값이 계속 바뀌기 때문에 Servlet은 필드가 없어야 한다.
	public HelloServlet() {
		super();
		System.out.println("헬로 서블릿 생성자는 언제 호출되나요?");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		pw.println(req.getRequestURI());
		pw.flush();
	}
}
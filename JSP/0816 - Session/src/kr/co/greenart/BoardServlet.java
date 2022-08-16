package kr.co.greenart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("사용자가 GET방식의 요청을 하였습니다. (게시판 목록)");

		System.out.println("로그인 확인되었습니다. 게시판 목록으로 forward합니다.");
		List<String> articles = new ArrayList<String>(Arrays.asList("글1", "글2", "글3"));
		request.setAttribute("articles", articles);

		request.getRequestDispatcher("/WEB-INF/articles.jsp").forward(request, response);
	}
}
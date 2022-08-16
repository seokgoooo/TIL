package kr.co.greenart;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// LoginFilter : 바로 servlet으로 가지 않고 filter를 거쳐서 가는 흐름으로 만들어준다(xml 사용해서 or annotation 사용)
// 왜??? why??? LoginFilter 로직을 여러번 사용할 일이 있을 때 Servlet마다 써주는 것이 아니라 
// 하나의 Filter 로직(기능)을 하는 Filter 클래스를 만들어서 확인할 페이지가 있을 때 마다 mapping만 추가 시켜주면 된다.
// 그러면 Servlet에는 해당 Servlet 로직만 적어주면 된다. (매 Servlet 마다 Filter 로직을 써줄 필요가 없음)
// Filter는 한 페이지에 여러 개 설정이 가능하다. (/*)
// 순서를 정해주려면 web.xml에 먼저 쓴 순서대로 필터가 실행되고
// @annotation 에 써주면 순서 설정이 불가능하다.
public class LoginFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 서블릿이 요청 객체를 다루기 전
		System.out.println("doFilter 전!");

		System.out.println("세션 값을 확인합니다.");
		HttpSession session = ((HttpServletRequest) request).getSession();
		Object loginId = session.getAttribute("loginid");

		// 원래 흐름
		if (loginId != null) {
			chain.doFilter(request, response);
		} else {
			System.out.println("로그인 되지 않은 유저.");
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
//		sendError로 밑의 2줄을 대신함.
//		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//		request.getRequestDispatcher("needlogin.jsp").forward(request, response);
		}

		// 서블릿이 요청을 처리하고 응답 보내기 전
		System.out.println("doFilter 후!");
	}
}
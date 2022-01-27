package co.micol.jsptest;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.jsptest.command.ACommand;
import co.micol.jsptest.common.Command;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		// 최초 한번만 실행시킴!
		// 초기값 등록
		map.put("/a.do", new ACommand());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 실제요청을 처리하는 곳
		request.setCharacterEncoding("utf-8"); // 한글깨짐 방지
		String uri = request.getRequestURI(); // uri값을 구함
		String contextPath = request.getContextPath(); // 루트 경로를 구함.
		String page = uri.substring(contextPath.length()); // 실제 요청한 페이지를 구함

		Command command = map.get(page); // 요청을 map에서 찾아온다.
		String viewPage = command.run(request, response); // 요청을 처리하는 command 호출

		if (viewPage != null && viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views" + ".jsp";
		}
		
	}
}
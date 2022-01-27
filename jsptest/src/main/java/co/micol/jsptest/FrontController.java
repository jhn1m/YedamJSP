package co.micol.jsptest;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.jsptest.command.ACommand;
import co.micol.jsptest.command.BCommand;
import co.micol.jsptest.command.MemberJoin;
import co.micol.jsptest.command.MemberJoinForm;
import co.micol.jsptest.command.MemberList;
import co.micol.jsptest.command.MemberLogin;
import co.micol.jsptest.command.MemberLoginForm;
import co.micol.jsptest.command.memberSearch;
import co.micol.jsptest.common.Command;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		// 초기값 등록
		map.put("/a.do", new ACommand()); // a.do로 요청
		map.put("/b.do", new BCommand()); // b.do로 요청

		map.put("/memberList.do", new MemberList()); // 멤버목록
		map.put("/memberSearch.do", new memberSearch()); // 멤버조회
		map.put("/memberLoginForm.do", new MemberLoginForm()); // 로그인 폼 호출
		map.put("/memberLogin.do", new MemberLogin());

		map.put("/memberJoin.do", new MemberJoin());
		map.put("/memberJoinForm.do", new MemberJoinForm());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 실제요청을 처리하는곳
		request.setCharacterEncoding("utf-8"); // 한글 깨짐 방지를 위해
		String uri = request.getRequestURI(); // URI 값을 구함
		String contextPath = request.getContextPath(); // 루트를 구함(컨텍스패스)
		String page = uri.substring(contextPath.length()); // 실제 요청한 페이지를 구함

		Command command = map.get(page); // 요청을 map에서 찾아온다.
		String viewPage = command.run(request, response); // 요청을 처리하는 command 호출

		if (viewPage != null && !viewPage.endsWith(".do")) { // 서버에서 접근하기위한 viewResolve
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); // 서버에서 접근하여 브라우저로 결과 돌림
		dispatcher.forward(request, response);
	}

}
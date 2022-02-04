package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.command.Login;
import co.micol.prj.command.LoginForm;
import co.micol.prj.command.Logout;
import co.micol.prj.command.MainCommand;
import co.micol.prj.command.NoticeList;
import co.micol.prj.command.NoticeSelect;
import co.micol.prj.command.NoticeWrite;
import co.micol.prj.command.NoticeWriteForm;
import co.micol.prj.common.Command;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		// 명령그룹
		map.put("/main.do", new MainCommand()); // 홈페이지
		map.put("/loginForm.do", new LoginForm()); // 로그인 페이지 이동
		map.put("/login.do", new Login()); // 로그인 기능
		map.put("/logout.do", new Logout()); // 로그아웃 기능
		map.put("/noticeList.do", new NoticeList()); // 공지사항 목록
		map.put("/noticeSelect.do", new NoticeSelect()); // 공지사항 세부내용
		map.put("/noticeWriteForm.do", new NoticeWriteForm()); // 공지사항 글쓰기 form으로 이동
		map.put("/noticeWrite.do", new NoticeWrite()); // 공지사항 글쓰기 실행
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 서비스 요청분석 및 실행
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());

		Command command = map.get(page); // 요청에 따른 적정ㄹ한 수행명령을 찾음
		String viewPage = command.exec(request, response);

		
		// viewResolve 역할
		// tiles를 붙여주면 web.xml으로 이동한다
		if (viewPage != null && !viewPage.endsWith(".do")) {
			viewPage = viewPage + ".tiles";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}

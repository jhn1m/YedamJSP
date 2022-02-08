package co.micol.prj.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.command.IdCheck;
import co.micol.prj.command.LoginCommand;
import co.micol.prj.command.LoginForm;
import co.micol.prj.command.LogoutCommand;
import co.micol.prj.command.MainCommand;
import co.micol.prj.command.RegisterForm;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map;

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		map = new HashMap<String, Command>(); // map 초기화
		map.put("/main.do", new MainCommand()); // 메인 페이지
		map.put("/loginForm.do", new LoginForm()); // 로그인 폼 호출
		map.put("/registerForm.do", new RegisterForm()); // 회원가입 폼 호출
		map.put("/login.do", new LoginCommand()); // 로그인
		map.put("/logout.do", new LogoutCommand()); // 로그아웃
		map.put("/idCheck.do", new IdCheck()); // 아이디 중복체크
	}

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String page = uri.substring(contextPath.length());

		Command command = map.get(page);
		String viewPage = command.exec(req, resp);

		if (!viewPage.endsWith(".do")) {
			if (viewPage.startsWith("ajax:")) {
				// ajax 처리
				PrintWriter out = resp.getWriter();
				out.print(viewPage.substring(5));
				return;
			} else {
				viewPage = viewPage + ".tiles";
			}
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
		dispatcher.forward(req, resp);
	}

}

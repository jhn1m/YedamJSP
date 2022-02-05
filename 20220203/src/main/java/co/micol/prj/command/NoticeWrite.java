package co.micol.prj.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.serviceImpl.NoticeServiceImpl;
import co.micol.prj.notice.vo.NoticeVO;

public class NoticeWrite implements Command {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// 공지사항 글등록
		NoticeService noticeDAO = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();
		vo.setNoticeTitle(req.getParameter("noticeTitle"));
		vo.setNoticeWriter(req.getParameter("noticeWriter"));
		vo.setNoticeSubject(req.getParameter("noticeSubject"));
		//if(req.getParameter("noticeDate") != null) {
		vo.setNoticeDate(Date.valueOf(req.getParameter("noticeDate")));
		//}
		String viewPage = null; // 돌려줄 페이지 변수

		int n = noticeDAO.noticeInsert(vo);
		if (n != 0) {
			viewPage = "noticeList.do";
		} else {
			req.setAttribute("message", "등록이 실패했습니다.");
			viewPage = "notice/noticeError";
		}
		return viewPage;
	}

}

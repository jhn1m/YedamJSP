package co.micol.prj.notice.service;

import java.util.List;

import co.micol.prj.notice.vo.NoticeVO;

public interface NoticeService {
	List<NoticeVO> noticeSelectList();

	NoticeVO noticeSelect(NoticeVO vo); // 한개의 게시글 가져오기

	int noticeInsert(NoticeVO vo);

	int noticeDelete(NoticeVO vo);

	int noticeUpdate(NoticeVO vo);

	void noticeHitUpdate(int id); // 조회수 증가

	List<NoticeVO> noticeSearch(String key, String str); // 검색기능, 검색할 필드와 데이터를 전달받음
	
}
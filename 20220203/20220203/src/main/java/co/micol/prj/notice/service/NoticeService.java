package co.micol.prj.notice.service;

import java.util.List;

import co.micol.prj.notice.vo.NoticeVO;

public interface NoticeService {
	public List<NoticeVO> noticeList();
	public NoticeVO noticeSelect(NoticeVO vo);
	public int noticeInsert(NoticeVO vo);
	public int noticeDelete(NoticeVO vo);
	public int noticeUpdate(NoticeVO vo);
	
	public void noticeHitUpdate(int id); // 조회수 증가
	public List<NoticeVO> noticeSearch(String key, String str); // 검색할 필드와 데이터를 전달받아 검색
}

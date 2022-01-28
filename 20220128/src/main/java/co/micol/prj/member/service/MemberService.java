package co.micol.prj.member.service;

import java.util.List;

import co.micol.prj.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList();

	MemberVO memberSelect(MemberVO vo); // 한명 조회 R
	int memberInsert(MemberVO vo); // 삽입 C
	int memberDelete(MemberVO vo); // 삭제 D
	int memberUpdate(MemberVO vo); // 변경 U

	boolean isIdCheck(String id); // 아이디 중복체크
}

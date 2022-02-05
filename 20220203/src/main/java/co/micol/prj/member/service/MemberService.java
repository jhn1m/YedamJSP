package co.micol.prj.member.service;

import java.util.List;

import co.micol.prj.member.vo.MemberVO;

public interface MemberService {
	public List<MemberVO> memberList();
	public MemberVO memberSelect(MemberVO vo);
	public int insertMember(MemberVO vo);
	public int updateMember(MemberVO vo);
	public int deleteMember(MemberVO vo);
	
	public boolean isIdcheck(String id); // 아이디 중복 체크
}
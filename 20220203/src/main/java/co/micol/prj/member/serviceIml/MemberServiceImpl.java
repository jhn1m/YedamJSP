package co.micol.prj.member.serviceIml;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.prj.common.DataSource;
import co.micol.prj.member.service.MemberMapper;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private MemberMapper map = sqlSession.getMapper(MemberMapper.class);
	
	@Override
	public List<MemberVO> memberList() {
		return map.memberList();
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		return map.memberSelect(vo);
	}

	@Override
	public int insertMember(MemberVO vo) {
		return map.insertMember(vo);
	}

	@Override
	public int updateMember(MemberVO vo) {
		return map.updateMember(vo);
	}

	@Override
	public int deleteMember(MemberVO vo) {
		return map.deleteMember(vo);
	}

	@Override
	public boolean isIdcheck(String id) {
		return map.isIdcheck(id);
	}

}

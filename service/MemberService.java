package CbtProject.service;

import java.sql.SQLException;
import java.util.List;

import CbtProject.dao.MemberDAO;
import CbtProject.vo.MemberVO;

public class MemberService {
	MemberService() {}
	private static MemberService instance;
	public static MemberService getInstance() {
		if(instance == null) {
			instance = new MemberService();
		}
		return instance;
	}
	
    private MemberDAO memberdao= MemberDAO.getInstance();
    
    public List<MemberVO> loginMember(MemberVO loginInfo) throws SQLException {
    	return memberdao.loginMember(loginInfo);
    }
    
	public int joinMember(MemberVO joinInfo) throws SQLException {
		return memberdao.joinMember(joinInfo);
	}
	public int loginId(String searchID) throws SQLException {
		return memberdao.loginId(searchID);
	}
	public MemberVO loginStart(String memId, String memPw) throws SQLException {
		return memberdao.loginStart(memId, memPw);
	}
	
	public int updateMember(MemberVO vo)throws SQLException {
		return memberdao.updateMember(vo);
	}
}

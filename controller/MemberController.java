package CbtProject.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import CbtProject.MemberApplication;
import CbtProject.service.MemberService;
import CbtProject.view.MemberView;
import CbtProject.vo.MemberVO;

import java.util.Scanner;

public class MemberController {

	MemberController() {}
	private static MemberController instance;
	public static MemberController getInstance() {
		if (instance == null) {
			instance = new MemberController();
		}
		return instance;
	}

	private static MemberService memberservice = MemberService.getInstance();
	private static MemberView memberview = MemberView.getInstance();

	public MemberVO loginMember(Scanner scanner) throws SQLException  {
		MemberVO ifo = memberview.loginIfo(scanner);

		MemberVO vo = memberservice.loginStart(ifo.getMemId(), ifo.getMemPw());
		MemberApplication.setSession(vo);
		memberview.loginId(vo);
		return vo;
	}

	public void joinMember(Scanner scanner) throws SQLException {

		while (true) {
			MemberVO joinInfo = memberview.joinInfo(scanner); // 스캐너 사용자 입력
			String joinId = joinInfo.getMemId(); // 입력 id 필드 받아오기
			int member = memberservice.loginId(joinId); // 받
			memberview.joinResult(member);

			if (member > 0) {
				continue;
			}

			memberservice.joinMember(joinInfo); // 값 쿼리
			break;
		}
	}

	public static void updateMember(Scanner scanner) throws SQLException {
		MemberVO vo = memberview.updateMember(scanner);
		int member = memberservice.updateMember(vo);
		memberview.updateResult(member);
	}
}

package CbtProject;

import CbtProject.vo.MemberVO;

public class MemberApplication {

	private static MemberVO session = new MemberVO();
	public static MemberVO getSession() {
		return session;
	}
	public static void setSession(MemberVO session) {
		MemberApplication.session = session;
	}

	public static void main(String[] args) throws Exception {
		MemberFrontController frontController = new MemberFrontController();
		frontController.process();
	}
}

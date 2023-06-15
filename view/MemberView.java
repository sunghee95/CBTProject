package CbtProject.view;

import java.sql.SQLException;
import java.util.Scanner;

import CbtProject.MemberApplication;
import CbtProject.MemberFrontController;
import CbtProject.controller.MemberController;
import CbtProject.vo.MemberVO;

public class MemberView {
	
	MemberView() {}
	private static MemberView instance;
	public static MemberView getInstance() {
		if(instance == null) {
			instance = new MemberView();
		}
		return instance;
	}
	
	public MemberVO joinInfo(Scanner scanner) {
		System.out.println("");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━👨회원가입👩━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("");
		System.out.print("📌ID를 입력하세요 ▶ ");
		String id = scanner.nextLine();

		System.out.print("📌PW를 입력하세요 ▶ ");
		String pw = scanner.nextLine();
		System.out.print("📌이름을 입력하세요 ▶ ");
		String name = scanner.nextLine();
		System.out.print("📌메일을 입력하세요  ▶ ");
		String mail = scanner.nextLine();
		MemberVO vo = new MemberVO(id, pw, name, mail);
		return vo;
	}

	public void joinResult(int count) {
		if (count > 0) {
			System.out.println("🙅‍♀️중복된 ID입니다🙅‍♀️  ");
		} else
			System.out.println("🙆‍♂️회원가입 완료🙆‍♂️ ");
	}

	public MemberVO loginIfo(Scanner scanner) {
		System.out.println("");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━🔒로그인🔓━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.print("🔍ID : ");
		String putId = scanner.nextLine();
		System.out.print("🔍PW : ");
		String putPw = scanner.nextLine();
		return new MemberVO(putId,putPw);
		
	}

	public void loginId(MemberVO vo) {
		if (vo != null) {
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("😀로그인되었습니다.");
			System.out.println("");
			
			
		} else {
			System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
			System.out.println("😔로그인에 실패하였습니다. 다시 시도해주세요.");
			
		}
	}
	
	
	//회원정보 조회
	
	public void memberInfo(MemberVO vo) throws SQLException {
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━👀마이페이지👀━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println("📌회원ID :" + vo.getMemId());
		System.out.println("📌회원이름 :" + vo.getMemName());
		System.out.println("📌회원 Mail :" + vo.getMemMail());
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println(" 1.정보변경 ┃ 2.뒤로가기");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		 switch(num) {
	       case 1 : 
	          MemberController.updateMember(scanner);
	       case 2 :
	          break;
	       }
	     
	    }

	//회원정보 수정
	 public MemberVO updateMember(Scanner scanner) {
	       System.out.println("📌변경할 항목 선택 ▶ ");
	       System.out.println("1.패스워드 변경 ┃ 2. 메일주소 변경");
	       String newPw =null;
	       String newMail = null;
	       String newId =null ;
	       int selectNum = scanner.nextInt();
	       Scanner scanner2 = new Scanner(System.in);
	      if(selectNum==1) {
	    	  System.out.println("");
	          System.out.print("📌변경할 패스워드를 입력하세요 \n ▶ ");
	          newPw = scanner2.nextLine();
	          newMail = MemberApplication.getSession().getMemMail();
	          newId = MemberApplication.getSession().getMemId();
	      }else if (selectNum == 2){
	    	  System.out.println("");
	          System.out.print("📌변경할 메일 주소를 입력해주세요 \n ▶ ");
	         newMail = scanner2.nextLine();
	         newPw = MemberApplication.getSession().getMemPw();
	         newId = MemberApplication.getSession().getMemId();
	       } else {
	    	   System.out.println("");
	    	   System.out.println("🙅‍♀️잘못된 선택입니다🙅‍♀️");
	       }
	      return new MemberVO(newId,newPw, newMail); 
	    }
	 
	 public void updateResult(int member) {
			if (member > 0) {
				System.out.println("");
				System.out.println("📌변경되었습니다.");
				System.out.println("");
			} else {
				System.out.println("");
				System.out.println("📌변경에 실패하였습니다. 다시 시도해주세요");	
				System.out.println("");
			}

}}

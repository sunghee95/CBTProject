package CbtProject;

import java.sql.SQLException;
import java.util.Scanner;

import CbtProject.controller.*;
import CbtProject.view.*;
import CbtProject.vo.MemberVO;

public class MemberFrontController {

	private static CbtController cbtcontroller = CbtController.getinstance();
	private MemberController memberController = MemberController.getInstance();
	private BoardController boardcontroller = BoardController.getInstance();
	private MemberView memberView = MemberView.getInstance();
	private Scanner scanner = new Scanner(System.in);

	public void process() {
		System.out.println(" ");
		while (true) {
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("         💾 정 보 처 리 기 사 C B T 프 로 그 램  💾         ");
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("      1.로그인    ┃    2.회원가입    ┃    0.프로그램 종료   ");
			System.out.println();
			System.out.print("📌 메뉴 선택  ▶ ");

			try {
				int selectMenu = Integer.parseInt(scanner.nextLine());
				switch (selectMenu) {
				case 1:
					try {
						MemberVO vo = memberController.loginMember(scanner);
						if (vo != null) {
							cbtMain();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;

				case 2:
					try {
						memberController.joinMember(scanner);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;

				case 0:
					System.out.println("📌프로그램을 종료합니다👋");
					System.exit(0);
					break;

				default:
					System.out.println("🙅‍♀️번호를 다시 입력해주세요🙅‍♀️ ");
					System.out.println();
					break;

				}
			} catch (NumberFormatException e) {
				System.out.println("🙅‍♀️숫자를 입력해주세요!!!!!!!🙅‍♀️");
				System.out.println();
			}

		}
	}

	public void cbtMain() throws Exception {
		Scanner scanner = new Scanner(System.in);
		boolean go = true;
		while (go) {
			System.out.println("");
			System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━ Main Menu ━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("");
			System.out.println("                        1.문제풀기📝                       ");
			System.out.println("");
			System.out.println("                        2.응시결과💯                       ");
			System.out.println("");
			System.out.println("                        3.질문게시판🤷                     ");
			System.out.println("");
			System.out.println("                        4.회원정보🙍‍♂                       ");
			System.out.println("");
			System.out.println("                        5.로그아웃🔓                       ");
			System.out.println("");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━👨🏼‍🤝‍👨🏻B4👭━┛");
			System.out.println("");
			System.out.print("📌메뉴선택 ▶ ");
			System.out.println("");
			try {
				int num = Integer.parseInt(scanner.nextLine());
				switch (num) {
				case 1:
					cbtcontroller.question(scanner);
					break;
				case 2:
					cbtcontroller.selectExamResult();
					break;
				case 3:
					boardcontroller.process();
					break;
				case 4:
					memberView.memberInfo(MemberApplication.getSession());
					break;
				case 5:
					go = false;
					break;
				default:
					System.out.print("🙅‍♀️번호를 다시 입력해주세요🙅‍♀️ ");
					System.out.println();

				}
			} catch (NumberFormatException e) {
				System.out.println("🙅‍♀️숫자를 입력해주세요!!!!!!!🙅‍♀️ ");
				System.out.println("");
			}

		}
	}
}

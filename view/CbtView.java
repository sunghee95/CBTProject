package CbtProject.view;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import CbtProject.vo.CbtVO;



public class CbtView {
	
	private static CbtView instance;
	public static CbtView getinstance() {
		if(instance == null) {
			instance = new CbtView();
		}
		return instance;
	}
	
	Scanner scanner = new Scanner(System.in);
	
	public int inputSubjectId(Scanner scanner) {
		System.out.println("★★📝응시하고싶은 과목을 입력하세요📝★★");
		System.out.println("");
		System.out.println("✔ 1.소프트웨어 설계");
		System.out.println("✔ 2.소프트웨어 개발");
		System.out.println("✔ 3.데이터베이스 구축");
		System.out.println("✔ 4.프로그래밍 언어 활용");
		System.out.println("✔ 5.정보시스템 구축 관리");
		System.out.println("✔ 0.전체 과목 응시");
		System.out.println("");
		System.out.print("📌과목 입력 ▶ ");
		return Integer.parseInt(scanner.nextLine());
	}
	public List printQuestions(List<CbtVO> list) {
	      System.out.println();
	      System.out.println("🏃‍♂️시험 시작🚶‍♂️");
	      List<String> ansList = new ArrayList<>();
	      
	         for(int i=0; i<list.size(); i++ ) {
	            System.out.print((i+1)+ ". " + list.get(i));
	            System.out.println("");
	            System.out.println("");
	            System.out.print("📌정답 ▶ ");
	            System.out.println();
	            Boolean loop = true;
	            while (loop) {
	            String ans = scanner.nextLine(); 
	            switch (ans) {
	            case "1": case "2": case "3": case "4":
	            ansList.add(null);
	            ansList.set(i, ans);
	            System.out.println("");
				System.out.println("─────────────────────────────────────────────────────────────────────────");
	            loop = false;
	            break;
	            default:
	            System.out.println("📌잘못된 입력입니다. 다시입력해주세요.");
	            break;
	            }
	            }
	            System.out.println();
	         }
	         return ansList;         
	   
	   }
	
//	public List printQuestions(List<CbtVO> list) {
//		System.out.println();
//		System.out.println("🏃‍♂️시험 시작🚶‍♂️");
//		System.out.println("");
//		List<String> ansList = new ArrayList<>();
//		
//			for(int i=0; i<list.size(); i++ ) {
//				System.out.print((i+1)+ ". " + list.get(i));
//				System.out.println("");
//				System.out.println("");
//				System.out.print("📌정답 ▶ ");
//				String ans = scanner.nextLine(); 
//				System.out.println("");
//				System.out.println("─────────────────────────────────────────────────────────────────────────");
//				ansList.add(null);
//				ansList.set(i, ans);
//				
//				System.out.println();
//			}
//			return ansList;			
//	}
	
	   public String inputTestNo() throws Exception {
		      System.out.println("📌해설을 확인 할 응시번호를 입력하시오.[나가기:0]");
		      System.out.print("📌응시번호 ▶ ");
		      String testNo = scanner.nextLine();
//		      if(testNo.equals("0")) {
//		    	  memView.mainMenu();
//		      }
		      return testNo;
		}
	   
	   public void printWanser(List<CbtVO> list) {
		      System.out.println();
		      System.out.println("👀해설보기👀");

		         for(int i=0; i<list.size(); i++ ) {
		            System.out.println((i+1)+ ". " + list.get(i));
		            System.out.println("🔍정답 :" + list.get(i).getAnswer());
		            System.out.println("📝해설 :" + list.get(i).getExplain());
		            System.out.println("📌다음문제 해설을 보려면 엔터를 입력하시오. ▶ ");
		            System.out.println("─────────────────────────────────────────────────────────────────────────");
		            String ans2 = scanner.nextLine(); 
		            System.out.println();
		         }
		         System.out.println("📌해설이 끝났습니다. 메인메뉴로 이동합니다.");
		         System.out.println();
		   }
	
	public void printQuestion(CbtVO vo) {
		System.out.println(vo);
	}
	
	public void insertResult(int count) {
		if(count > 0) {
			System.out.println("📌응시정보가 정상적으로 등록되었습니다.");
		} else {
			System.out.println("📌응시정보가 정상적으로 등록되지 않았습니다. \n 관리자에게 문의하세요.");
		}
	}
	
	public void insertScoreResult(int count) {
		if(count > 0) {
			System.out.println("📌점수가 정상적으로 등록되었습니다.");
		} else {
			System.out.println("📌점수가 정상적으로 등록되지 않았습니다. \n 관리자에게 문의하세요.");
		}
	}
	
	public void insertSubmitResult(int count) {
		if(count > 0) {
			System.out.println("📌제출이 정상적으로 완료되었습니다.");
		} else {
			System.out.println("📌제출이 정상적으로 완료되지 않았습니다. \n 관리자에게 문의하세요.");
		}
	}
	
	public void insertWAnswer(int count) {
		if(count > 0) {
			System.out.println("📌오답문제가 정상적으로 등록되었습니다.\n");
		} else {
			System.out.println("📌오답문제가 정상적으로 등록되지 않았습니다.\n 관리자에게 문의하세요.\n");
		}
	}
}

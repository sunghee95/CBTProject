package CbtProject.view;

import java.util.List;
import java.util.Scanner;

import CbtProject.MemberApplication;
import CbtProject.vo.AnswerVO;
import CbtProject.vo.BoardVO;

public class BoardView {
	
	BoardView() {}
	private static BoardView instance;
	public static BoardView getInstance() {
		if(instance == null) {
			instance = new BoardView();
		}
		return instance;
	}

	// 전체목록 출력
	public void boardList(List<BoardVO> list) {
		System.out.println("");
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━🔍질문게시판🔍━━━━━━━━━━━━━━━━━━━━━━━━");
		                                                                             
		for (BoardVO boardVO : list) {                                               
			System.out.println(boardVO);                                             
		}                                                                            
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

	}                                                                                

	// 작성하기
	public BoardVO boardInsert(Scanner scanner) {
		System.out.print("📌제목을 입력하세요 \n ▶ ");
		String title = scanner.nextLine();
		System.out.print("📌궁금한 내용을 입력하세요 \n ▶ ");
		String content = scanner.nextLine();
		String writer = MemberApplication.getSession().getMemCode();

		return new BoardVO(title, content, writer);
	}

	// 작성결과
	public void insertResult(int num) {
		if (num > 0) {
			System.out.println("📌등록완료!");
		} else {
			System.out.println("📌등록이 불가능합니다!확인해보세요~");
		}
	}

	// 수정
	public int putNumUpdate(Scanner scanner) {
		System.out.print("📌수정하고 싶은 글 번호를 입력하세요. \n ▶ ");
		return Integer.parseInt(scanner.nextLine());
	}

	public BoardVO boardUpdate(Scanner scanner) {
		System.out.print("📌수정할 글 번호를 입력하세요. ▶ ");
		int no = Integer.parseInt(scanner.nextLine());
		System.out.print("📌제목을 입력하세요. \n ▶ ");
		String title = scanner.nextLine();
		System.out.print("📌수정하고싶은 내용을 입력하세요. \n ▶ ");
		String content = scanner.nextLine();
		String writer = MemberApplication.getSession().getMemCode();
		return new BoardVO(no, title, content, writer);
	}

	// 수정결과
	public void resultUpdate(int num) {
		if (num > 0) {
			System.out.println("🙆‍♂️수정완료🙆‍♂️");
		} else {
			System.out.println("🙅‍♀️수정이 불가합니다🙅‍♀️");
		}
	}

	// 삭제
	public int putNumDelete(Scanner scanner) {
		System.out.print("📌삭제하고싶은 글 번호를 입력하세요. ▶ ");
		return Integer.parseInt(scanner.nextLine());
	}

	// 삭제완료
	public void deleteResult(int num) {
		if (num > 0) {
			System.out.println("📌삭제완료!");
		} else {
			System.out.println("📌삭제가 불가능합니다!확인해보세요~");
		}

	}

	// 상세보기
	public int putNumDetail(Scanner scanner) {
		System.out.print("📌자세히 보고싶은 글번호를 입력하세요. ▶ ");
		return Integer.parseInt(scanner.nextLine());

	}// 상세보기결과

	public void boardDetail(BoardVO vo) {
		System.out.println("━━━━ 🔍글내용 ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		System.out.println(vo.toString1());
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");;
	}

	// 댓글 등록
	public AnswerVO commetInsert(Scanner scanner) {
		System.out.println("📌답변을 입력하세요 \n ▶ ");
		String content = scanner.nextLine();
		String writer = MemberApplication.getSession().getMemCode();
		return new AnswerVO(content, writer);
	}

	public void commentResult(int num) {
		if (num > 0) {
			System.out.println("🙆‍♂️댓글등록 완료🙆‍♂️");
		} else {
			System.out.println("🙅‍♀️등록이 불가합니다. 다시 확인해보세요🙅‍♀️");
		}
	}

	public void commentView(List<AnswerVO> vo) {
		System.out.println("━━━━ 🔍댓글 ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		for (AnswerVO answer : vo) {
			System.out.println(answer);
		}
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
	}
}
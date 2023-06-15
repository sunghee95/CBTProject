package CbtProject.controller;

import java.util.List;
import java.util.Scanner;

import CbtProject.service.BoardService;
import CbtProject.view.BoardView;
import CbtProject.vo.AnswerVO;
import CbtProject.vo.BoardVO;

public class BoardController {
	
	BoardController() {}
	private static BoardController instance;
	public static BoardController getInstance() {
		if(instance == null) {
			instance = new BoardController();
		}
		return instance;
	}
	
	BoardService service = BoardService.getInstance();
	BoardView view = BoardView.getInstance();
	Scanner scanner = new Scanner(System.in);
	
	public void process() throws Exception {
		boolean back=true;
		while (back) {
			boardList("");
			System.out.println("┏━━━ menu ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("┃   1.상세  ┃  2.등록  ┃  3.수정  ┃  4.삭제   ┃   5.메인     ┃");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
			int selectNum = Integer.parseInt(scanner.nextLine());
			switch (selectNum) {
			case 1:
				int detail = boardDetail(scanner);
				System.out.println("");
				System.out.println("1.댓글달기 ┃ 2.글목록보기");
				int num2 = Integer.parseInt(scanner.nextLine());
				switch (num2) {
				case 1:
					commentInsert(scanner, detail);
				case 2:
					break;
				}

				break;

			case 2:
				boardInsert(scanner);
				break;

			case 3:
				boardUpdate(scanner);
				break;

			case 4:
				boardDelete(scanner);
				break;

			case 5:
				System.out.println("📌메인메뉴로 이동합니다.");
				System.out.println("");
				back=false;
				break;

			}
		}
	}
	//전체목록 조회
	public void boardList(String search) throws Exception {
		List<BoardVO> list = service.boardList(search);
		view.boardList(list);
	}
	//글 등록
	public void boardInsert(Scanner scanner) throws Exception {
		BoardVO vo = view.boardInsert(scanner);
		
		int insert = service.boardInsert(vo);
		view.insertResult(insert);
	}
	//글수정
	public void boardUpdate(Scanner scanner) throws Exception {
		//int num = view.putNumUpdate(scanner);
		BoardVO vo	= view.boardUpdate(scanner);
		int update = service.boardUpdate(vo);
		view.resultUpdate(update);
		
		
	}
	//글삭제
	public void boardDelete(Scanner scanner) throws Exception {
		int delete = view.putNumDelete(scanner);
		int delet = service.boardDelet(delete);
		view.deleteResult(delet);
	}
	
	//글상세보기
	public int boardDetail(Scanner scanner) throws Exception{
		int putNumDetail = view.putNumDetail(scanner);
		BoardVO detail = service.boardDetail(putNumDetail);
		List<AnswerVO> list = service.commentView(putNumDetail);
		view.boardDetail(detail);
		view.commentView(list);
		return putNumDetail;
		
	}
	//댓글달기
	public void commentInsert(Scanner scanner, int detail) throws Exception{
		AnswerVO comment = view.commetInsert(scanner);
		comment.setQ_no(detail);
		int result = service.commentInsert(comment);
		view.commentResult(result);
		
	}
	
		
}

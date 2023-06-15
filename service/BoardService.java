package CbtProject.service;

import java.util.List;

import CbtProject.dao.BoardDAO;
import CbtProject.vo.AnswerVO;
import CbtProject.vo.BoardVO;

public class BoardService {
	
	BoardService() {}
	private static BoardService instance;
	public static BoardService getInstance() {
		if(instance == null) {
			instance = new BoardService();
		}
		return instance;
	}

	private BoardDAO dao = BoardDAO.getInstance();

	public List<BoardVO> boardList(String search) throws Exception {
		List<BoardVO> list = dao.boardList(search);
		return list;
	}

	public int boardInsert(BoardVO vo) throws Exception {
		return dao.boardInsert(vo);
	}

	public int boardUpdate(BoardVO vo) throws Exception {
		return dao.boardUpdate(vo);
	}

	public int boardDelet(int num) throws Exception {
		return dao.boardDelete(num);

	}

	public BoardVO boardDetail(int num) throws Exception {
		return dao.boardDetail(num);

	}

	public int commentInsert(AnswerVO vo) throws Exception {
		return dao.commentInsert(vo);

	}

	public List<AnswerVO> commentView(int qNo) throws Exception {
		List<AnswerVO> list = dao.commentView(qNo);

		return list;
	}

}

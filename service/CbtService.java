package CbtProject.service;
import java.util.List;

import CbtProject.dao.CbtDAO;
import CbtProject.vo.CbtVO;

public class CbtService {
	
	CbtService() {}
	private static CbtService instance;
	public static CbtService getInstance() {
		if(instance == null) {
			instance = new CbtService();
		}
		return instance;
	}
	
	private CbtDAO dao = CbtDAO.getInstance();
	
	public List<CbtVO> selectSubject(int subjectId) throws Exception {
		return dao.selectSubject(subjectId);
	}
	
	public List<String> selectSubjectAnswer(int subjectId) throws Exception {
		return dao.selectSubjectAnswer(subjectId);
	}
	
	public List<String> selectSubjectExamId(int subjectId) throws Exception {
		return dao.selectSubjectExamId(subjectId);
	}
	
	public int insertTest(CbtVO vo) throws Exception {
		return dao.insertTest(vo);
	}
	
	public int insertTestScore(int score) throws Exception {
		return dao.insertTestScore(score);
	}
	
	public String selectMaxTestNo() throws Exception {
		return dao.selectMaxTestNo();
	}
	
	public int insertSubmit(List<String> subList) throws Exception {
		return dao.insertSubmit(subList);
	}
	
	public int insertWAnswer(List<String> wronganswer) throws Exception {
		return dao.insertWAnswer(wronganswer);
	}
	
	public void selectExamResult(String memCode1) throws Exception {
		dao.selectExamResult(memCode1);
	}
	
	public List<CbtVO> loadWanswer(String testNo) throws Exception {
		      return dao.loadWanswer(testNo);
	}
}

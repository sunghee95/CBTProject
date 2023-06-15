package CbtProject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import CbtProject.MemberApplication;
import CbtProject.service.CbtService;
import CbtProject.view.CbtView;
import CbtProject.vo.CbtVO;



public class CbtController {
	
	private CbtController() {}
	private static CbtController instance;
	public static CbtController getinstance() {
		if(instance == null) {
			instance = new CbtController();
		}
		return instance;
	}
	
	private CbtService service = CbtService.getInstance();
	private CbtView view =  CbtView.getinstance();
	
	int subjectId = 0;
	int score;
	List<String> ansList = null;
	
	public void question(Scanner scanner) throws Exception {
		subjectId = view.inputSubjectId(scanner);
		//TEST테이블 INSERT
		insertTest(subjectId);
		
		List<CbtVO> vo = service.selectSubject(subjectId);
		ansList = view.printQuestions(vo);
		score = testScore(ansList);
		
		System.out.println("📌점수 ▶ " + score + "\n");
		
		//TEST테이블 점수 INSERT
		insertTestScore(score);
		//SUBMIT테이블 INSERT
		insertSubmit();
	}
	
	List<String> subAnswer = null;
	public int testScore(List<String> ansList) throws Exception {
	      subAnswer = selectSubjectAnswer(subjectId);
	      score = 0;
	      if(subjectId != 0) {
	         for(int i=0; i<ansList.size(); i++) {
	            if(ansList.get(i).equals(subAnswer.get(i))) {
	               score+=5;
	            }
	         }
	      } else {
	          for(int i=0; i<ansList.size(); i++) {
		          if(ansList.get(i).equals(subAnswer.get(i))) {
		              score+=1;
		          }
	          }
	      }
	      return score;
	   }
	
	public List<String> selectSubjectExamId(int subjectId) throws Exception {
		return service.selectSubjectExamId(subjectId);
	}
	
	public List<String> selectSubjectAnswer(int subjectId) throws Exception {
		return service.selectSubjectAnswer(subjectId);
	}
	
	public void insertSubmit() throws Exception {
		List<String> examIdList = selectSubjectExamId(subjectId);
		int insertSubmitResult = 0;
		int insertWAnswer = 0;
		String mTestNo = selectMaxTestNo();
		
		List<String> submitList = new ArrayList<>();
		submitList.add(null);
		submitList.add(null);
		submitList.add(null);
		submitList.add(null);
		
		List<String> wronganswer = new ArrayList<>();
		wronganswer.add(null);
		wronganswer.add(null);
		
		for(int i=0; i<ansList.size(); i++) {
			
			submitList.set(0, mTestNo);
			submitList.set(1, examIdList.get(i));
			submitList.set(2, ansList.get(i));
			
			String tf = null;
			if(subAnswer.get(i).equals(ansList.get(i))) {
				tf = "true";
			} else {
				tf = "false";
			}
			submitList.set(3,tf);
			insertSubmitResult = service.insertSubmit(submitList);
			
			if(tf.equals("false")) {
				wronganswer.set(0, selectMaxTestNo());
				wronganswer.set(1, examIdList.get(i));
				insertWAnswer = service.insertWAnswer(wronganswer);
			}
		}
		view.insertSubmitResult(insertSubmitResult);
		view.insertWAnswer(insertWAnswer);
	}
	
	public void insertTest(int subjectId) throws Exception {
		String memCode = MemberApplication.getSession().getMemCode();
		CbtVO vo2 = new CbtVO(subjectId, memCode);
		int count2 = service.insertTest(vo2);
		view.insertResult(count2);
	}
	
	public void insertTestScore(int score) throws Exception {
		int insertScoreResult = service.insertTestScore(score);
		view.insertScoreResult(insertScoreResult);
	}
	
	public String selectMaxTestNo() throws Exception {
		String maxTestNo = service.selectMaxTestNo();
		return maxTestNo;
	}
	
	public void selectExamResult() throws Exception {
		String memCode1 = MemberApplication.getSession().getMemCode();
		System.out.println("📌 응시 결과 📌");
		System.out.println("───────────────────────────────────────────────────────────────────");
		System.out.println(" 응시번호      이름    응시과목    시험점수    \t     응시날짜");
		System.out.println("───────────────────────────────────────────────────────────────────");
		service.selectExamResult(memCode1);
		wanswer();
	}
	
	public void wanswer() throws Exception {

		      String inputTestNo = view.inputTestNo();
		      List<CbtVO> vo = service.loadWanswer(inputTestNo);
		      view.printWanser(vo);
		   }
}

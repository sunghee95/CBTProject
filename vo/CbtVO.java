package CbtProject.vo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CbtVO {
	private String examId;
	private String question;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private String answer;
	private String explain;
	private int subjectId;
	private String memCode;
	private String memId;
	
	public CbtVO(int subjectId, String memCode) { // Test테이블 insert용 생성자
		this.subjectId = subjectId;
		this.memCode = memCode;
	}
	
	public CbtVO(String question, String answer1, String answer2, String answer3, String answer4) { //문제출력 생성자
		this.question = question;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
	}

	
	
	public CbtVO(String question, String answer1, String answer2, String answer3, String answer4, String answer,String explain) {
		this.question = question;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.answer = answer;
		this.explain = explain;
	}

	public CbtVO() {}


	
	public String getMemCode() {
		return memCode;
	}

	public void setMemCode(String memCode) {
		this.memCode = memCode;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getExemId() {
		return examId;
	}

	public void setExemId(String exemId) {
		this.examId = exemId;
	}

	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public String getAnswer4() {
		return answer4;
	}
	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	@Override
	public String toString() {
		return question + "\n\n" + "1) " +answer1 + "\n" + "2) " + answer2 + "\n" + "3) " + answer3 + "\n" + "4) " +answer4;
	}
	
	
}

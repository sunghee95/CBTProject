package CbtProject.vo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class AnswerVO {
	SimpleDateFormat simple = new SimpleDateFormat("yy-MM-dd hh:mm");
	private int ano;
	private int qno;
	private String acontent;
	private Timestamp adate;
	private String memcode;
	
	
	
	//코멘트 등록
	public AnswerVO(String a_content,String mem_code) {
		
		
		this.acontent = a_content;
		this.memcode = mem_code;
	}
	
	public AnswerVO(String a_content,String mem_code,int q_no) {
		
	
		this.acontent = a_content;
		this.memcode = mem_code;
		this.qno = q_no;
	}
	public AnswerVO(int a_no, Timestamp a_date, String a_content,String mem_code) {
		
		this.ano = a_no;
		this.acontent = a_content;
		this.adate = a_date;
		this.memcode = mem_code;
	}
	public AnswerVO(int a_no, String a_content,Timestamp a_date,String mem_code,int q_no) {
		
		this.ano = a_no;
		this.acontent = a_content;
		this.adate = a_date;
		this.memcode = mem_code;
		this.qno = q_no;
	}
	
	public AnswerVO(int a_no, int q_no, String a_content, Timestamp a_date, String mem_code) {
		
		this.ano = a_no;
		this.qno = q_no;
		this.acontent = a_content;
		this.adate = a_date;
		this.memcode = mem_code;
	}

	public AnswerVO() {

	}

	public int getA_no() {
		return ano;
	}

	public void setA_no(int a_no) {
		this.ano = a_no;
	}

	public int getQ_no() {
		return qno;
	}

	public void setQ_no(int q_no) {
		this.qno = q_no;
	}

	public String getA_content() {
		return acontent;
	}

	public void setA_content(String a_content) {
		this.acontent = a_content;
	}

	public Timestamp getA_date() {
		return adate;
	}

	public void setA_date(Timestamp a_date) {
		this.adate = a_date;
	}

	public String getMem_code() {
		return memcode;
	}

	public void setMem_code(String mem_code) {
		this.memcode = mem_code;
	}

	@Override
	public String toString() {
		return String.format("%s%s%s",memcode,acontent,simple.format(adate)); 
	}
	

}

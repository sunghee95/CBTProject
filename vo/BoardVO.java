package CbtProject.vo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class BoardVO {
	SimpleDateFormat simple = new SimpleDateFormat("yy-MM-dd hh:mm");
	private int qno;
	private Timestamp qdate;
	private String qtitle;
	private String qcontent;
	private String memcode;

	
	public BoardVO(){}
// 조회,상세
	public BoardVO(int no, Timestamp date, String title, String content, String mem_code) {
		this.qno = no;
		this.qdate = date;
		this.qtitle = title;
		this.qcontent = content;
		this.memcode = mem_code;
	}
	// 글등록
	public BoardVO(String title, String content, String mem_code) {
		this.qtitle = title;
		this.qcontent = content;
		this.memcode = mem_code;
	}
	public BoardVO(int no,Timestamp date, String title, String mem_code) {
		this.qno = no;
		this.qtitle = title;
		this.qdate = date;
		this.memcode = mem_code;
	}
	public BoardVO(int no,String title, String content, String mem_code) {
		this.qno = no;
		this.qtitle = title;
		this.qcontent = content;
		this.memcode = mem_code;
	}
	//글 수정
	public BoardVO(Timestamp date, String title, String content, String mem_code) {
		
		this.qdate = date;
		this.qtitle = title;
		this.qcontent = content;
		this.memcode = mem_code;
	}
	public int getNo() {
		return qno;
	}
	public void setNo(int no) {
		this.qno = no;
	}
	public Timestamp getDate() {
		return qdate;
	}
	public void setDate(Timestamp date) {
		this.qdate = date;
	}
	public String getTitle() {
		return qtitle;
	}
	public void setTitle(String title) {
		this.qtitle = title;
	}
	public String getContent() {
		return qcontent;
	}
	public void setContent(String content) {
		this.qcontent = content;
	}
	public String getWriter() {
		return memcode;
	}
	public void setMemcode(String mem_code) {
		this.memcode = mem_code;
	}
	@Override
	public String toString() {
		return String.format("%s  %s%s%s", qno, memcode,qtitle, simple.format(qdate)); 
	}
	
	public String toString1() {
		return String.format("%s %s %s %s %s", qno, memcode,qtitle,qcontent, simple.format(qdate)); 
	}
	}
	


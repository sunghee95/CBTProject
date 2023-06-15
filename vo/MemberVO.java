package CbtProject.vo;

public class MemberVO {
	
	private String memCode;
	private String memId;
	private String memPw;
	private String memName;
	private String memMail;
	public MemberVO() {
	}
	public MemberVO(String memId, String memPw, String memMail) {
		this.memId = memId;
		this.memPw = memPw;
		this.memMail = memMail;
		
	}
	
	public MemberVO(String memId, String memPw, String memName, String memMail) {
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
		this.memMail = memMail;
		
	}

	public MemberVO(String memCode, String memId, String memPw, String memName, String memMail) {
		this.memCode = memCode;
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
		this.memMail = memMail;
	}

	public MemberVO(String memId, String memPw) {
        this.memId = memId;
        this.memPw = memPw;
	}

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

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemMail() {
		return memMail;
	}

	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}
	
	@Override
	public String toString() {
		return String.format("%s\t%s\t%s\t%s", memId, memPw, memName, memMail);
	}	
}
	
   
		

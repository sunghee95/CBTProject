package CbtProject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import CbtProject.vo.MemberVO;

public class MemberDAO {

	MemberDAO() {}
	private static MemberDAO instance;
	public static MemberDAO getInstance() {
		if(instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}

	public List<MemberVO> loginMember(MemberVO search) throws SQLException  {
		String url = "jdbc:oracle:thin:@192.168.146.52:1521:xe";
		String user = "BASIC_PROJECT ";
		String password = "0725";
		Connection connection = DriverManager.getConnection(url, user, password);
		Statement statement = connection.createStatement();
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT ");
		builder.append("    MEM_CODE, ");
		builder.append("    MEM_ID, ");
		builder.append("    MEM_PW, ");
		builder.append("    MEM_NAME, ");
		builder.append("    MEM_MAIL ");
		builder.append("FROM ");
		builder.append("    MEMBER ");
		String sql = builder.toString();
		ResultSet resultSet = statement.executeQuery(sql);
		List<MemberVO> list = new ArrayList<>();
		while (resultSet.next()) {
			String memCode = resultSet.getString("MEM_CODE");
			String memId = resultSet.getString("MEM_ID");
			String memPw = resultSet.getString("MEM_PW");
			String memName = resultSet.getString("MEM_NAME");
			String memMail = resultSet.getString("MEM_MAIL");
			list.add(new MemberVO(memId, memPw, memName, memMail));
		}
		return list;
	}

	public int joinMember(MemberVO vo) throws SQLException  {
		String url = "jdbc:oracle:thin:@192.168.146.52:1521:xe";
		String user = "BASIC_PROJECT";
		String password = "0725";
		Connection connection = DriverManager.getConnection(url, user, password);
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO member ( ");
		builder.append("    mem_code, ");
		builder.append("    mem_id, ");
		builder.append("    mem_pw, ");
		builder.append("    mem_name, ");
		builder.append("    mem_mail ");
		builder.append(") VALUES ( ");
		builder.append("    'm' || lpad(seq_member.NEXTVAL,3,'0'), ");
		builder.append("    ?, ");
		builder.append("    ?, ");
		builder.append("    ?, ");
		builder.append("    ? ");
		builder.append(") ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getMemId());
		statement.setString(2, vo.getMemPw());
		statement.setString(3, vo.getMemName());
		statement.setString(4, vo.getMemMail());
		int count = statement.executeUpdate();
		return count;
	}

	public int loginId(String search) throws SQLException  {
		String url = "jdbc:oracle:thin:@192.168.146.52:1521:xe";
		String user = "BASIC_PROJECT ";
		String password = "0725";
		Connection connection = DriverManager.getConnection(url, user, password);
		// connection.createStatement();
		StringBuilder builder = new StringBuilder();
		builder.append("    SELECT");
		builder.append("     COUNT(*) AS SC");
		builder.append(" FROM");
		builder.append("     member");
		builder.append(" WHERE");
		builder.append("     mem_id = ?");

		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, search);
		ResultSet resultSet = statement.executeQuery();
		int result = 0;
		while (resultSet.next()) {
			result = resultSet.getInt("SC");

		}
		resultSet.close();
		connection.close();
		statement.close();
		return result;

	}

	public MemberVO loginStart(String id, String pw) throws SQLException  {
		String url = "jdbc:oracle:thin:@192.168.146.52:1521:xe";
		String user = "BASIC_PROJECT ";
		String password = "0725";
		Connection connection = DriverManager.getConnection(url, user, password);
		// connection.createStatement();
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT");
		builder.append("     mem_code, ");
		builder.append("     mem_id, ");
		builder.append("     mem_pw, ");
		builder.append("     mem_name, ");
		builder.append("     mem_mail ");
		builder.append(" FROM");
		builder.append("     member");
		builder.append(" WHERE");
		builder.append("     mem_id = ?");
		builder.append("    and ");
		builder.append("     mem_pw = ?");

		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, id);
		statement.setString(2, pw);
		ResultSet resultSet = statement.executeQuery();
		MemberVO vo = null;
		if (resultSet.next()) {
			String memCode = resultSet.getString("mem_code");
			String memId = resultSet.getString("mem_id");
			String memPw = resultSet.getString("mem_pw");
			String memName = resultSet.getString("mem_name");
			String memMail = resultSet.getString("mem_mail");
			vo = new MemberVO(memCode, memId, memPw, memName, memMail);
		}
		resultSet.close();
		connection.close();
		statement.close();
		return vo;

	}

	// 회원정보수정
	public int updateMember(MemberVO vo) throws SQLException  {
		String url = "jdbc:oracle:thin:@192.168.146.52:1521:xe";
		String user = "BASIC_PROJECT ";
		String password = "0725";
		Connection connection = DriverManager.getConnection(url, user, password);
		StringBuilder builder = new StringBuilder();
		builder.append(" UPDATE MEMBER  ");
		builder.append("   SET MEM_PW = ?, ");
		builder.append("       MEM_MAIL = ? ");
		builder.append(" WHERE MEM_ID = ? ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getMemPw());
		statement.setString(2, vo.getMemMail());
		statement.setString(3, vo.getMemId());
		int num = statement.executeUpdate();
		statement.close();
		connection.close();
		return num;
	}
}
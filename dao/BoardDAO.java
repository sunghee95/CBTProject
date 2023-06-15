package CbtProject.dao;

import java.lang.Thread.State;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import CbtProject.vo.AnswerVO;
import CbtProject.vo.BoardVO;

public class BoardDAO {
	
	BoardDAO() {}
	private static BoardDAO instance;
	public static BoardDAO getInstance() {
		if(instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	
	// 목록조회
	public List<BoardVO> boardList(String a) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.146.52:1521:xe";
		String id = "BASIC_PROJECT";
		String pw = "0725";
		Connection connection = DriverManager.getConnection(url, id, pw);
		Statement statement = connection.createStatement();
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT");
		builder.append("    a.q_no ,");
		builder.append("    a.q_date,");
		builder.append("    RPAD(a.q_title,32),");
		builder.append("    RPAD(b.mem_name,10)");
		builder.append(" FROM");
		builder.append("     board_q a");
		builder.append("     LEFT OUTER JOIN member b ON ( a.mem_code = b.mem_code )");
		builder.append(" ORDER BY");
		builder.append("     1 ");
		String sql = builder.toString();

		ResultSet resultSet = statement.executeQuery(sql);
		List<BoardVO> list = new ArrayList<>();

		while (resultSet.next()) {
			int no = resultSet.getInt("q_no");
			Timestamp date = resultSet.getTimestamp("q_date");
			String title = resultSet.getString("RPAD(a.q_title,32)");
			String mem_code = resultSet.getString("RPAD(b.mem_name,10)");
			list.add(new BoardVO(no, date, title, mem_code));
		}
		connection.close();
		statement.close();
		resultSet.close();

		return list;
	}

	// 메모삽입
	public int boardInsert(BoardVO vo) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.146.52:1521:xe";
		String id = "BASIC_PROJECT";
		String pw = "0725";
		Connection connection = DriverManager.getConnection(url, id, pw);
		StringBuilder builder = new StringBuilder();
		builder.append(" INSERT INTO board_q (");
		builder.append("     q_no,");
		builder.append("     q_date,");
		builder.append("     q_title,");
		builder.append("     q_content,");
		builder.append("     mem_code");
		builder.append(" ) VALUES (");
		builder.append("     seq_board.NEXTVAL,");
		builder.append("     SYSDATE,");
		builder.append("     ?,");
		builder.append("     ?,");
		builder.append("    ?");
		builder.append(" )");

		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getTitle());
		statement.setString(2, vo.getContent());
		statement.setString(3, vo.getWriter());

		int num = statement.executeUpdate();

		connection.close();
		statement.close();
		return num;
	}

	// 수정 쿼리문
	public int boardUpdate(BoardVO vo) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.146.52:1521:xe";
		String id = "BASIC_PROJECT";
		String pw = "0725";
		Connection connection = DriverManager.getConnection(url, id, pw);
		connection.createStatement();
		StringBuilder builder = new StringBuilder();
		builder.append(" UPDATE board_q");
		builder.append("     SET");
		builder.append("         q_date = SYSDATE,");
		builder.append("         q_title =?,");
		builder.append("         q_content =?,");
		builder.append("         mem_code =?");
		builder.append("    where ");
		builder.append("         q_no = ? ");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, vo.getTitle());
		statement.setString(2, vo.getContent());
		statement.setString(3, vo.getWriter());
		statement.setInt(4, vo.getNo());

		int num = statement.executeUpdate();
		connection.close();
		statement.close();
		return num;

	}

	// 삭제쿼리문
	public int boardDelete(int putNum) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.146.52:1521:xe";
		String id = "BASIC_PROJECT";
		String pw = "0725";
		Connection connection = DriverManager.getConnection(url, id, pw);
		connection.createStatement();
		StringBuilder builder = new StringBuilder();
		builder.append(" DELETE FROM board_q  WHERE ");
		builder.append("     q_no = ?");
		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, putNum);
		int num = statement.executeUpdate();

		connection.close();
		statement.close();
		return num;
	}

	// 상세보기
	public BoardVO boardDetail(int putnum) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.146.52:1521:xe";
		String id = "BASIC_PROJECT";
		String pw = "0725";
		Connection connection = DriverManager.getConnection(url, id, pw);
		connection.createStatement();
		StringBuilder builder = new StringBuilder();
		builder.append(" SELECT");
		builder.append("     a.q_no,");
		builder.append("     a.q_date,");
		builder.append("     a.q_title,");
		builder.append("     a.q_content,");
		
		builder.append("     b.mem_name");
		builder.append(" FROM");
		builder.append("     board_q a");
		builder.append("        LEFT OUTER JOIN member b ON a.mem_code = b.mem_code");
		builder.append(" WHERE");
		builder.append("     q_no = ?");
		String sql = builder.toString();

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, putnum);

		ResultSet resultSet = statement.executeQuery();
		BoardVO vo = null;

		if (resultSet.next()) {
			int no = resultSet.getInt("q_no");
			Timestamp date = resultSet.getTimestamp("q_date");
			String title = resultSet.getString("q_title");
			String content = resultSet.getString("q_content");
			String mem_name = resultSet.getString("mem_name");
			vo = new BoardVO(no, date, title, content, mem_name);
		}

		resultSet.close();
		connection.close();
		statement.close();

		return vo;

	}

	// 댓글달기

	public int commentInsert(AnswerVO vo) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.146.52:1521:xe";
		String id = "BASIC_PROJECT";
		String pw = "0725";
		Connection connection = DriverManager.getConnection(url, id, pw);
		StringBuilder builder = new StringBuilder();
		builder.append(" INSERT INTO answer (");
		builder.append("     a_no,");
		builder.append("     a_content,");
		builder.append("     a_date,");
		builder.append("     mem_code,");
		builder.append("    q_no");
		builder.append(" ) VALUES (");
		builder.append("     commen.NEXTVAL,");
		builder.append("     ?,");
		builder.append("     SYSDATE,");
		builder.append("     ?, ");
		builder.append("     ? ");		
		builder.append(" )");

		String sql = builder.toString();
		PreparedStatement statement = connection.prepareStatement(sql);

		statement.setString(1, vo.getA_content());
		statement.setString(2, vo.getMem_code());
		statement.setInt(3, vo.getQ_no());

		int num = statement.executeUpdate();

		connection.close();
		statement.close();
		return num;
	}

	// 댓글보기
	public List<AnswerVO> commentView(int q_no) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.146.52:1521:xe";
		String id = "BASIC_PROJECT";
		String pw = "0725";
		Connection connection = DriverManager.getConnection(url, id, pw);
		connection.createStatement();
		StringBuilder builder = new StringBuilder();
		builder.append("  SELECT");
		builder.append("     a.a_no,");
		builder.append("     RPAD(a.a_content,35),");
		builder.append("     a.a_date,");
		builder.append("     RPAD(b.mem_name,10),");
		builder.append("     a.q_no");
		builder.append(" FROM");
		builder.append("     answer a");
		builder.append("     LEFT OUTER JOIN member b ON a.mem_code = b.mem_code");
		builder.append(" WHERE");
		builder.append("     a.Q_NO = ? ");
		builder.append("   ORDER BY 1 ");

		String sql = builder.toString();

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, q_no);

		ResultSet resultSet = statement.executeQuery();

		List<AnswerVO> list = new ArrayList<>();
		while (resultSet.next()) {
			int no = resultSet.getInt("a_no");
			String content = resultSet.getString("RPAD(a.a_content,35)");
			Timestamp date = resultSet.getTimestamp("a_date");
			String mem_name = resultSet.getString("RPAD(b.mem_name,10)");
			int qno = resultSet.getInt("q_no");
			list.add(new AnswerVO(no, content, date, mem_name, qno));
		}

		resultSet.close();
		connection.close();
		statement.close();

		return list;

	}

}

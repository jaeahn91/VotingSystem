package kr.ac.kopo.kopo22.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.kopo22.domain.Hubo;
import kr.ac.kopo.kopo22.domain.Tupyo;

public class TupyoDaoImpl implements TupyoDao {

	@Override
	public int vote(Tupyo tupyo) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://192.168.23.25:3306/kopoctc", "root", "kopo0000");
		int result = 0; // PreparedStatement�� executeUpdate ������� ������ ����.
		String sqlPstmt = "insert into tupyo_table values(?, ?);";
        PreparedStatement pstmt = conn.prepareStatement(sqlPstmt);
        pstmt.setInt(1, tupyo.getId()); // ��ǥ ��� �ĺ��� id�� �ݿ�
        pstmt.setInt(2, tupyo.getAge()); // ��ǥ�� ����� ���ɴ밪 �ݿ�
        try {
        	result = pstmt.executeUpdate();
        	// executeUpdate() �������� �ݿ��� ���ڵ��� �Ǽ��� int ���·� ����ȴ�.
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
        pstmt.close();
        conn.close();        
        return result;
	}

	@Override
	public int getTotalVote() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://192.168.23.25:3306/kopoctc", "root", "kopo0000");
		int totalvote = 0;
		Statement cntStmt = conn.createStatement();
		String selectQuery = String.format("select * from tupyo_table;");
		String cntQuery = String.format("select count(*) from tupyo_table;");
		try {
			ResultSet rset = cntStmt.executeQuery(cntQuery);
			rset.next();
			totalvote += rset.getInt(1);		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return totalvote;
	}

	@Override
	public List<Hubo> getResultList() throws ClassNotFoundException, SQLException {
		int id = 0;
		String name = "";
		int votes = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://192.168.23.25:3306/kopoctc", "root", "kopo0000");
        Statement stmt = conn.createStatement();
        Statement stmt2 = conn.createStatement();
        String selectQuery = String.format("select * from tupyo_table;");
        String cntQuery = String.format("select count(*) from tupyo_table where id=%d", id);
        List<Hubo> resultlist = new ArrayList<Hubo>();
        
        try {
        	ResultSet rset = stmt.executeQuery(selectQuery);
        	ResultSet rset2 = stmt2.executeQuery(cntQuery);
        	while (rset.next()) {
        		id = rset.getInt(1);
        		name = rset.getString(2);
        		votes = getTotalVote();
        		Hubo hubo = new Hubo(id, name, votes);
        		resultlist.add(hubo);        		
        	}
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
		return resultlist;
	}

	@Override
	public List<Tupyo> getTupyoAgeGroup(Hubo hubo) throws ClassNotFoundException, SQLException {
		int id = 0;
		int age = 0;
		int cnt = 0;
		
		List<Tupyo> ageGroupList = new ArrayList<Tupyo>();
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://192.168.23.25:3306/kopoctc", "root", "kopo0000");
        Statement stmt = conn.createStatement();
        Statement stmt2 = conn.createStatement();
        String selectQuery = String.format("select * from tupyo_table where id="+hubo.getId()+" ;");
        String cntQuery = String.format("select count(age), age from tupyo_table where id="+hubo.getId()+" group by age;");
        
        try {
        	ResultSet rset = stmt.executeQuery(selectQuery);
        	ResultSet rset2 = stmt2.executeQuery(cntQuery);
        	while (rset.next()) {
        		id = rset.getInt(1);
        		age = rset.getInt(2);
        		cnt = rset2.getInt(1);
        		Tupyo tupyo = new Tupyo (id, age, cnt);
        		ageGroupList.add(tupyo);
        	}
        	rset.close();
        	rset2.close();
        	stmt.close();
        	stmt2.close();
        	conn.close();        	
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
		return ageGroupList;
	}
}

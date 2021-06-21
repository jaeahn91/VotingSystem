package kr.ac.kopo.kopo22.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kr.ac.kopo.kopo22.domain.Hubo;
import java.sql.*;
import java.io.*;

public class HuboDaoImpl implements HuboDao {

	@Override
	public int create(Hubo hubo) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://192.168.23.25:3306/kopoctc", "root", "kopo0000");
        int result = 0;
        // 방법 1
//        String sqlStmt = String.format("insert into hubo_table values(%d, %s);", id, name);
//        Statement stmt = conn.createStatement();
//        int result = stmt.executeUpdate(sqlStmt);        
        // 방법 2
        String sqlPstmt = "insert into hubo_table values(?, ?);";
        PreparedStatement pstmt = conn.prepareStatement(sqlPstmt);
        pstmt.setInt(1, hubo.getId());
        pstmt.setString(2, hubo.getName());
        try {
        	result = pstmt.executeUpdate();
        } catch (Exception e) {
        	System.out.println(e.getMessage());
        }
        pstmt.close();
        conn.close();        
        return result;
	}

	@Override
	public int delete(Hubo hubo) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://192.168.23.25:3306/kopoctc", "root", "kopo0000");
        int result = 0;
        String sqlPstmt = "delete from hubo_table where id=?;";
        PreparedStatement pstmt = conn.prepareStatement(sqlPstmt);
        pstmt.setInt(1, hubo.getId());
        try {
        	result = pstmt.executeUpdate();
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        pstmt.close();
        conn.close();        
        return result;        
	}

	@Override
	public Hubo selectOne(int id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://192.168.23.25:3306/kopoctc", "root", "kopo0000");
        Statement stmtName = conn.createStatement();
        Statement stmtVotes = conn.createStatement(); 
        String selectName = String.format(""
        		+ "select * from hubo_table where id = %d", id); 
        String selectVotes = String.format(""
        		+ "select count(*) from tupyo_table where id = %d", id);
        String name = "";
        int votes = 0;
        
        try {
        	// 후보 한 명 이름 얻어온다
        	ResultSet rsetName = stmtName.executeQuery(selectName);
        	rsetName.next(); 
        	name = rsetName.getString(2); 
        	// 후보 한 명 총 득표수 얻어온다
        	ResultSet rsetVotes = stmtVotes.executeQuery(selectVotes);
        	rsetVotes.next();
        	votes = rsetVotes.getInt(1); 
        	rsetName.close();
        	rsetVotes.close();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
        stmtName.close();
        stmtVotes.close();
        conn.close();
        
        Hubo hubo = new Hubo(id, name, votes);
		return hubo;
	}

	@Override
	public List<Hubo> getHuboList() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://192.168.23.25:3306/kopoctc", "root", "kopo0000");
		List<Hubo> huboList = new ArrayList<Hubo>();
		Statement stmt = conn.createStatement();
		try {
			ResultSet rset = stmt.executeQuery("select * from hubo_table");
			while (rset.next()) {
				huboList.add(new Hubo(rset.getInt(1), rset.getString(2)));
			}
			rset.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		stmt.close();
		conn.close();
		return huboList;
	}

	@Override
	public void printCnd() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(
		        "jdbc:mysql://192.168.23.25:3306/kopoctc", "root", "kopo0000");
		Statement stmt = conn.createStatement();

		try {
		    ResultSet rset = stmt.executeQuery("select * from hubo_table");
		    while (rset.next()) {
		        System.out.print("<tr><td><form method=\"post\" action=\"A_02.jsp\">기호 : "); 
		        System.out.print("<input type=\"text\" name=\"id\" value= \"" + rset.getInt(1) + "\" readonly>");
		        System.out.print("&nbsp이름 : <input type=\"text\" name=\"name\"");
		        System.out.print("value=\"" + rset.getString(2) + "\" readonly>");
		        System.out.print("<button>삭제</button></form></td></tr>");
		    } 
		    rset.close();
		    stmt.close();
		    conn.close();
		    } catch (Exception e) {
		        System.out.println("error");
		    }		
	}
}

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ page import="kr.ac.kopo.kopo22.domain.*" %>
   <%@ page import="kr.ac.kopo.kopo22.dao.*" %>
   <%@ page import="kr.ac.kopo.kopo22.service.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>This is the Main Page for the Voting System.</title>
</head>
<body>
	<div>
        <table id="mainMenu">
            <tr>
                <td width=100><a href="#">후보등록</a></td>
                <td width=100><a href="#">투표</a></td>
                <td width=100><a href="#">개표결과</a></td>
            </tr>
        </table>
    </div>
    <div>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection(
        "jdbc:mysql://192.168.23.25:3306/kopoctc", "root", "kopo0000");
Statement stmt = conn.createStatement();

try {
    ResultSet rset = stmt.executeQuery("select * from hubo_table");
    while (rset.next()) {
        out.print("<tr><td><form method=\"post\" action=\"A_02.jsp\">기호 : "); 
        out.print("<input type=\"text\" name=\"id\" value= \"" + rset.getInt(1) + "\" readonly>");
        out.print("&nbsp이름 : <input type=\"text\" name=\"name\"");
        out.print("value=\"" + rset.getString(2) + "\" readonly>");
        out.print("<button>삭제</button></form></td></tr>");
    } rset.close();
    stmt.close();
    conn.close();
    } catch (Exception e) {
        out.println("error");
    }
%>
    <tr> <!-- 신규 후보자 추가 -->
        <form method='post' action='#'>
            <td width="500px">기호번호 : 
                <input type="text" id="idCnd" name="idCnd" value='' width=30>
                후보명 : <input type="text" id="nameCnd" name="nameCnd" value='' width=50>
                <button>추가</button>
            </td>
        </form>
    </tr>
    </div>
</body>
</html>
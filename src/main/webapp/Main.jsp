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
                <td width=100><a href="#">�ĺ����</a></td>
                <td width=100><a href="#">��ǥ</a></td>
                <td width=100><a href="#">��ǥ���</a></td>
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
        out.print("<tr><td><form method=\"post\" action=\"A_02.jsp\">��ȣ : "); 
        out.print("<input type=\"text\" name=\"id\" value= \"" + rset.getInt(1) + "\" readonly>");
        out.print("&nbsp�̸� : <input type=\"text\" name=\"name\"");
        out.print("value=\"" + rset.getString(2) + "\" readonly>");
        out.print("<button>����</button></form></td></tr>");
    } rset.close();
    stmt.close();
    conn.close();
    } catch (Exception e) {
        out.println("error");
    }
%>
    <tr> <!-- �ű� �ĺ��� �߰� -->
        <form method='post' action='#'>
            <td width="500px">��ȣ��ȣ : 
                <input type="text" id="idCnd" name="idCnd" value='' width=30>
                �ĺ��� : <input type="text" id="nameCnd" name="nameCnd" value='' width=50>
                <button>�߰�</button>
            </td>
        </form>
    </tr>
    </div>
</body>
</html>
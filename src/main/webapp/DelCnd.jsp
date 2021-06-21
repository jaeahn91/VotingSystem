<!DOCTYPE html>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.sql.*, javax.sql.*, java.io.*" %>
<%@ page import="kr.ac.kopo.kopo22.domain.*" %>
<%@ page import="kr.ac.kopo.kopo22.dao.*" %>
<%@ page import="kr.ac.kopo.kopo22.service.*" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        table, tr, td {
            border: solid black 1px;
            border-collapse: collapse;
        }

        #mainMenu {
            margin: 0%;
            padding: 0%;
        }

        .menuBtn {
            margin: 0%;
            background-color: white;
            border-color: navy;
            width: 100px;
            height: 30px;
        }

        .active {
            margin: 0%;
            background-color: yellow;
            border-color: navy;
        }

    </style>
</head>
<body>
    <%
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection(
            "jdbc:mysql://192.168.23.25:3306/kopoctc", "root", "kopo0000");
    Statement stmt = conn.createStatement();

    String ctmp = request.getParameter( "id" );
    stmt.execute("delete from hubo_table where id = " + ctmp);

    %>
    <div>
        <table id="mainMenu">
            <tr>
                <td width=100><a href="A_01.jsp">후보등록</a></td>
                <td width=100><a href="B_01.jsp">투표</a></td>
                <td width=100><a href="C_01.jsp">개표결과</a></td>
            </tr>
        </table>
        <div style="text-align:center;">
            후보등록 결과: 후보가 삭제되었습니다.
        </div>
    </div>
    
    <script>
        
    </script>


</body>
</html>
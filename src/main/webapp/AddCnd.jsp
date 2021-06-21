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
	request.setCharacterEncoding("utf-8");
      // 한글이 post/get의 파라미터로 연동될 때 필요한 처리
    int idCnd = Integer.parseInt(request.getParameter("idCnd"));
    String nameCnd = request.getParameter("nameCnd");
    Hubo hubo = new Hubo(idCnd, nameCnd);
    HuboService service = new HuboServiceImpl();
    int result = 0;
    result = service.create(hubo);
%>
    <div>
        <table id="mainMenu">
            <tr>
                <td width=100><a href="Main.jsp">후보등록</a></td>
                <td width=100><a href="#">투표</a></td>
                <td width=100><a href="#">개표결과</a></td>
            </tr>
        </table>
        <div>
            <div style="text-align:center;">
<%
	if (result != 0) {
		out.print("후보 등록이 완료되었습니다");
	} else {
		out.print("다시 시도해 주세요");
	}
%>    
            </div>
        </div>
    </div>
    
    <script>
        
    </script>


</body>
</html>
<%-- 
    Document   : Home
    Created on : 9 oct 2024, 14:18:08
    Author     : chris
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <a href="Home.jsp"></a>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! xd</h1>
    </body>
      <%
            HttpSession sesion = request.getSession();
            if(request.getAttribute("r") != null){
                if(request.getAttribute("r").equals("1")){
                    sesion.setAttribute("usr", request.getAttribute("txt_user"));
                    response.sendRedirect("index.html");
                    //response.sendRedirect(request.getContextPath() + "/html/Home.jsp");

                }
                else
                    out.println("<h4 class='text-center' style='color:red'>Credenciales incorrectas</h4>");
            }
        %>
</html>

<%-- 
    Document   : productPage
    Created on : 12 Nov 2020, 00:27:45
    Author     : cleob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>All Products</title>
        <style>
            
            body{
                background-image: url("bg.jpeg");
                background-repeat: no-repeat;
                background-position: center;
                background-attachment: fixed;
                background-size:cover;
                background-color:#282726;
                text-align: center;
            }
            
            table, td, th {  
                border: 2px solid #eee;
                border-color: white;
                text-align: center;
                box-shadow: 0 8px 12px 0 rgba(0,0,0,0.1);
                padding: 10px;
                width: 150px;
                font-family: "Palatino Linotype", "Book Antiqua", Palatino, serif;
            }
            th{
                background-color: rgba(10,10,10, 0.9);
                color: white;
                font-size: 20px;                
            }
            td{
                background-color: rgba(218, 215, 215,0.9);
                font-size: 15px;
            }
            table{
                padding: 1px;
            }
            
            .button {
                border: none;
                color: white;
                background-color: #008CBA;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;
            }
            
            .button:hover {
                background-color: #007094; 
                color: white;
            }
        </style>
        
        
    </head>
    <body style="vertical-align: middle">
        
        <h1><u>All Products</u></h1> 
        <table border ="1" width="500" align="center" vertical-align="center"> 
         <tr bgcolor=black> 
          <th>Barcode</th> 
          <th>Name</th> 
          <th>Color</th>
          <th>Description</th> 
         </tr>
  
        
            <c:forEach items="${listProduct}" var="p">
                <tr>
                    <td><c:out value="${p.barcode}" /></td>
                    <td><c:out value="${p.name}" /></td>
                    <td><c:out value="${p.color}" /></td>
                    <td><c:out value="${p.description}" /></td>
                    
                </tr>
            </c:forEach>
        </table>
        
        
        
        <form action="index.jsp" method="post">
            <p style="text-align: center">
                <br>
                <button type="submit" class="button">Return</button>
            </p>
        </form>
            
    </body>
</html>

<%-- 
    Document   : error
    Created on : 12 Nov 2020, 16:16:30
    Author     : cleob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body{
                background-image: url("bg.jpeg");
                background-repeat: no-repeat;
                background-position: center;
                background-attachment: fixed;
                background-size:cover;
                background-color:#282726;
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
        <h1 style="text-align: center"><u>Product already inserted!</u><br>Try again!</h1>
        
        <form action="index.jsp" method="post">
            <p style="text-align: center">
                <br>
                <button type="submit" class="button">Return</button>
            </p>
        </form>
        
        <form action="list" method="post">
            <p style="text-align: center">
                <br>
                <button type="submit" class="button">Show all Products</button>
            </p>
        </form>
        
    </body>
</html>

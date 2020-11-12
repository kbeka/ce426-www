<%-- 
    Document   : index
    Created on : 12 Nov 2020, 22:39:19
    Author     : cleob
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
    <head>
        <title>Home</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <style>
            body{
                background-image: url("bg2.jpg");
                background-repeat: no-repeat;
                background-position: center;
                background-attachment: fixed;
                background-size:cover;
                background-color:#282726;
                text-align: center;
            }
            
            #bg{
                border: none;
                position: absolute;
                top: 8px;
                left: 39%;
                width: fit-content;
                color: white;
                background-color: rgba(0,0,0,0.7);
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
    <body>
        <h1 id="bg" style="font-size: 40px">Enter product specs</h1>
        
        <form action="insert" method="post" accept-charset="utf-8">
            
            <pre>





            </pre>
         
            <input type="text" name="code" placeholder="barcode" style="height: 22px" required/>

            <input type="text" name="pname" placeholder="product name" style="height: 22px" required/>

            <input type="text" name="col" placeholder="color" style="height: 22px" required/>

            <input type="text" name="desc" placeholder="description" style="height: 22px" required/>
            <p>
                <br>
                <button type="submit" class="button">Insert -></button>
            </p>
        
        </form>
        
        <form action="list" method="post">
                <br>
                <button type="submit" class="button">Show all Products</button>
        </form>
    
    </body>
</html>


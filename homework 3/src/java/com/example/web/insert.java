/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.web;

import com.example.dao.*;
import com.example.model.*;

import java.sql.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cleob
 */

public class insert extends HttpServlet {
    private Dao dao;
    
    @Override
    public void init() {
        dao = new Dao();
    }
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/insert":
				insertProduct(request, response);
				break;
			default:
				showNewForm(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
        
        private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
        
        
        private void insertProduct(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		String code = request.getParameter("code");
		String name = request.getParameter("pname");
		String color = request.getParameter("col");
		String desc = request.getParameter("desc");
                
                request.setAttribute("code", code);
                request.setAttribute("pname", name);
                request.setAttribute("col", color);
                request.setAttribute("desc", desc);
                
                if(dao.getBarcode(code)!=null){
                    RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
                    dispatcher.forward(request, response);
                }
                Products newProduct = new Products(code, name, color, desc);
		dao.saveProduct(newProduct);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ProductPage.jsp");
		dispatcher.forward(request, response);
	}
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
           
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

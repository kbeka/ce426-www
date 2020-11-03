/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String code = request.getParameter("code");
            String pname = request.getParameter("pname");
            String col = request.getParameter("col");
            String desc = request.getParameter("desc");
            
            request.setAttribute("code", code);
            request.setAttribute("pname", pname);
            request.setAttribute("col", col);
            request.setAttribute("desc", desc);
            
            RequestDispatcher rd;
            
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb","root","BubbleGum");
                Statement stat = con.createStatement();
                String selectQuery = "select * from products where Barcode='"+code+"'";
                ResultSet rs = stat.executeQuery(selectQuery);
                if(rs.next()){
                    rd = request.getRequestDispatcher("error.jsp");
                }
                else{
                    int res = stat.executeUpdate("insert into products (barcode,name,color,description) values('"+code+"','"+pname+"','"+col+"','"+desc+"')");
                    rd = request.getRequestDispatcher("ProductPage.jsp");
                }
                
                rd.forward(request, response);
                
            }catch (ClassNotFoundException | SQLException ex) {
                out.println(ex);
            }
            
        }    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

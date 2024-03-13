/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AccountDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.Account;

/**
 *
 * @author phamt
 */
public class ForgotPassController extends HttpServlet {

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
        String userCheck = request.getParameter("user");
        ArrayList<Account> as = new AccountDBContext().getAllAccount();
        HttpSession session = request.getSession();
        boolean userFound = false;
        Account account = new AccountDBContext().checkAccountEx(userCheck);
        if (account.isActive()) {
            for (Account a : as) {
                if (a.getUser().equals(userCheck)) {
                    // Nếu tìm thấy user, đặt userFound thành true và chuyển hướng đến trang changePass.jsp
                    userFound = true;
                    session.setAttribute("userCheck", userCheck);
                    response.sendRedirect("changePass.jsp");
                    break; // Thoát khỏi vòng lặp sau khi tìm thấy user
                }
            }

// Nếu user không tồn tại trong danh sách, thông báo "user wrong"
            if (!userFound) {
                request.setAttribute("ms", "user wrong");
                request.getRequestDispatcher("forgotPass.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("ms", "Account ban");
                request.getRequestDispatcher("forgotPass.jsp").forward(request, response);
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

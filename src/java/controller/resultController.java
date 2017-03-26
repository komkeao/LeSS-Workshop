/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DatabaseConnection;

/**
 *
 * @author MainUser
 */
@WebServlet(name = "resultController", urlPatterns = {"/result"})
public class resultController extends HttpServlet {

    private Connection con;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            con = DatabaseConnection.getConnection();
            int price;
            int provided;
        int change;
        price = (int) Math.round(60);
        provided = (int) Math.round(1000);
            if (provided > price) {
                change = provided - price;
            int thousands = change/1000;
            

            int Fivehundred = change / 500;
            if (Fivehundred >= 0) {
                change = change % 500;
                request.setAttribute("fh",Fivehundred);
            }
            
            int Hundred = change / 100;
            if (Hundred >= 0) {
                change = change % 100;
                 request.setAttribute("oh",Hundred);
            }
          
            int Fifty = change / 50;
            if (Fifty >= 0) {
                change = change % 50;
                 request.setAttribute("ft",Fifty);
            }
            
            int Twenty = change / 20;
            if (Twenty >= 0) {
                change = change % 20;
                request.setAttribute("tt",Twenty);
            }
            
            int Ten = change / 10;
            if (Ten >= 0) {
                change = change % 10;
                
                request.setAttribute("t",Ten);
            }
        }
            request.setAttribute("license", "");
            request.setAttribute("province", "");
            request.setAttribute("hr", "");
            request.setAttribute("money", "");
            request.setAttribute("recMoney", "");
            request.setAttribute("change", "");
 
            
            RequestDispatcher view = request.getRequestDispatcher("result.jsp");
            view.forward(request, response);
       
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

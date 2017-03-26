/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Car;
import model.DatabaseConnection;

/**
 *
 * @author MainUser
 */
@WebServlet(name = "calculateController", urlPatterns = {"/calculate"})
public class calculateController extends HttpServlet {
private Connection con;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            String licensePlate=request.getParameter("licensePlate");
//            try {
//			PreparedStatement pStatement = con.prepareStatement("SELECT * FROM booking WHERE license = ?");
//			pStatement.setString(1,licensePlate);
//			ResultSet resultSet = pStatement.executeQuery();
//			 
//			if (resultSet.next()) {					
//			    int bookingID = resultSet.getInt("BookingID");  
//			    String time = resultSet.getString("Time");
//			    String bookingDate = resultSet.getString("BookingDate");
//			    int status = resultSet.getInt("Status");
//			    int userID = resultSet.getInt("UserID");
//			    
//			}
//			
//		} catch (SQLException e) {
//			System.err.println("Error: " + e);
//		}
            con = DatabaseConnection.getConnection();
            request.setAttribute("license", licensePlate);
            request.setAttribute("province", "aaaa");
            request.setAttribute("inTime", "ssss");
            request.setAttribute("outTime", "ddd");
            request.setAttribute("hr", "fffff");
            request.setAttribute("money", "gggg");
            RequestDispatcher view = request.getRequestDispatcher("calculate.jsp");
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

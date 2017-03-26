/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "calculateController", urlPatterns = {"/calculate"})
public class calculateController extends HttpServlet {

    private Connection con;
public static double totalPayment(Date datein, Date dateout){
        double sum = 0;
        double milliTime = dateout.getTime() - datein.getTime();

        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(0);
        nf.setRoundingMode(RoundingMode.CEILING);
        int hour = Integer.parseInt(nf.format(milliTime/(1000*60*60)));

        sum = 0;
        hour = hour%24;
        
        System.out.println("Hour total : " + hour);
        
        if(hour <= 1){ 
        	sum = 0;
        	hour -= 1;
        }
        if(hour >=2) sum += 20;        
        if(hour >=5) sum += (hour-4)*10;

        return sum;
    }
public static double getHour(Date datein, Date dateout){
        double sum = 0;
        double milliTime = dateout.getTime() - datein.getTime();

        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(0);
        nf.setRoundingMode(RoundingMode.CEILING);
        int hour = Integer.parseInt(nf.format(milliTime/(1000*60*60)));

        sum = 0;
        hour = hour%24;
        
        System.out.println("Hour total : " + hour);
        
        return hour;
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String licensePlate = request.getParameter("licensePlate");
        
        try {

            con = DatabaseConnection.getConnection();
            PreparedStatement pStatement = con.prepareStatement("SELECT * FROM parking WHERE License= ?");
            pStatement.setString(1, licensePlate);
            ResultSet resultSet = pStatement.executeQuery();

            if (resultSet.next()) {
                request.setAttribute("license", licensePlate);
                request.setAttribute("province", resultSet.getString("Province"));
                request.setAttribute("inTime", resultSet.getDate("Date_out")+" "+resultSet.getDate("Date_out").getTime());
                request.setAttribute("outTime", resultSet.getDate("Date_in"));
                request.setAttribute("hr",getHour(resultSet.getDate("Date_in"),resultSet.getDate("Date_out")) );
                request.setAttribute("money", totalPayment(resultSet.getDate("Date_in"),resultSet.getDate("Date_out")));
            }
        } catch (Exception ex) {

            Logger.getLogger(calculateController.class.getName()).log(Level.SEVERE, null, ex);
        }
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

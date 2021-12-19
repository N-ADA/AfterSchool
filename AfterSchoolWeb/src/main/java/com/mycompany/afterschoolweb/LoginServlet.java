/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.afterschoolweb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.naming.*;
import javax.sql.*;
import java.sql.*;

/**
 *
 * @author ACER
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/portal"})
public class LoginServlet extends HttpServlet {

    String id;
    String password;

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

        id = request.getParameter("ID");
        password = request.getParameter("password");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"utf-8\">");
        out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
        out.println("<title>After School | Student</title>");
        out.println("<meta name=\"description\" content=\"Core HTML Project\">");
        out.println("<meta name=\"viewpor\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");

        out.println("<link rel=\"stylesheet\" href=\"vendor/bootstrap/bootstrap.min.css\">");
        out.println("<link rel=\"stylesheet\" href=\"vendor/select2/select2.min.css\">");
        out.println("<link rel=\"stylesheet\" href=\"vendor/owlcarousel/owl.carousel.min.css\">");
        out.println("<link rel=\"stylesheet\" href=\"vendor/lightcase/lightcase.css\">");

        out.println("<link href=\"https://fonts.googleapis.com/css?family=Lato:300,400|Work+Sans:300,400,700\" rel=\"stylesheet\">");

        out.println("<link rel=\"stylesheet\" href=\"style.min.css\">");
        out.println("<link rel=\"stylesheet\" href=\"https://cdn.linearicons.com/free/1.0.0/icon-font.min.css\">");
        out.println("<link href=\"https://file.myfontastic.com/7vRKgqrN3iFEnLHuqYhYuL/icons.css\" rel=\"stylesheet\">");

        out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.js\"></script>");
        out.println("</head>");

        try {
            Context ctx = new InitialContext();
            if (ctx == null) {
                throw new Exception("Error - No Context");
            }
            // /jdbc/postgres is the name of the resource in context.xml
            DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/postgres");
            if (ds != null) {
                Connection conn = ds.getConnection();
                if (conn != null) {
                    int i = Integer.parseInt(id);
                    Statement stmt = conn.createStatement();
                    ResultSet r = stmt.executeQuery("SELECT f_name, l_name, user_type FROM Account NATURAL JOIN Users WHERE user_id = " + i + " AND password = '" + password + "';");
                    if (r.next()) {
                        out.println("<body data-spy=\"scroll\" data-target=\"#navbar-nav-header\" class=\"static-layout\">");
                        out.println("<div class = \"row\">");
                        out.println("<div class = \"col-md-6 col-sm-4\">\n"
                                + "     <h2 style=\"color: white; font-family:;\"><i>&ensp;<u>After School</u></i></h2>\n"
                                + "  </div> ");

                        out.println("<div class = \"col-md-6 col-sm-4\">");
                        out.println("<div class=\"dropdown\">");
                        out.println("<button class=\"dropbtn\"><h4><i>" + r.getString("f_name") + " " + r.getString("l_name") + "</i></h4></button>");
                        out.println("<div class=\"dropdown-content\">\n"
                                + "     <a href=\"#\">Profile</a>\n"
                                + "     <a href=\"#\">My Sessions</a>\n"
                                + "     <a href=\"#\">My Account</a>\n"
                                + "     <a href=\"index.html\" style=\"color: red;\">Log Out</a>\n"
                                + "   </div>");
                        out.println("</div>");
                        out.println("</div>");
                        out.println("</div>");
                        out.println("<div class=\"boxed-page\">");
                        out.println("<section id=\"gtco-who-we-are\" class=\"bg-white\">");
                        out.println("<div class=\"row\">");
                        out.println("<div class=\"col-md-6 col-sm-4 counter-item\">");
                        out.println("<div class = \"BookNowBox\">");
                        out.println("<h1 style=\"color: white\"><br>Learn Without Limits<br>with After School</h1>");
                        out.println("<br><br><br><br><br>");
                        out.println("<h4 style=\"color : white\">Get Started Now!</h4>");
                        out.println("<button class=\"button\" style=\"vertical-align:middle; color: #1d1d8c\"><span>Book Session</span></button>");
                        out.println("</div>");
                        out.println("</div>");

                        out.println("<div class=\"col-md-6 col-sm-4\">");
                        out.println("<br><h2>Upcoming Sessions. . .</h2>");
                        out.println("<br><br>");
                        Statement stmt2 = conn.createStatement();
                        ResultSet res = stmt2.executeQuery("SELECT course_code, room_num FROM Booking NATURAL JOIN Session WHERE student_id = " + i + ";");
                        out.println("<div class=\"scroll\">");
                        out.println("<h6 style=\"color: #141470\">");
                        while(res.next()){
                            String n = res.getString("course_code");
                            String nm = res.getString("room_num");
                            out.println("<img src=\"pictures/arrow.png\" height=\"20\">" + n + " | " + nm + "<br><br>");
                        }
                        out.println("</h6>");
                        out.println("</div>");
                        out.println("</div>");
                        out.println("</div>");
                        out.println("</section>");
                        out.println("<section id=\"gtco-counter\" class=\"overlay bg-fixed\">");
                        out.println("<div class=\"container\">");
                        out.println("<div class=\"section-content\">");
                        out.println("<div class=\"row\">");
                        out.println("<div class=\"col-md-3 col-sm-6 counter-item\">");
                        out.println("<span class=\"number\" data-from=\"0\" data-to=\"34\" data-refresh-interval=\"100\">14</span>");
                        out.println("<h4>Attended Hours</h4>");
                        out.println("</div>");
                        out.println("<div class=\"col-md-3 col-sm-6 counter-item\">");
                        out.println("<span class=\"number\" data-from=\"0\" data-to=\"32\" data-refresh-interval=\"100\">32</span>");
                        out.println("<h4>Booked Sessions</h4>");
                        out.println("</div>");
                        out.println("<div class=\"col-md-3 col-sm-6 counter-item\">");
                        out.println("<span class=\"number\" data-from=\"0\" data-to=\"38\" data-refresh-interval=\"100\">38</span>");
                        out.println("<h4>Most Booked Course</h4>");
                        out.println("</div>");
                        out.println("<div class=\"col-md-3 col-sm-6 counter-item\">");
                        out.println("<span class=\"number\" data-from=\"0\" data-to=\"29\" data-refresh-interval=\"100\">29</span>");
                        out.println("<h4>Balance</h4>");
                        out.println("</div>");
                        out.println("</div>");
                        out.println("</div>");
                        out.println("</div>");
                        out.println("</section>");
                        out.println("</section>");
                        out.println("</div>");
                    }
                    else{
                        out.println("<p> NO SUCH USER </p>");
                        out.println("<a href=\"Loginpage.html\"> Go back to login page </a></div>");
                    }
                } else {
                    out.println("Error: conn is null ");
                }
            }
        } catch (SQLException ex) {
            out.println("SQLException: " + ex);
        } catch (Exception e) {
//e.printStackTrace();
            out.println("Exception caught");
            out.println(e.toString());
        }
        out.println("</body>");
        out.println("</html>");
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

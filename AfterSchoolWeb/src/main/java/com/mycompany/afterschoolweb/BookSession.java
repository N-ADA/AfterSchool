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

/**
 *
 * @author ACER
 */
@WebServlet(name = "BookSession", urlPatterns = {"/booksession"})
public class BookSession extends HttpServlet {

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

        PrintWriter out = response.getWriter();
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>\n"
                    + "    <html>\n"
                    + "    <head>\n"
                    + "        <title>Book A Session</title>\n"
                    + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                    + "        <link rel=\"stylesheet\" href=\"BookNowStyle.css\">\n"
                    + "        <link rel=\"shortcut icon\" href=\"pictures/favicon.ico\">\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <div id=\"booking\" class=\"section\">\n"
                    + "          <div class=\"section-center\">\n"
                    + "            <div class=\"container\">\n"
                    + "              <div class=\"booking-form\">\n"
                    + "                <div class=\"form-header\">\n"
                    + "                  <h1> Book A Session</h1>\n"
                    + "                </div>\n"
                    + "                <form>\n"
                    + "                    <div class=\"level-select-box select-box\">\n"
                    + "                      <div class=\"level-options-container ops-container\">\n"
                    + "                        <div class=\"option\">\n"
                    + "                          <input type=\"radio\" class=\"radio\" id=\"lycee\" name=\"category\"/>\n"
                    + "                            <label for=\"lycee\">Tronc Commun</label>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"option\">\n"
                    + "                          <input type=\"radio\" class=\"radio\" id=\"col\" name=\"category\"/>\n"
                    + "                            <label for=\"col\">Première Bac</label>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"option\">\n"
                    + "                          <input type=\"radio\" class=\"radio\" id=\"prim\" name=\"category\"/>\n"
                    + "                            <label for=\"prim\">Deuxième Bac</label>\n"
                    + "                        </div>\n"
                    + "                      </div>\n"
                    + "                      <div class=\"level-selected selected\">\n"
                    + "                        Select Level\n"
                    + "                      </div>\n"
                    + "                      <div class=\"level-search-box search-box\">\n"
                    + "                        <input type=\"text\" placeholder=\"Start Typing...\" />\n"
                    + "                      </div>\n"
                    + "                    </div>\n"
                    + "                    <div class=\"course-select-box select-box\">\n"
                    + "                      <div class=\"course-options-container ops-container\">\n"
                    + "                        <div class=\"option\">\n"
                    + "                          <input type=\"radio\" class=\"radio\" id=\"mth\" name=\"category\"/>\n"
                    + "                            <label for=\"mth\">Math</label>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"option\">\n"
                    + "                          <input type=\"radio\" class=\"radio\" id=\"phy\" name=\"category\"/>\n"
                    + "                            <label for=\"phy\">Physics</label>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"option\">\n"
                    + "                          <input type=\"radio\" class=\"radio\" id=\"che\" name=\"category\"/>\n"
                    + "                            <label for=\"che\">Chemistry</label>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"option\">\n"
                    + "                          <input type=\"radio\" class=\"radio\" id=\"psy\" name=\"category\"/>\n"
                    + "                            <label for=\"psy\">Psychology</label>\n"
                    + "                        </div>\n"
                    + "                      </div>\n"
                    + "                      <div class=\"course-selected selected\" id=\"course\" disabled=\"disabled\">\n"
                    + "                        Select Course\n"
                    + "                      </div>\n"
                    + "                      <div class=\"course-search-box search-box\">\n"
                    + "                        <input type=\"text\" placeholder=\"Start Typing...\" />\n"
                    + "                      </div>\n"
                    + "                    </div>\n"
                    + "                    <div class=\"date\">\n"
                    + "                      <div class=\"form-group\">\n"
                    + "                        <input class=\"form-control\" type=\"date\" required>\n"
                    + "                      </div>\n"
                    + "                    </div>\n"
                    + "                    <div>\n"
                    + "                      <div class=\"type-select-box select-box\">\n"
                    + "                        <div class=\"type-options-container ops-container\">\n"
                    + "                          <div class=\"option\">\n"
                    + "                            <input type=\"radio\" class=\"radio\" id=\"indiv\" name=\"category\"/>\n"
                    + "                              <label for=\"indiv\">Individual Session</label>\n"
                    + "                          </div>\n"
                    + "                          <div class=\"option\">\n"
                    + "                            <input type=\"radio\" class=\"radio\" id=\"grp\" name=\"category\"/>\n"
                    + "                              <label for=\"grp\">Group Session</label>\n"
                    + "                          </div>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"type-selected selected\" id=\"type\" disabled=\"disabled\">\n"
                    + "                          Select Session Type\n"
                    + "                        </div>\n"
                    + "                      </div>\n"
                    + "                      </div>\n"
                    + "                    <div class=\"tutor-select-box select-box\">\n"
                    + "                      <div class=\"tutor-options-container ops-container\">\n"
                    + "                        <div class=\"option\">\n"
                    + "                          <input type=\"radio\" class=\"radio\" id=\"tut1\" name=\"category\"/>\n"
                    + "                            <label for=\"tut1\">Khaoula Ait Soussi</label>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"option\">\n"
                    + "                          <input type=\"radio\" class=\"radio\" id=\"tut2\" name=\"category\"/>\n"
                    + "                            <label for=\"tut2\">Nada Bounajma</label>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"option\">\n"
                    + "                          <input type=\"radio\" class=\"radio\" id=\"tut3\" name=\"category\"/>\n"
                    + "                            <label for=\"tut3\">Saad Driouech</label>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"option\">\n"
                    + "                          <input type=\"radio\" class=\"radio\" id=\"tut4\" name=\"category\"/>\n"
                    + "                            <label for=\"tut4\">Yassir Ben abdallah</label>\n"
                    + "                        </div>\n"
                    + "                      </div>\n"
                    + "                      <div class=\"tutor-selected selected\" id=\"tutor\" disabled=\"disabled\">\n"
                    + "                        Select Tutor\n"
                    + "                      </div>\n"
                    + "                      <div class=\"tutor-search-box search-box\">\n"
                    + "                        <input type=\"text\" placeholder=\"Start Typing...\" />\n"
                    + "                      </div>\n"
                    + "                    </div>\n"
                    + "                    <div class=\"availability-select-box select-box\">\n"
                    + "                      <div class=\"availability-options-container ops-container\">\n"
                    + "                        <div class=\"option\">\n"
                    + "                          <input type=\"radio\" class=\"radio\" id=\"av1\" name=\"category\"/>\n"
                    + "                            <label for=\"av1\">8:00 - 9:00</label>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"option\">\n"
                    + "                          <input type=\"radio\" class=\"radio\" id=\"av2\" name=\"category\"/>\n"
                    + "                            <label for=\"av2\">10:00 - 11:00</label>\n"
                    + "                        </div>\n"
                    + "                        <div class=\"option\">\n"
                    + "                          <input type=\"radio\" class=\"radio\" id=\"av3\" name=\"category\"/>\n"
                    + "                            <label for=\"tut3\">12:00 - 13:00</label>\n"
                    + "                        </div>\n"
                    + "                      </div>\n"
                    + "                      <div class=\"availability-selected selected\" id=\"availability\" disabled=\"disabled\">\n"
                    + "                        Select Availability\n"
                    + "                      </div>\n"
                    + "                    </div>\n"
                    + "                    <div class=\"form-btn\">\n"
                    + "                      <button class=\"btn\" id=\"bookBtn\" disabled> Confirm Booking</button>\n"
                    + "                    </div>\n"
                    + "                </form>\n"
                    + "              </div>\n"
                    + "            </div>\n"
                    + "          </div>\n"
                    + "        </div>\n"
                    + "      </div>\n"
                    + "    </body>\n"
                    + "    <script type=\"text/javascript\" src=\"bookNow.js\"></script>\n"
                    + "</html>");

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

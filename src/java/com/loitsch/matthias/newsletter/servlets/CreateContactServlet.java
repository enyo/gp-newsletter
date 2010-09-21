/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loitsch.matthias.newsletter.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loitsch.matthias.newsletter.entities.Contact;

import com.loitsch.matthias.newsletter.PMF;
import javax.jdo.PersistenceManager;

/**
 *
 * @author enyo
 */
public class CreateContactServlet extends HttpServlet {

  /**
   * Handles the HTTP <code>POST</code> method.
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {


    String title = request.getParameter("title");
    String firstName = request.getParameter("firstName");
    String middleName = request.getParameter("middleName");
    String lastName = request.getParameter("lastName");
    String email = request.getParameter("email");
    String note = request.getParameter("note");

    Contact contact = new Contact(title, firstName, middleName, lastName, email, note);

    PersistenceManager pm = PMF.get().getPersistenceManager();
    try {
      pm.makePersistent(contact);
    } finally {
      pm.close();
    }

    response.sendRedirect("view-contacts.jsp");

  }

}

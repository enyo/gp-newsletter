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

import com.loitsch.matthias.newsletter.Contact;

import com.loitsch.matthias.newsletter.PMF;
import javax.jdo.PersistenceManager;

/**
 *
 * @author enyo
 */
public class UpdateContactServlet extends HttpServlet {

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


    PersistenceManager pm = PMF.get().getPersistenceManager();

    Contact contact = pm.getObjectById(Contact.class, Long.parseLong(request.getParameter("id")));


    contact.setTitle(request.getParameter("title"));
    contact.setFirstName(request.getParameter("firstName"));
    contact.setMiddleName(request.getParameter("middleName"));
    contact.setLastName(request.getParameter("lastName"));
    contact.setEmail(request.getParameter("email"));
    contact.setNote(request.getParameter("note"));

    pm.close();

    response.sendRedirect("view-contact.jsp?id=" + contact.getId());

  }

}

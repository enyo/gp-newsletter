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
public class DeleteContactServlet extends HttpServlet {

  /**
   * Handles the HTTP <code>GET</code> method.
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {


    Long contactId = Long.parseLong(request.getParameter("id"));


    PersistenceManager pm = PMF.get().getPersistenceManager();

    Contact contact = pm.getObjectById(Contact.class, contactId);

    pm.deletePersistent(contact);

    response.sendRedirect("view-contacts.jsp");

  }

}

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
import com.loitsch.matthias.newsletter.entities.PhoneNumber;
import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;

/**
 *
 * @author enyo
 */
public class CreatePhoneNumberServlet extends HttpServlet {

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


    String number = request.getParameter("number");

    PersistenceManager pm = PMF.get().getPersistenceManager();

    Contact contact = pm.getObjectById(Contact.class, Long.parseLong(request.getParameter("contactId")));

    PhoneNumber phoneNumber = new PhoneNumber(number, contact);

    contact.getPhoneNumbers().add(phoneNumber);

    String message;


    Transaction tx = pm.currentTransaction();

    try {
      tx.begin();
      pm.makePersistent(phoneNumber);
      tx.commit();
      message = "&success=Phone+number+successfully+saved.";
    }
    catch (Exception e) {
      message = "&error=Something went wrong. " + e.getLocalizedMessage();
    }
    finally {
      if (tx.isActive()) {
        tx.rollback();
      }
      pm.close();
    }

    response.sendRedirect("view-contact.jsp?id=" + contact.getId() + message);

  }
}

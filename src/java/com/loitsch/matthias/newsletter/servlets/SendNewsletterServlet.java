/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loitsch.matthias.newsletter.servlets;

import com.google.appengine.api.labs.taskqueue.Queue;
import com.google.appengine.api.labs.taskqueue.QueueFactory;
import static com.google.appengine.api.labs.taskqueue.TaskOptions.Builder.*;
import com.loitsch.matthias.newsletter.PMF;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loitsch.matthias.newsletter.entities.Contact;
import java.util.List;

import java.util.logging.Logger;
import javax.jdo.PersistenceManager;

/**
 *
 * @author enyo
 */
public class SendNewsletterServlet extends HttpServlet {

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


    Queue queue = QueueFactory.getQueue("mail-queue");

    String subject = request.getParameter("subject");
    String message = request.getParameter("message");

    if (subject == null || message == null || subject.isEmpty() || message.isEmpty()) {
      response.sendRedirect("/send-newsletter.jsp?error=Subject+or+message+not+submitted.");
      return;
    }

    PersistenceManager pm = PMF.get().getPersistenceManager();
    String query = "select from " + Contact.class.getName() + " order by lastName range 0,5";
    List<Contact> contacts = (List<Contact>) pm.newQuery(query).execute();
    if (!contacts.isEmpty()) {
      for (Contact c : contacts) {
          queue.add(url("/send-mail").param("recipientEmail", c.getEmail()).param("recipientName", c.getFormattedName()).param("subject", subject).param("message", message));
      }
    }

    response.sendRedirect("/send-newsletter.jsp");
  }
}

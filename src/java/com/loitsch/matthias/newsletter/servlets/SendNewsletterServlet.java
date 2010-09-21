/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loitsch.matthias.newsletter.servlets;

import com.google.appengine.api.labs.taskqueue.Queue;
import com.google.appengine.api.labs.taskqueue.QueueFactory;
import static com.google.appengine.api.labs.taskqueue.TaskOptions.Builder.*;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loitsch.matthias.newsletter.entities.Contact;

import java.util.logging.Logger;


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

    queue.add(url("/send-mail").param("recipient", "Recipient 1"));
    queue.add(url("/send-mail").param("recipient", "Recipient 2"));
    queue.add(url("/send-mail").param("recipient", "Recipient 3"));
    queue.add(url("/send-mail").param("recipient", "Recipient 4"));

  }

}

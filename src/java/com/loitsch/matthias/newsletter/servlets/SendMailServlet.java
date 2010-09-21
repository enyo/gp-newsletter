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
import java.util.Properties;

import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author enyo
 */
public class SendMailServlet extends HttpServlet {

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

    final Logger log = Logger.getLogger(SendMailServlet.class.getName());

    Properties props = new Properties();
    Session session = Session.getDefaultInstance(props, null);


    String recipientEmail = request.getParameter("recipientEmail");
    String recipientName = request.getParameter("recipientName");
    String message = request.getParameter("message");
    String subject = request.getParameter("subject");
    
    log.info("Sending mail to " + recipientName + " " + recipientEmail);

    try {
      Message msg = new MimeMessage(session);
      msg.setFrom(new InternetAddress("newsletter@gesundheitspraxis.com", "Gesundheitspraxis"));

      msg.addRecipient(Message.RecipientType.TO,
              new InternetAddress(recipientEmail, recipientName));
      msg.setSubject(subject);
      msg.setText(message);
      Transport.send(msg);
    } catch (AddressException e) {
      log.warning(e.getLocalizedMessage());
    } catch (MessagingException e) {
      log.warning(e.getLocalizedMessage());
    }

  }

}

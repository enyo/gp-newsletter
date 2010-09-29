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

import com.loitsch.matthias.newsletter.entities.Address;

import com.loitsch.matthias.newsletter.PMF;
import javax.jdo.PersistenceManager;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

/**
 *
 * @author enyo
 */
public class DeleteAddressServlet extends HttpServlet {

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


    Key addressId = KeyFactory.stringToKey(request.getParameter("id"));

    PersistenceManager pm = PMF.get().getPersistenceManager();

    Address address = pm.getObjectById(Address.class, addressId);

    Long contactId = address.getContact().getId();

    pm.deletePersistent(address);

    response.sendRedirect("view-contact.jsp?id=" + contactId);

  }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loitsch.matthias.newsletter.utils;

/**
 *
 * @author enyo
 */
public class StringUtils {

  /**
   * Escapes all characters that could pose a problem in html.
   * @param string
   * @return
   */
  public static String escapeHtml(String string) {
    int len = string.length();
    char c;

    StringBuffer sb = new StringBuffer(len);

    for (int i = 0; i < len; i++) {
      c = string.charAt(i);
      switch (c) {
        case '<':
          sb.append("&lt;");
          break;
        case '>':
          sb.append("&gt;");
          break;
        case '&':
          sb.append("&amp;");
          break;
        case '"':
          sb.append("&quot;");
          break;
        default:
          sb.append(c);
          break;
      }
    }

    return sb.toString();
  }
}

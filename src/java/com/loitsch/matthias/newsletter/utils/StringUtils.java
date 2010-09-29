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

  public static String escapeHtml(String string) {
    return escapeHtml(string, false);
  }

  /**
   * Escapes all characters that could pose a problem in html.
   * @param string
   * @param Boolean
   * @return
   */
  public static String escapeHtml(String string, Boolean newlines) {
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
        case '\n':
          if (newlines) {
            sb.append("<br />");
          } else {
            sb.append(c);
          }
          break;
        default:
          sb.append(c);
          break;
      }
    }

    return sb.toString();
  }
}

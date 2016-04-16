/*
 * TemplateFileFilter.java
 *
 * Created on 25. September 2002, 19:36
 */

package net.flockhost.jwebimg.engine;

/**
 */
public class TemplateFileFilter extends javax.swing.filechooser.FileFilter {

  public boolean accept(java.io.File file) {
    if (file.getName().toLowerCase().endsWith(".tmpl")) {
      return true;
    } else {
      return false;
    }
  }

  public String getDescription() {
    return "JWebImg Templates";
  }

}

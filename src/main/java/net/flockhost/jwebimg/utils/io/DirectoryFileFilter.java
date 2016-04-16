package net.flockhost.jwebimg.utils.io;

import java.io.File;

/**
 * Filter that only returns directories.
 */
public class DirectoryFileFilter extends javax.swing.filechooser.FileFilter
    implements java.io.FileFilter {

  public boolean accept(File file) {
    if (file.isDirectory()) {
      return true;
    }
    return false;
  }

  public String getDescription() {
    return "Directories";
  }

}

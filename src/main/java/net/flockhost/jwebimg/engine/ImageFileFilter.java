package net.flockhost.jwebimg.engine;

import net.flockhost.jwebimg.config.JWebImgConfig;

import java.io.File;
import java.io.FileFilter;

/**
 * FileFilter for Images. It will let through .jpg .jpeg .png
 * Additionally it will filter out all images, which filename
 * starts with string specified as JWebImgConfig.THUMBNAIL_PREFIX .
 */
public class ImageFileFilter implements FileFilter {

  private JWebImgConfig config = JWebImgConfig.getInstance();

  public boolean accept(File file) {
    String filename = file.getName();
    if (filename.indexOf(config.getThumbnailPrefix()) != -1) {
      return false;
    }

    if (filename.toLowerCase().endsWith(".jpg")) {
      return true;
    }
    if (filename.toLowerCase().endsWith(".jpeg")) {
      return true;
    }
    if (filename.toLowerCase().endsWith(".png")) {
      return true;
    }

    return false;
  }

}

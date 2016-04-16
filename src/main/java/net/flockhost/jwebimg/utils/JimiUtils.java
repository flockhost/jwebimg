package net.flockhost.jwebimg.utils;

import com.sun.jimi.core.Jimi;
import com.sun.jimi.core.JimiException;
import com.sun.jimi.core.JimiWriter;

import java.awt.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Jimi utils.
 */
public class JimiUtils {

  /**
   * Generate thumbnail based on parameters.
   *
   * @param fromFile  - input image file
   * @param toFile    - output file without extension
   * @param maxwidth  - max width in pixel
   * @param maxheight - max height in pixel
   */
  public static void createThumbnail(String fromFile, String toFile, int maxwidth, int maxheight) {

    Image image = null;
    try {
      image = com.sun.jimi.core.JimiUtils.getThumbnail(
          new BufferedInputStream(new FileInputStream(fromFile)),
          maxwidth, maxheight, Jimi.SYNCHRONOUS);
      JimiWriter writer = Jimi.createJimiWriter("image/jpg", new FileOutputStream(toFile + ".jpg"));
      writer.setSource(image);
      writer.putImage(toFile + ".jpg");

    } catch (IOException e) {
      throw new IllegalStateException(e);

    } catch (JimiException e) {
      throw new IllegalStateException(e);
    }

  }
}

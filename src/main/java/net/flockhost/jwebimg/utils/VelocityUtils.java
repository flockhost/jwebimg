package net.flockhost.jwebimg.utils;

import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Velocity utils.
 */
public class VelocityUtils {

  final static Logger LOG = Logger.getLogger(VelocityUtils.class);

  /**
   * Parse the given input file and produce the given output file using the
   * provided hashtable as template context.
   *
   * @param inputFile  - full path to template file
   * @param outputFile - full path to output file
   * @param hashtable  - hashtable containing context
   */
  public static void parseTemplate(String inputFile, String outputFile, Hashtable hashtable) throws IOException {
    LOG.debug("parsing: " + inputFile + " " + outputFile + " " + hashtable);

    //setConfiguration
    String path = getPathFromFile(inputFile);
    String filename = getFilenameFromFile(inputFile);
    LOG.trace(" path: " + path + " filename: " + filename);
    Velocity.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, path);

    try {
      Velocity.init();
    } catch (Exception e) {
      throw new IllegalStateException("" + e, e);
    }
    VelocityContext context = new VelocityContext();

    //add Hashtable to Context
    addHashtableToContext(hashtable, context);

    //create Output
    FileWriter w = new FileWriter(outputFile, false);
    try {
      Velocity.mergeTemplate(filename, Velocity.ENCODING_DEFAULT, context, w);
    } catch (Exception e) {
      throw new IOException("" + e);
    }

    w.flush();
    LOG.debug("finished parsing");
  }

  private static void addHashtableToContext(Hashtable hash, VelocityContext ctx) {
    Enumeration enume = hash.keys();
    while (enume.hasMoreElements()) {
      String key = (String) enume.nextElement();
      ctx.put(key, hash.get(key));
    }
  }

  private static String getPathFromFile(String file) {
    int indLastSlash = getLastFileSeperatorInd(file);

    if (indLastSlash == -1) {
      return ".";
    } else {
      return file.substring(0, indLastSlash);
    }
  }

  private static String getFilenameFromFile(String file) {
    return file.substring(getLastFileSeperatorInd(file) + 1, file.length());
  }

  private static int getLastFileSeperatorInd(String file) {
    int indLastSlash = file.lastIndexOf("/");

    if (indLastSlash == -1)
      return file.lastIndexOf("\\");
    return indLastSlash;
  }

}

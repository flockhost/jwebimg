package net.flockhost.jwebimg.engine;

import net.flockhost.jwebimg.config.JWebImgConfig;
import net.flockhost.jwebimg.utils.JimiUtils;
import net.flockhost.jwebimg.utils.VelocityUtils;
import net.flockhost.jwebimg.utils.io.DirTraverseAction;
import net.flockhost.jwebimg.utils.io.DirectoryFileFilter;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

/**
 * Class that handles the thumbnail creation for each file
 * that is visited.
 */
public class JWebImgDirTraverseAction implements DirTraverseAction {

  final static Logger LOG = Logger.getLogger(JWebImgDirTraverseAction.class);

  /**
   * List of all images found.
   */
  private Vector templateImages = new Vector();
  private Vector templateDirs = new Vector();
  private JWebImgConfig config = JWebImgConfig.getInstance();

  private LogMessageReceiver log;

  public JWebImgDirTraverseAction() {
  }

  public JWebImgDirTraverseAction(LogMessageReceiver log) {
    this.log = log;
  }

  public void performPreAction() {
  }

  public void performFileAction(String path, String filename) {
//log("FILE action: "+path+"  -  "+filename);
    log("processing file: " + filename);

    //scale image
    JimiUtils.createThumbnail(path + "/" + filename,
        path + "/" + config.getThumbnailPrefix() + filename,
        config.getMaxWidth(),
        config.getMaxHeight());

    //add image to tempate
    JWebImgImage timage = new JWebImgImage(filename,
        "" + config.getThumbnailPrefix() + filename + ".jpg",
        0,
        0,
        0);
    templateImages.add(timage);
  }

  public void performDirAction(String path, String dirname) {
//log("DIR action : "+path+"  -  "+dirname);
  }

  public void performPostAction(String path) {

    templateDirs = getSubdirVector(path);

    //parse template and create output
    Hashtable templateContext = new Hashtable();
    templateContext.put("images", templateImages);
    templateContext.put("directories", templateDirs);

    try {
      VelocityUtils.parseTemplate(config.getTemplateFile(), path + "/index.html", templateContext);
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }


    //clear template images
    templateImages = new Vector();
    templateDirs = new Vector();
  }

  private Vector getSubdirVector(String path) {
    Vector result = new Vector();
    result.add(new JWebImgDirectory(".."));

    File directory = new File(path);
    File[] subdirs = directory.listFiles(new DirectoryFileFilter());

    for (int i = 0; i < subdirs.length; i++) {
      result.add(new JWebImgDirectory(subdirs[i].getName()));
    }

    return result;
  }

  private void log(String message) {
    if (log != null) {
      log.append(message);
    } else {
      System.out.println(message);
    }
  }

}

package net.flockhost.jwebimg.engine;

import net.flockhost.jwebimg.config.JWebImgConfig;
import net.flockhost.jwebimg.ui.LogFrame;
import net.flockhost.jwebimg.utils.io.DirTraverseAction;
import net.flockhost.jwebimg.utils.io.DirTraverser;

import java.io.IOException;

/**
 * Thread for running the thumbnail generation.
 */
public class JWebImgThread implements Runnable {

  private LogFrame log;

  /**
   * empty constructor.
   */
  public JWebImgThread() {
  }

  /**
   * This constructor can be used to force all outputs during processing to be displayed
   * in the specified LogFrame.
   */
  public JWebImgThread(LogFrame log) {
    this.log = log;
  }

  /**
   * Start the image-processing-thread (traverse directories, find images, convert images,
   * process template).
   */
  public void run() {
    log("starting ... ");
    JWebImgConfig config = JWebImgConfig.getInstance();
    DirTraverseAction action = new JWebImgDirTraverseAction(log);
    try {
      DirTraverser dir = new DirTraverser(config.getInputPath(), action, new ImageFileFilter());
      dir.traverseDir();
    } catch (IOException ioe) {
      log("traverse: " + ioe);
    }
    log("... finished!");
    log("-----------------------------------");
  }

  public void log(String message) {
    if (log != null) {
      log.append(message);
    } else {
      System.out.println(message);
    }

  }
}

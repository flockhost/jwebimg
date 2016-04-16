package net.flockhost.jwebimg.utils.io;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;

/**
 * this class traverses a directory with the applied fileFilter specified in
 * the constructor. A DirTraverseAction must be specified, which will be
 * applied during traversion.
 */
public class DirTraverser {

  final static Logger LOG = Logger.getLogger(DirTraverser.class);

  private String startDir;
  private DirTraverseAction action;
  private FileFilter filter;

  /**
   * constructor.
   *
   * @param startDir   to start traversing
   * @param action     to perform during traversing
   * @param fileFilter to apply during file processing
   */
  public DirTraverser(final String startDir, final DirTraverseAction action, final FileFilter fileFilter) {
    this.startDir = startDir;
    this.action = action;
    this.filter = fileFilter;
  }

  /**
   * start traversing.
   */
  public void traverseDir() throws IOException {
    traverseDir(startDir);
  }

  private void traverseDir(final String subDirPath) throws IOException {

    File directory = new File(subDirPath);
    //load list of files
    File[] files = directory.listFiles(filter);
    Arrays.sort(files);
    //load list of subdirs
    File[] subdirs = directory.listFiles(new DirectoryFileFilter());

    action.performPreAction();

    //for all files
    for (int i = 0; i < files.length; i++) {
      // action
      action.performFileAction(subDirPath, files[i].getName());
    }

    action.performPostAction(subDirPath);

    //for all subdirs
    for (int i = 0; i < subdirs.length; i++) {
      String dirname = subdirs[i].getName();

      //perform action
      action.performDirAction(subDirPath, dirname);

      //recursion
      traverseDir(subDirPath + "/" + dirname);
    }
  }
}

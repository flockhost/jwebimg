package net.flockhost.jwebimg.utils.io;

/**
 * Dir traversal action.
 */
public interface DirTraverseAction {

  /**
   * This action is performed before the files (including directories) of the
   * current folder are handled.
   */
  public void performPreAction();

  /**
   * This action is performed for every file (not directory).
   *
   * @param path     - path to directory containing the file
   * @param filename - name of the file
   */
  public void performFileAction(String path, String filename);

  /**
   * This action is performed for every directory.
   *
   * @param path    - path to the directory (without the current folder)
   * @param dirname - name of the current folder (without parents)
   */
  public void performDirAction(String path, String dirname);

  /**
   * This action is performed after the files (including directories) of the
   * current folder are handled.
   *
   * @param path
   */
  public void performPostAction(String path);

}

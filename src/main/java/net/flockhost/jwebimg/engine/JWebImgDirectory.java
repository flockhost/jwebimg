package net.flockhost.jwebimg.engine;

/**
 * Bean containing a directory.
 */
public class JWebImgDirectory {

  public JWebImgDirectory(String name) {
    this.name = name;
  }

  private String name;

  public String toString() {
    return name;
  }

  /**
   * Getter for property name.
   *
   * @return Value of property name.
   */
  public java.lang.String getName() {
    return name;
  }

  /**
   * Setter for property name.
   *
   * @param name New value of property name.
   */
  public void setName(java.lang.String name) {
    this.name = name;
  }

}

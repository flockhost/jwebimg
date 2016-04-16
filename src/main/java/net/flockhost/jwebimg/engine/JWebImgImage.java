package net.flockhost.jwebimg.engine;

/**
 * The bean used in the template context.
 */
public class JWebImgImage {

  public JWebImgImage(String name, String thumbnailName, int sizeKb,
                      int width, int height) {
    this.name = name;
    this.thumbnailName = thumbnailName;
    this.sizeKb = sizeKb;
    this.width = width;
    this.height = height;
  }

  public String name;
  public String thumbnailName;
  public int sizeKb;
  public int height;
  public int width;

  public String toString() {
    return name + " (" + thumbnailName + ")";
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

  /**
   * Getter for property thumbnailName.
   *
   * @return Value of property thumbnailName.
   */
  public java.lang.String getThumbnailName() {
    return thumbnailName;
  }

  /**
   * Setter for property thumbnailName.
   *
   * @param thumbnailName New value of property thumbnailName.
   */
  public void setThumbnailName(java.lang.String thumbnailName) {
    this.thumbnailName = thumbnailName;
  }

}

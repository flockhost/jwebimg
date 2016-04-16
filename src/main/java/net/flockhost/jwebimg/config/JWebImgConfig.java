package net.flockhost.jwebimg.config;

/**
 * Singleton config class.
 */
public class JWebImgConfig {

  // singleton instance
  private static JWebImgConfig _instance;

  private int maxWidth = 300;
  private int maxHeight = 300;
  private String thumbnailFilePrefix = "_jwebimg_";
  private String inputPath = "d:/test";
  private String templateFile = "./demo.tmpl";

  public static JWebImgConfig getInstance() {
    if (_instance == null) {
      _instance = new JWebImgConfig();
    }
    return _instance;
  }

  public void setMaxWidth(int maxWidth) {
    this.maxWidth = maxWidth;
  }

  public void setMaxHeight(int maxHeight) {
    this.maxHeight = maxHeight;
  }

  public void setThumbnailFilePrefix(String thumbnailFilePrefix) {
    this.thumbnailFilePrefix = thumbnailFilePrefix;
  }

  public void setInputPath(String inputPath) {
    this.inputPath = inputPath;
  }

  public void setTemplateFile(String templateFile) {
    this.templateFile = templateFile;
  }

  public String getThumbnailPrefix() {
    return thumbnailFilePrefix;
  }

  public int getMaxWidth() {
    return maxWidth;
  }

  public int getMaxHeight() {
    return maxHeight;
  }

  public String getInputPath() {
    return inputPath;
  }

  public String getTemplateFile() {
    return templateFile;
  }
}

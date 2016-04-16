package net.flockhost.jwebimg.engine;

import net.flockhost.jwebimg.config.JWebImgConfig;
import org.junit.Test;

public class JWebImgThreadTest {

  @Test
  public void whenRunTHenOutputIsCreated() {
    // given
    JWebImgConfig config = JWebImgConfig.getInstance();
    config.setInputPath("src/test/resources/input");
    config.setTemplateFile("src/test/resources/tmpl/template.tmpl");
    config.setMaxHeight(100);
    config.setMaxWidth(100);

    JWebImgThread thread = new JWebImgThread();

    // when
    thread.run();

    // then

  }
}
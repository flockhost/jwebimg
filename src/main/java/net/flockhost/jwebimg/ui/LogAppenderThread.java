/*
 * LogAppenderThread.java
 *
 * Created on 30. September 2002, 15:49
 */

package net.flockhost.jwebimg.ui;

import javax.swing.*;

/**
 * A thread dedicated to appending the specified message to the given log frame.
 */
public class LogAppenderThread implements Runnable {

  private final JTextArea log;
  private String message;

  public LogAppenderThread(JTextArea log, String message) {
    this.log = log;
    this.message = message;
  }

  public void run() {
    log.append(message);
  }

}

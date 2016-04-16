package net.flockhost.jwebimg.engine;

/**
 * Log message receiver.
 */
public interface LogMessageReceiver {

  /**
   * Append a message to the log.
   *
   * @param message - message to log
   */
  public void append(String message);
}

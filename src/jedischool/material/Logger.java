package jedischool.material;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jedischool.examples.singleton.SingletonConfiguration;

public class Logger {

  private static final Logger INSTANCE = new Logger();

  private Logger() {
  }

  public static Logger getInstance() {
    return INSTANCE;
  }

  public void log(String msg) {
    if (!SingletonConfiguration.getInstance().isLoggingEnabled()) {
      return;
    }

    String dt = DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now());
    System.out.println(String.format("%s %s - %s", dt, getClass().getName(), msg));
  }
}

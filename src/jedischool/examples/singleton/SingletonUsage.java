package jedischool.examples.singleton;

import jedischool.material.Logger;

public class SingletonUsage {

  private static final Logger logger = Logger.getInstance();

  /**
   * Main Method.
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("Starting Singleton Example App");
    loggingExample1();
    loggingExample2();
    System.out.println("Shutting Singleton Example App");
  }

  private static void loggingExample1() {
    SingletonConfiguration configuration = SingletonConfiguration.getInstance();
    if (configuration.isLoggingEnabled()) {
      System.out.println("This is a log message - 1");
    }
  }

  private static void loggingExample2() {
    logger.log("This is a log message - 2");
  }
}

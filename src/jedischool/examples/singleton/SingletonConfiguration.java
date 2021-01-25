package jedischool.examples.singleton;

/**
 * An example of a Stateful Immuatable Singleton Class.
 */
public class SingletonConfiguration {

  /**
   * A single static instance reference. Object is created when class definition is loaded.
   */
  private static final SingletonConfiguration INSTANCE = new SingletonConfiguration();

  /**
   * A configuration example using an instance variable.
   */
  private boolean loggingEnabled;

  /**
   * A private constructor disallows creation of a new object from outside this class.
   */
  private SingletonConfiguration() {
    // Update Configuration Values
    // This Could be read from a file or DB.
    this.loggingEnabled = true;
  }

  /**
   * Method that allows the user to aquire the reference to the single object in existence.
   *
   * @return SingletonConfiguration
   */
  public static SingletonConfiguration getInstance() {
    return INSTANCE;
  }

  /**
   * Getter method example for configuration.
   *
   * @return boolean
   */
  public boolean isLoggingEnabled() {
    return loggingEnabled;
  }
}

package jedischool.examples.command;

public class CommandExample {

  /**
   * Main!
   *
   * @param args
   */
  public static void main(String[] args) {
    // Singletons?
    Television tv = new Television();
    NuclearReactor reactor = new NuclearReactor();

    Command switchOnCommand = new SwitchOnCommand();

    // Alexa switch on the tv
    switchOnCommand.execute(tv);

    // Alexa switch on the nuclear reactor
    switchOnCommand.execute(reactor);
  }

  // ==============================================================
  // DEVICES
  // ==============================================================

  public interface OnOffDevice {
    public void switchOn();

    public void switchOff();
  }

  public static class Television implements OnOffDevice {

    @Override
    public void switchOn() {
      System.out.println("Switching On the Television");
    }

    @Override
    public void switchOff() {
      System.out.println("Switching Off the Television");
    }
  }

  public static class NuclearReactor implements OnOffDevice {

    @Override
    public void switchOn() {
      System.out.println("Retracting Control Rods to Increase Fission");
    }

    @Override
    public void switchOff() {
      System.out.println("Immersing Control Rods to Decrease Fission");
    }
  }

  // ==============================================================
  // COMMANDS
  // ==============================================================

  public interface Command {
    public void execute(OnOffDevice device);
  }

  public static class SwitchOnCommand implements Command {

    @Override
    public void execute(OnOffDevice device) {
      device.switchOn();
    }
  }

  public static class SwitchOffCommand implements Command {

    @Override
    public void execute(OnOffDevice device) {
      device.switchOff();
    }
  }
}

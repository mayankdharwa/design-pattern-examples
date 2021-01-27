package jedischool.examples.factory;

public class MethodFactoryExample {

  public static void main(String[] args) {
    SpaceCrew crew = new SithSpaceCrew();

    crew.flySpaceShip();
  }

  public static abstract class SpaceCrew {

    // Factory Method
    protected abstract SpaceShip acquireSpaceShip();

    public void flySpaceShip() {
      System.out.println(String.format("%s is ready to fly!", getClass().getSimpleName()));

      SpaceShip ship = acquireSpaceShip();

      ship.fly();
    }
  }

  // ==============================================================
  // Space Crews
  // ==============================================================

  public static class JediSpaceCrew extends SpaceCrew {

    @Override
    public SpaceShip acquireSpaceShip() {
      return new JediSpaceShip();
    }
  }

  public static class SithSpaceCrew extends SpaceCrew {

    @Override
    public SpaceShip acquireSpaceShip() {
      return new SithSpaceShip();
    }
  }

  // ==============================================================
  // Space Ships
  // ==============================================================
  public interface SpaceShip {
    public void fly();
  }

  public static class JediSpaceShip implements SpaceShip {

    @Override
    public void fly() {
      String name = getClass().getSimpleName();
      System.out.println(String.format("%s is going into Jedi controlled hyperspace!!", name));
    }
  }

  public static class SithSpaceShip implements SpaceShip {

    @Override
    public void fly() {
      String name = getClass().getSimpleName();
      System.out.println(String.format("%s is going into Sith controlled hyperspace!!", name));
    }
  }

}

package jedischool.examples.factory;

public class SpaceShipDefinition {

  public interface SpaceShip {
    public default void fly() {
      System.out
          .println(String.format("%s is going into Hyperspace!!", getClass().getSimpleName()));
    }
  }

  public interface SpaceCrew {
    public default void flySpaceShip(SpaceShip ship) {
      System.out.println(String.format("%s is ready to fly!", getClass().getSimpleName()));
      ship.fly();
    }
  }

  // ==============================================================
  // Some SpaceShips
  // ==============================================================
  public static class MillenniumFalcon implements SpaceShip {
  }

  public static class XWing implements SpaceShip {
  }

  public static class StarFighter implements SpaceShip {
  }

  // ==============================================================
  // Jedi Objects
  // ==============================================================
  public static class JediSpaceShip implements SpaceShip {
  }

  public static class JediSpaceCrew implements SpaceCrew {
  }

  // ==============================================================
  // Sith Objects
  // ==============================================================
  public static class SithSpaceShip implements SpaceShip {
  }

  public static class SithSpaceCrew implements SpaceCrew {
  }
}

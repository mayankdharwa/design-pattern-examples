package jedischool.examples.factory;

import jedischool.examples.factory.SpaceShipDefinition.MillenniumFalcon;
import jedischool.examples.factory.SpaceShipDefinition.SpaceShip;
import jedischool.examples.factory.SpaceShipDefinition.StarFighter;
import jedischool.examples.factory.SpaceShipDefinition.XWing;

public class StaticFactoryExample {

  public static void main(String[] args) {
    // Should be singleton.
    SpaceShipFactory factory = new SpaceShipFactory();

    SpaceShip ship = factory.getSpaceShip("MillenniumFalcon");

    System.out.println("Received " + ship.getClass().getSimpleName());
  }

  // ==============================================================
  // Factory Class
  // ==============================================================

  public static class SpaceShipFactory {

    public SpaceShip getSpaceShip(String name) {
      switch (name) {
        case "MillenniumFalcon":
          return new MillenniumFalcon();
        case "XWing":
          return new XWing();
        case "StarFighter":
          return new StarFighter();
        default:
          throw new RuntimeException("We do not manufacture " + name);
      }
    }
  }
}

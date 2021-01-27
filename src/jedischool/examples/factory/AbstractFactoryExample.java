package jedischool.examples.factory;

import jedischool.examples.factory.SpaceShipDefinition.JediSpaceCrew;
import jedischool.examples.factory.SpaceShipDefinition.JediSpaceShip;
import jedischool.examples.factory.SpaceShipDefinition.SithSpaceCrew;
import jedischool.examples.factory.SpaceShipDefinition.SithSpaceShip;
import jedischool.examples.factory.SpaceShipDefinition.SpaceCrew;
import jedischool.examples.factory.SpaceShipDefinition.SpaceShip;

public class AbstractFactoryExample {

  public static void main(String[] args) {
    beginMission(new JediFactory());
  }

  private static void beginMission(StarWarsFactory factory) {
    SpaceShip ship = factory.createSpaceShip();
    SpaceCrew crew = factory.createSpaceCrew();

    crew.flySpaceShip(ship);
  }

  // ==============================================================
  // Factory Class
  // ==============================================================

  public static abstract class StarWarsFactory {

    public abstract SpaceShip createSpaceShip();

    public abstract SpaceCrew createSpaceCrew();
  }

  public static class JediFactory extends StarWarsFactory {

    @Override
    public SpaceShip createSpaceShip() {
      return new JediSpaceShip();
    }

    @Override
    public SpaceCrew createSpaceCrew() {
      return new JediSpaceCrew();
    }
  }

  public static class SithFactory extends StarWarsFactory {

    @Override
    public SpaceShip createSpaceShip() {
      return new SithSpaceShip();
    }

    @Override
    public SpaceCrew createSpaceCrew() {
      return new SithSpaceCrew();
    }
  }
}

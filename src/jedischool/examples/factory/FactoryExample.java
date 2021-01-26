package jedischool.examples.factory;

public class FactoryExample {

  public static void main(String[] args) {
    // Should be singleton.
    IceCreamFactory factory = new IceCreamFactory();

    IceCream ic = factory.getIceCream(Flavour.MANGO);

    System.out.println("Received " + ic.getClass().getSimpleName());
  }

  // ==============================================================
  // Ice Cream Objects
  // ==============================================================
  public enum Flavour {
    VANILLA,
    CHOCOLATE,
    STRAWBERRY,
    MANGO
  }

  public interface IceCream {
  }

  public static class ChocolateIceCream implements IceCream {
    // some methods
  }

  public static class VanillaIceCream implements IceCream {
    // some methods
  }

  public static class StrawberryIceCream implements IceCream {
    // some methods
  }

  public static class MangoIceCream implements IceCream {
    // some methods
  }

  // ==============================================================
  // Ice Cream Factory
  // ==============================================================
  public static class IceCreamFactory {

    public IceCream getIceCream(Flavour flavour) {
      switch (flavour) {
        case VANILLA:
          return new VanillaIceCream();
        case CHOCOLATE:
          return new ChocolateIceCream();
        case STRAWBERRY:
          return new StrawberryIceCream();
        case MANGO:
          return new MangoIceCream();
        default:
          throw new RuntimeException("We do not manufacture " + flavour + " flavour");
      }
    }
  }
}

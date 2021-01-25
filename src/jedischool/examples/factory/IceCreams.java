package jedischool.examples.factory;

public class IceCreams {

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
}

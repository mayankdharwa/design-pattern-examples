package jedischool.examples.factory;

import jedischool.examples.factory.IceCreams.ChocolateIceCream;
import jedischool.examples.factory.IceCreams.Flavour;
import jedischool.examples.factory.IceCreams.IceCream;
import jedischool.examples.factory.IceCreams.MangoIceCream;
import jedischool.examples.factory.IceCreams.StrawberryIceCream;
import jedischool.examples.factory.IceCreams.VanillaIceCream;

public class IceCreamFactory {

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

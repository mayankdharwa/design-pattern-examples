package jedischool.examples.decorator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DecoratorExample {

  public static void main(String[] args) {
    Order order = new OrderImpl();

    order.add(new Food(FoodType.BURGER, "Cheese Burger", 120.0));
    order.add(new Food(FoodType.BURGER, "Hamburger", 180.0));
    order.add(new Food(FoodType.FRIES, "Large Fries", 80.0));

    System.out.println("Order Total: " + order.getOrderTotal());

    System.out.println("Item Wise Total: " + new TypeTotalDecorator(order).getTypeWiseTotal());
    System.out.println("Extra Free Fries: " + new FreeFriesDecorator(order).eligibleForFreeFries());
  }

  // ==============================================================
  // Decorators
  // ==============================================================

  /**
   * Abstract Class for Decorators to extend from. Provides the funtionality of the Order class by
   * delegation.
   */
  public abstract static class AbstractOrderDecorator implements Order {
    private Order order;

    public AbstractOrderDecorator(Order order) {
      this.order = order;
    }

    @Override
    public void add(Food food) {
      order.add(food);
    }

    @Override
    public List<Food> getFoods() {
      return order.getFoods();
    }

    @Override
    public Double getOrderTotal() {
      return order.getOrderTotal();
    }

    public Order getOrder() {
      return order;
    }
  }

  /**
   * Extra Functionality: Returns total cost for each FoodType.
   */
  public static class TypeTotalDecorator extends AbstractOrderDecorator {

    public TypeTotalDecorator(Order order) {
      super(order);
    }

    public Map<FoodType, Double> getTypeWiseTotal() {
      return getFoods().stream()
          .collect(Collectors.toMap(Food::getType, Food::getPrice, (p1, p2) -> p1 + p2));
    }
  }

  /**
   * Extra Functionality: Check Eligibility for Free Fries. (Buy Burgers worth 200)
   */
  public static class FreeFriesDecorator extends AbstractOrderDecorator {

    public FreeFriesDecorator(Order order) {
      super(order);
    }

    public boolean eligibleForFreeFries() {
      return getFoods().stream()
          .filter(f -> FoodType.BURGER == f.getType())
          .mapToDouble(Food::getPrice)
          .sum() >= 200.0;
    }
  }

  // ==============================================================
  // Order and Food Classes
  // ==============================================================

  public enum FoodType {
    BURGER,
    FRIES
  }

  public interface Order {

    void add(Food food);

    List<Food> getFoods();

    Double getOrderTotal();
  }

  public static class OrderImpl implements Order {
    private List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
      foods.add(food);
    }

    @Override
    public Double getOrderTotal() {
      return foods.stream().mapToDouble(Food::getPrice).sum();
    }

    @Override
    public List<Food> getFoods() {
      return foods;
    }
  }

  public static class Food {
    private String name;

    private FoodType type;

    private Double price;

    public Food(FoodType type, String name, Double price) {
      this.type = type;
      this.name = name;
      this.price = price;
    }

    public String getName() {
      return name;
    }

    public FoodType getType() {
      return type;
    }

    public Double getPrice() {
      return price;
    }
  }
}

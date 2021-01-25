package jedischool.examples.strategy;

public class StrategyExample {

  public static void main(String[] args) {
    Droid droid = new B1Droid(new ShootToKillBehaviour());
    droid.behave();

    droid.setBehaviour(new PatrolBehaviour());
    droid.behave();

    //
  }

  // ==============================================================
  // Droid
  // ==============================================================

  public interface Droid {
    public void behave();

    public void setBehaviour(DroidBehaviour behaviour);
  }

  public static class B1Droid implements Droid {

    private DroidBehaviour behaviour;

    public B1Droid(DroidBehaviour behaviour) {
      setBehaviour(behaviour);
    }

    @Override
    public void behave() {
      behaviour.behave();
    }

    public void setBehaviour(DroidBehaviour behaviour) {
      this.behaviour = behaviour;
    }
  }

  // ==============================================================
  // Strategy
  // ==============================================================

  public interface DroidBehaviour {
    public void behave();
  }

  public static class ShootToKillBehaviour implements DroidBehaviour {

    @Override
    public void behave() {
      System.out.println("Blast 'em!");
    }
  }

  public static class StunBehaviour implements DroidBehaviour {

    @Override
    public void behave() {
      System.out.println("Stun the Enemies!");
    }
  }

  public static class PatrolBehaviour implements DroidBehaviour {

    @Override
    public void behave() {
      System.out.println("Patrolling the parameters");
    }
  }

  public static class DefendItemBehaviour implements DroidBehaviour {

    @Override
    public void behave() {
      System.out.println("Defending!");
    }
  }
}

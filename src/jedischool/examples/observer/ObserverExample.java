package jedischool.examples.observer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import jedischool.material.Sleeper;

public class ObserverExample {

  public static void main(String[] args) {
    Anakin anakin = new Anakin();
    Palpatine palpatine = new Palpatine();

    // We will watch your career with great interest!
    anakin.subscribe(palpatine);

    anakin.post("I'm the fastest Pod Racer in the Galaxy");

    Sleeper.sleep(2000);
    anakin.post("I'm the most powerful Jedi in the Galaxy");

    Sleeper.sleep(2000);
    anakin.post("I'm the chosen one! I'll bring balance to the Force.");
  }

  // ==============================================================
  // IMPLEMENTATIONS
  // ==============================================================

  public static class Palpatine implements Observer {

    @Override
    public void onUpdate(Observable observable) {
      String msg = String.format("%s posted: %s", observable.getClass().getSimpleName(),
          observable.getUpdate());
      System.out.println(msg);
    }
  }

  public static class Anakin implements Observable {

    private Set<Observer> observers = new HashSet<>();

    // This collection simulates a DB.
    private Deque<String> posts = new ArrayDeque<>();

    @Override
    public void subscribe(Observer observer) {
      observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
      observers.remove(observer);
    }

    public void post(String message) {
      posts.add(message);
      for (Observer observer : observers) {
        observer.onUpdate(this);
      }
    }

    /**
     * Returns the last posted message.
     */
    @Override
    public String getUpdate() {
      return posts.peekLast();
    }
  }

  // ==============================================================
  // OBSERVER
  // ==============================================================

  public interface Observer {
    public void onUpdate(Observable observable);
  }

  public interface Observable {
    public void subscribe(Observer observer);

    public void unsubscribe(Observer observer);

    public String getUpdate();
  }

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}

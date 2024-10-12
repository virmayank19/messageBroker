package api;

public class SimpleSubscriber implements ISubscriber {

  private final String id;

  public SimpleSubscriber(String id) {
    this.id = id;
  }

  @Override
  public String getId() {
    return this.id;
  }

  @Override
  public void consume(String message) {
    System.out.println("Message received for Subscriber: " + this.id + ", message:" + message);
  }
}

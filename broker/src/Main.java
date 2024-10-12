import api.Publisher;
import api.Queue;
import api.SimpleSubscriber;
import topic.Topic;

public class Main {

  public static void main(String[] args) {
    System.out.println("Hello world!");
    Publisher pub1 = new Publisher();
    Queue queue = new Queue();
    Topic t1 = queue.createTopic("t1");
    Topic t2 = queue.createTopic("t2");
    SimpleSubscriber subscriber = new SimpleSubscriber("Sub1");
    SimpleSubscriber subscriber2 = new SimpleSubscriber("Sub2");

    queue.subscribe(subscriber, t1);
    queue.subscribe(subscriber, t2);
    queue.subscribe(subscriber2, t1);

    pub1.publish(t1, "Msg1");
    pub1.publish(t1, "Msg2");
    pub1.publish(t2, "Msg3");
  }
}
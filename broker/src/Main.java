import api.Publisher;
import api.Queue;
import api.SimpleSubscriber;
import com.google.inject.Guice;
import com.google.inject.Injector;
import config.ExecutorModule;
import entity.Message;
import topic.Topic;

public class Main {

  public static void main(String[] args) {
    System.out.println("Hello world!");
    Injector injector = Guice.createInjector(new ExecutorModule());
    Publisher pub1 = injector.getInstance(Publisher.class);
    Queue queue = injector.getInstance(Queue.class);
    Topic t1 = queue.createTopic("t1");
    Topic t2 = queue.createTopic("t2");
    SimpleSubscriber subscriber = new SimpleSubscriber("Sub1");
    SimpleSubscriber subscriber2 = new SimpleSubscriber("Sub2");

    queue.subscribe(subscriber, t1);
    queue.subscribe(subscriber, t2);
    queue.subscribe(subscriber2, t1);

    pub1.publish(t1, new Message("Msg1"));
    pub1.publish(t1, new Message("Msg2"));
    pub1.publish(t2, new Message("Msg3"));
  }
}
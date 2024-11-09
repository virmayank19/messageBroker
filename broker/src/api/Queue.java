package api;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import topic.Topic;

public class Queue {

  @Inject
  @Named("messageDeliveryPool")
  private ExecutorService messageDeliveryPool;

  @Inject
  @Named("functionCallPool")
  private ExecutorService functionCallPool;

  public Queue() {

  }

  public Topic createTopic(String topicName) {
    final Topic topic = new Topic(topicName, UUID.randomUUID().toString(), messageDeliveryPool);
    System.out.println("Created topic: " + topic.getTopicName());
    return topic;
  }

  public void subscribe(ISubscriber subscriber, Topic topic) {
    topic.addSubscriber(subscriber);
    System.out.println(subscriber.getId() + " subscribed to topic: " + topic.getTopicName());
  }
}

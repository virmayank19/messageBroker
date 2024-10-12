package api;

import java.util.UUID;
import topic.Topic;

public class Queue {

  public Topic createTopic(String topicName) {
    final Topic topic = new Topic(topicName, UUID.randomUUID().toString());
    System.out.println("Created topic: " + topic.getTopicName());
    return topic;
  }

  public void subscribe(ISubscriber subscriber, Topic topic) {
    topic.addSubscriber(subscriber);
    System.out.println(subscriber.getId() + " subscribed to topic: " + topic.getTopicName());
  }
}

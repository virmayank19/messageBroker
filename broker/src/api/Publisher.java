package api;

import entity.Message;
import topic.Topic;

public class Publisher {

  public void publish(Topic topic, Message message) {
    System.out.println(message + " published to topic: " + topic.getTopicName());
    topic.addMessage(message);
  }
}

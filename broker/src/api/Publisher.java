package api;

import topic.Topic;

public class Publisher {

  public void publish(Topic topic, String message) {
    System.out.println(message + " published to topic: " + topic.getTopicName());
    topic.addMessage(message);
  }
}

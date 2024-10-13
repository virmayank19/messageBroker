package topic;

import api.ISubscriber;
import entity.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Topic {

  private final String topicId;
  private final String topicName;

  private HashMap<String, ISubscriber> idVsSubscribers;
  private List<Message> messages;

  public Topic(String topicId, String topicName) {
    this.topicId = topicId;
    this.topicName = topicName;
    this.idVsSubscribers = new HashMap<>();
    this.messages = new ArrayList<>();
  }

  private void supplyMessageToConsumer(Message message) {
    for (var sub : idVsSubscribers.values()) {
      sub.consume(message);
    }
  }

  public void addMessage(Message message) {
    synchronized (this) {
      this.messages.add(message);
      this.supplyMessageToConsumer(message);
    }
  }

  public void addSubscriber(ISubscriber subscriber) {
    this.idVsSubscribers.put(subscriber.getId(), subscriber);
  }

  public String getTopicName() {
    return topicName;
  }
}

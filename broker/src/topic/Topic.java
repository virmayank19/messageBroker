package topic;

import api.ISubscriber;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import entity.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class Topic {

  private final String topicId;
  private final String topicName;
  @Inject
  @Named("messageDeliveryPool")
  private final ExecutorService messageDeliveryPool;
  private HashMap<String, ISubscriber> idVsSubscribers;
  private List<Message> messages;

  public Topic(String topicId, String topicName, ExecutorService executorService) {
    this.topicId = topicId;
    this.topicName = topicName;
    this.idVsSubscribers = new HashMap<>();
    this.messages = new ArrayList<>();
    this.messageDeliveryPool = executorService;
  }

  private void supplyMessageToConsumer(Message message) {
    for (var sub : idVsSubscribers.values()) {
      messageDeliveryPool.submit(() -> sub.consume(message));
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

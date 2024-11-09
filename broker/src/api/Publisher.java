package api;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import entity.Message;
import java.util.concurrent.ExecutorService;
import topic.Topic;

public class Publisher {

  private ExecutorService functionCallPool;

  @Inject
  public Publisher(@Named("functionCallPool") ExecutorService functionCallPool) {
    this.functionCallPool = functionCallPool;
  }

  public void publish(Topic topic, Message message) {
    functionCallPool.submit(() -> {
      System.out.println(message + " published to topic: " + topic.getTopicName());
      topic.addMessage(message);
    });
  }
}

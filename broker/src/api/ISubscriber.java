package api;

import entity.Message;

public interface ISubscriber {

  String getId();

  void consume(Message message);

}

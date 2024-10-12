package api;

public interface ISubscriber {

  String getId();

  void consume(String message);

}

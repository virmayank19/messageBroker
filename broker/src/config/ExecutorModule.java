package config;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorModule extends AbstractModule {

  @Provides
  @Named("functionCallPool")
  private ExecutorService provideFunctionCallPool() {
    return Executors.newFixedThreadPool(5);
  }

  @Provides
  @Named("messageDeliveryPool")
  private ExecutorService provideMessageDeliveryPool() {
    return Executors.newFixedThreadPool(10);
  }

  @Override
  protected void configure() {

  }
}
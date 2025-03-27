package com.food.food_order_tracking_service.services;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.stereotype.Service;

@Service
public class OrderStreamProcessor {

  public void processStream(KStream<String, String> stream) {
    stream.foreach(
        (key, value) -> {
          System.out.println("Stream Processing - Key: " + key + ", Value: " + value);
        });
  }
}

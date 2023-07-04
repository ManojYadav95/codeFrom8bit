package com.example.kafka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KafkaCTest {
	public static void main(String[] args) {

		String topic = "TEST";
		String group = "Employee";
	      Properties props = new Properties();
	      props.put("bootstrap.servers", "localhost:9092");
	      props.put("group.id", group);
	      props.put("enable.auto.commit", "true");
	      props.put("auto.commit.interval.ms", "1000");
	      props.put("session.timeout.ms", "30000");
	      props.put("key.deserializer",          
	         "org.apache.kafka.common.serialization.StringDeserializer");
	      props.put("value.deserializer", 
	         "org.apache.kafka.common.serialization.StringDeserializer");
	      KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
	      consumer.subscribe(Arrays.asList(topic));
	      System.out.println("Subscribed to topic " + topic);
	      int i = 0;
	         
	      while (true) {
	    	  System.out.println("asdd");
	         ConsumerRecords<String, String> records = consumer.poll(100);
	            for (ConsumerRecord<String, String> record : records)
	               System.err.printf("offset = %d, key = %s, value = %s\n", 
	               record.offset(), record.key(), record.value());
	      }   
	}
}
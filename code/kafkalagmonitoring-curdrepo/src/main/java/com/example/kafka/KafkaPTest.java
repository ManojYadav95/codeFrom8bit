package com.example.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KafkaPTest {
	
	public static void main(String[] args) throws InterruptedException {

		String topicName = "GO";
	      Properties props = new Properties();
	      
	      props.put("bootstrap.servers", "localhost:9092");
	      
	      props.put("acks", "all");
	      
	      props.put("retries", 0);
	      
	      props.put("batch.size", 16384);
	      
	      props.put("linger.ms", 1);
	      
	      props.put("buffer.memory", 33554432);
	      
	      props.put("key.serializer", 
	         "org.apache.kafka.common.serialization.StringSerializer");
	         
	      props.put("value.serializer", 
	         "org.apache.kafka.common.serialization.StringSerializer");
	      
	      Producer<String, String> producer = new KafkaProducer
	         <String, String>(props);
	            
	      int count=0;
	      while(true) {
	         producer.send(new ProducerRecord<String, String>( topicName,
	            Integer.toString(count++), Integer.toString(count++)));
	               System.out.println("Message sent successfully");
	               Thread.sleep(1000);
	      }
	   
	}
}

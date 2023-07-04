//package com.example.kafka.configuration;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.kafka.clients.CommonClientConfigs;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.config.SslConfigs;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class KafkaConfiguration {
//
//    @Value("${spring.kafka.ssl.key-store-location}")
//    private String keyStoreLocation;
//
//    @Value("${spring.kafka.ssl.key-store-password}")
//    private String keyStorePassword;
//
//    @Value("${spring.kafka.ssl.key-store-type}")
//    private String keyStoreType;
//
//    @Value("${spring.kafka.ssl.key-password}")
//    private String keyPassword;
//
//    @Value("${spring.kafka.ssl.trust-store-location}")
//    private String trustStoreLocation;
//
//    @Value("${spring.kafka.ssl.trust-store-password}")
//    private String trustStorePassword;
//
//    @Value("${spring.kafka.ssl.trust-store-type}")
//    private String trustStoreType;
//
//    @Bean
//    public KafkaProducer<String, String> KafkaProducer() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9093");
//        // SSL Configuration
//        configProps.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SSL");
//        configProps.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, keyStoreLocation);
//        configProps.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, keyStorePassword);
//        configProps.put(SslConfigs.SSL_KEYSTORE_TYPE_CONFIG, keyStoreType);
//        configProps.put(SslConfigs.SSL_KEY_PASSWORD_CONFIG, keyPassword);
//        configProps.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, trustStoreLocation);
//        configProps.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, trustStorePassword);
//        configProps.put(SslConfigs.SSL_TRUSTSTORE_TYPE_CONFIG, trustStoreType);
//
//        return new KafkaProducer<>(configProps);
//    }
//
//    @Bean
//    public KafkaConsumer<String, String> KafkaConsumer() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9093");
//        // SSL Configuration
//        configProps.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "SSL");
//        configProps.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, keyStoreLocation);
//        configProps.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, keyStorePassword);
//        configProps.put(SslConfigs.SSL_KEYSTORE_TYPE_CONFIG, keyStoreType);
//        configProps.put(SslConfigs.SSL_KEY_PASSWORD_CONFIG, keyPassword);
//        configProps.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, trustStoreLocation);
//        configProps.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, trustStorePassword);
//        configProps.put(SslConfigs.SSL_TRUSTSTORE_TYPE_CONFIG, trustStoreType);
//
//        return new KafkaConsumer<>(configProps);
//    }
//}

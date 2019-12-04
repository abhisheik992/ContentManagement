package com.km.admin.config;

import org.springframework.context.annotation.Configuration;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.km.admin.model.Content;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class KafkaConfig {
	
	 @Bean
	    public ProducerFactory<String, Content> producerFactory() {
	        Map<String, Object> config = new HashMap<>();

	        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.0.155:9092");
	        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

	        return new DefaultKafkaProducerFactory<>(config);
	    }


	    @Bean
	    public KafkaTemplate<String, Content> kafkaTemplate() {
	        return new KafkaTemplate<>(producerFactory());
	    }


}

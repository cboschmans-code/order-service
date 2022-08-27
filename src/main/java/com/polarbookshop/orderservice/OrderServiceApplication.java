package com.polarbookshop.orderservice;

import com.polarbookshop.orderservice.order.domain.OrderService;
import com.polarbookshop.orderservice.order.event.OrderDispatchedMessage;
import com.polarbookshop.orderservice.order.event.OrderFunctions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;

@SpringBootApplication
@ConfigurationPropertiesScan
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}


}

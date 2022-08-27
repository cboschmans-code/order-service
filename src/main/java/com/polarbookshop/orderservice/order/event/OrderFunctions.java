package com.polarbookshop.orderservice.order.event;

import com.polarbookshop.orderservice.order.domain.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;

@Configuration
@Component
public class OrderFunctions {
   private static final Logger log= LoggerFactory.getLogger(OrderFunctions.class);

    @Bean
    public Consumer<Flux<OrderDispatchedMessage>> dispatchOrder(OrderService orderService){
        return  flux -> orderService.consumeOrderDispatchedEvent(flux)
                .doOnNext(order -> log.info("The order with id {}  is dispatched.",order.id())).subscribe();
    }
}

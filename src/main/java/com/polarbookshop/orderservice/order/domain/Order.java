package com.polarbookshop.orderservice.order.domain;

import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table("orders")
public record Order(
        @Id
        Long id,
        String bookIsbn,
        String bookName,
        Double bookPrice,
        Integer quantity,
        OrderStatus status,
        @CreatedDate
        Instant createdDate,

        @LastModifiedDate
        Instant lastModifiedDate,

        @Version
        int Version,
        @CreatedBy
        String createdBy,
        @LastModifiedBy
        String lastModifiedBy
) {
    public static Order of(String bookIsbn, String bookName, Double bookPrize, Integer quantity, OrderStatus status) {
        return new Order(null, bookIsbn, bookName, bookPrize, quantity, status, null, null, 0,null,null);
    }
}

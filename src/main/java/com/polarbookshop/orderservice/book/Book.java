package com.polarbookshop.orderservice.book;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

public record Book(
        String isbn,
        String title,
        String author,
        Double price

) {

}

package com.factoria.marketplace.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void shouldHaveACommentsCounter() {
        // GIVEN (escenari)
        var product = new Product();
        var comment = new Comment();
//        product.setCommentsList(List.of(comment));
        product.addComment(comment);
            // sut SYSTEM UNDER TEST
        var sut = product.commentsCount();


        // THEN
        assertThat(sut, equalTo(1));

    }
}
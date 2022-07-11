package com.factoria.marketplace.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String img;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Comment> commentsList = new ArrayList<>();

    public void addComment(Comment comment) {
        this.commentsList.add(comment);
    }

    @JsonSerialize
    public int commentsCount() {
        return this.commentsList.size();
    }
}

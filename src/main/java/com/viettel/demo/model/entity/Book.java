package com.viettel.demo.model.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "book", schema = "public", catalog = "library_management")
public class Book {
    @Id
    @Column(name = "book_id")
    private int bookId;
    @Basic
    @Column(name = "author")
    private String author;
    @Basic
    @Column(name = "publisher")
    private String publisher;
    @Basic
    @Column(name = "published_date")
    private Timestamp publishedDate;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "total_pages")
    private Integer totalPages;
    @Basic
    @Column(name = "rating")
    private Integer rating;
    @Basic
    @Column(name = "isbn")
    private String isbn;
    @Basic
    @Column(name = "best_seller")
    private Boolean bestSeller;

}

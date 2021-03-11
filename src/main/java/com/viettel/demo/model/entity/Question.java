package com.viettel.demo.model.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "question", schema = "public", catalog = "library_management")
public class Question {
    @Id
    @Column(name = "question_id")
    private int questionId;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private Account accountByAccountId;

}

package com.viettel.demo.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "account", schema = "public", catalog = "library_management")
public class Account {
    @Id
    @Column(name = "account_id")
    private int accountId;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "accountByAccountId")
    private Collection<Question> questionsByAccountId;

}

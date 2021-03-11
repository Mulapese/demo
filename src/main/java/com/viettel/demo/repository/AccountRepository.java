package com.viettel.demo.repository;

import com.viettel.demo.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface AccountRepository extends JpaRepository<Account, Integer>,
        QuerydslPredicateExecutor<Account> {

}

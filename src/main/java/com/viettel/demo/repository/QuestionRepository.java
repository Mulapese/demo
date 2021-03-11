package com.viettel.demo.repository;

import com.viettel.demo.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface QuestionRepository extends JpaRepository<Question, Integer>,
        QuerydslPredicateExecutor<Question> {
}

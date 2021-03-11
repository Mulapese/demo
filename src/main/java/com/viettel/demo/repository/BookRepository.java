package com.viettel.demo.repository;

import com.viettel.demo.model.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>,
        QuerydslPredicateExecutor<Book> {
//    // Using function name
//    List<BookEntity> findAll();    // Using function name
//    List<BookEntity> findAll();
    // Using JPQL in 1 table
    @Query("select b from Book b")
    Page<Book> findAllUsingJPQL(Specification<Book> specs, Pageable pageable);

    @Query("select b from Book b")
    Page<Book> findAllUsingJPQLPagingAndSorting(Pageable pageable);

//    List<BookEntity> queryFromQuerydsl();
//    @Override
//    default public void customize(
//            QuerydslBindings bindings, QBookEntity root) {
//        bindings.bind(String.class)
//                .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
//    }
}

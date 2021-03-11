package com.viettel.demo.service;

import com.querydsl.jpa.impl.JPAQuery;
import com.viettel.demo.model.entity.Book;
import com.viettel.demo.model.entity.QAccount;
import com.viettel.demo.model.entity.QBook;
import com.viettel.demo.model.entity.QQuestion;
import com.viettel.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public Page<Book> findAllUsingFunctionName(Pageable pageable){
        return bookRepository.findAll(pageable);
    }

    public Page<Book> findAllUsingJPQL(Specification<Book> specs, Pageable pageable){
        return bookRepository.findAllUsingJPQL(Specification.where(specs), pageable);
    }

    public Page<Book> findAllUsingJPQLPagingAndSorting(Pageable pageable){
        return bookRepository.findAllUsingJPQLPagingAndSorting(pageable);
    }

    public List<Book> queryFromQuerydsl(){
        QBook customer = QBook.book;
        QAccount account = QAccount.account;
        QQuestion question = QQuestion.question;
        JPAQuery<?> query = new JPAQuery<Void>(entityManager);
        List<Book> bob = query.select(customer).from(customer).fetch();
        return bob;
    }
//
//    public List<Book> queryFromQuerydslWithJoin(){
//        QAccount account = QAccount.account;
//        QQuestion question = QQuestion.question;
//        JPAQuery<?> query = new JPAQuery<Void>(entityManager);
//        query.from(question)
//                .innerJoin(account)
//                .where(question.accountByAccountId.accountId.eq(account.accountId))
//                .select(account).fetch();
//        return null;
//    }

//    public List<BookEntity> queryFromQuerydsl(){
//        JPAQuery<BookEntity> query = new JPAQuery<>(em);
//        final QBookEntity bookEntity = QBookEntity.bookEntity;
//
//        return query.from(bookEntity).where(bookEntity.title.eq("Aliens And Heroes")).fetch();
//
//    }

//    public Iterable<BookEntity> queryFromQuerydsl(){
//        MyUserPredicatesBuilder builder = new MyUserPredicatesBuilder()
//                .with("title", ":", "Knight Of Eternity");
//
//        Iterable<BookEntity> results = bookRepository.findAll(builder.build());
//        return results;
//    }
}

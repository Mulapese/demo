package com.viettel.demo.controller;

import com.viettel.demo.model.entity.Book;
import com.viettel.demo.service.BookService;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.GreaterThan;
import net.kaczmarzyk.spring.data.jpa.domain.LessThan;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    // In reality, change function name "getBooksUsingJPQT" to "getBooks"
    // JPQL + Paging + Sorting
    @GetMapping("/v0")
    public ResponseEntity<Page<Book>> getBooksUsingJPQTPagingAndSorting(Pageable pageable) {
        Page<Book> bookEntities = bookService.findAllUsingJPQLPagingAndSorting(pageable);
        return new ResponseEntity<>(bookEntities, HttpStatus.OK);
    }

    // In reality, change function name "getBooksUsingFunctionName" to "getBooks"
    @GetMapping("/v1")
    public ResponseEntity<Page<Book>> getBooksUsingFunctionName(
            @And({
                    @Spec(path = "bookId", params = "bookId", spec = Equal.class),
                    @Spec(path = "rating", params = "ratingGreater", spec = GreaterThan.class),
                    @Spec(path = "rating", params = "ratingSmaller", spec = LessThan.class)
            }) Specification<Book> specs,
            Pageable pageable) {
        Page<Book> bookEntities = bookService.findAllUsingFunctionName(pageable);
        return new ResponseEntity<>(bookEntities, HttpStatus.OK);
    }

    // In reality, change function name "getBooksUsingJPQT" to "getBooks"
    @GetMapping("/v2")
    @PostMapping
    @DeleteMapping
    public ResponseEntity<Page<Book>> getBooksUsingJPQT(
            @And({
                    @Spec(path = "bookId", params = "bookId", spec = Equal.class),
                    @Spec(path = "rating", params = "ratingGreater", spec = GreaterThan.class),
                    @Spec(path = "rating", params = "ratingSmaller", spec = LessThan.class)
            }) Specification<Book> specs,
            Pageable pageable) {
        Page<Book> bookEntities = bookService.findAllUsingJPQL(specs, pageable);
        return new ResponseEntity<>(bookEntities, HttpStatus.OK);
    }

    @GetMapping("/v3")
    public ResponseEntity<List<Book>> getBooksUsingQuerydsl() {
        List<Book> bookEntities = bookService.queryFromQuerydsl();
        return new ResponseEntity<>(bookEntities, HttpStatus.OK);
    }
}

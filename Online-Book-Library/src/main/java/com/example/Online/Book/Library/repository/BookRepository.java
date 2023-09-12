package com.example.Online.Book.Library.repository;

import com.example.Online.Book.Library.entity.BookEntity;
import com.example.Online.Book.Library.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    BookEntity findByBookId(long bookId);
    List<ReviewEntity> findAllByBookId(long bookId);


}
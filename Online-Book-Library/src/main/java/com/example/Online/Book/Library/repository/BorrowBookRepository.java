package com.example.Online.Book.Library.repository;

import com.example.Online.Book.Library.entity.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowBookRepository extends JpaRepository<BorrowBook,Long> {

}

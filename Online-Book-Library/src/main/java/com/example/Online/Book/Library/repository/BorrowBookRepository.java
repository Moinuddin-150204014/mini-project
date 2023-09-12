package com.example.Online.Book.Library.repository;

import com.example.Online.Book.Library.entity.BookEntity;
import com.example.Online.Book.Library.entity.BorrowBookEntity;
import com.example.Online.Book.Library.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowBookRepository extends JpaRepository<BorrowBookEntity,Long> {

    BorrowBookEntity findByUserEntityAndBookEntityAndReturnDateIsNull(UserEntity userEntity, BookEntity bookEntity);

    BorrowBookEntity findByUserIdAndBookId(Long userId, Long bookId);

    List<BorrowBookEntity> findAllByUserEntity(UserEntity userEntity);

    List<BorrowBookEntity> findAllByUserEntityAndReturnDateIsNull(UserEntity userEntity);
}

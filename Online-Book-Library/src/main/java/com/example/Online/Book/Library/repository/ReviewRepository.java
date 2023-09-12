package com.example.Online.Book.Library.repository;

import com.example.Online.Book.Library.entity.BookEntity;
import com.example.Online.Book.Library.entity.ReviewEntity;
import com.example.Online.Book.Library.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

    List<ReviewEntity> findAllByBookEntity(BookEntity bookEntity) throws Exception;
    //ReviewEntity findByReviewIdForUpdate(Long reviewId, BookEntity bookEntity, UserEntity userEntity);

   // ReviewEntity findByUserAndBook(UserEntity userEntity, BookEntity bookEntity);

    ReviewEntity findByUserEntityAndBookEntity(UserEntity userEntity, BookEntity bookEntity);

    ReviewEntity findByReviewIdBookEntityUserEntity(Long reviewId, BookEntity bookEntity, UserEntity userEntity);
}

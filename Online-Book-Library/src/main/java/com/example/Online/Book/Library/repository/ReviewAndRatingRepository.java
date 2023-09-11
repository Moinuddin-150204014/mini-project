package com.example.Online.Book.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewAndRatingRepository extends JpaRepository<ReviewAndRatingRepository, Long> {
}

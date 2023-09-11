package com.example.Online.Book.Library.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewAndRatingDto {
    private long reviewId;
    private Long bookId;
    private Long userId;
    private String review;
    private float rating;
}

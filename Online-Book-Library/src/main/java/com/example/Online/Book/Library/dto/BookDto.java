package com.example.Online.Book.Library.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private long bookId;
    private String title;
    private String author;
    private String genre;
    private String about;
    private String status;
}

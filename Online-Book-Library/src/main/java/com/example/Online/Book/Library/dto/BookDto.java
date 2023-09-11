package com.example.Online.Book.Library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private long bookId;
    private String title;
    private String author;
    private String genre;
    private String about;
}

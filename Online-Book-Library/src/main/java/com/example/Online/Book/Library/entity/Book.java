package com.example.Online.Book.Library.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookId;
    private String title;
    private String author;
    private String genre;
    private String about;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BorrowBook> borrowRecords = new ArrayList<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<ReviewAndRating> reviewAndRatings = new ArrayList<>();



}

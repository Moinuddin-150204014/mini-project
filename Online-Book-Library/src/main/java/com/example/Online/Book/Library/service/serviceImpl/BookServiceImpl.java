package com.example.Online.Book.Library.service.serviceImpl;

import com.example.Online.Book.Library.dto.BookDto;
import com.example.Online.Book.Library.entity.BookEntity;
import com.example.Online.Book.Library.repository.BookRepository;
import com.example.Online.Book.Library.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookDto> getAllBook() {

        List<BookEntity> allBookEntities = bookRepository.findAllByBookStatus();//incomplete

        return allBookEntities.stream()
                .map(bookEntity -> BookDto.builder()
                        .bookId(bookEntity.getBookId())
                        .title(bookEntity.getTitle())
                        .author(bookEntity.getAuthor())
                        .genre(bookEntity.getGenre())
                        .about(bookEntity.getAbout())
                        .build()
                )
                .collect(Collectors.toList());
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        BookEntity bookEntity = new BookEntity();

        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setAuthor(bookDto.getAuthor());
        bookEntity.setGenre(bookDto.getGenre());
        bookEntity.setAbout(bookDto.getAbout());

        BookEntity newBookEntity = bookRepository.save(bookEntity);
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(newBookEntity, BookDto.class);
    }

    @Override
    public BookDto updateBook(BookDto bookDto) throws Exception {

        BookEntity bookEntity = bookRepository.findByBookId(bookDto.getBookId());

        if (bookEntity == null || bookEntity.getStatus().equals("DELETED"))
            throw new Exception("Deleted Book can't be updated");
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setAuthor(bookDto.getAuthor());
        BookEntity storedBookDetailsEntity = bookRepository.save(bookEntity);
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(storedBookDetailsEntity, BookDto.class);
    }

    public void deleteBook(BookDto bookDto) throws Exception {
        BookEntity bookEntity = bookRepository.findByBookId(bookDto.getBookId());

        if (bookEntity != null) {
            if (bookEntity.getStatus().equals("BORROWED")) throw new Exception("Borrowed Book can't be deleted");
            bookEntity.setStatus("DELETED");
            bookRepository.save(bookEntity);
        } else {
            throw new Exception("Book does not exist!");
        }
    }
}

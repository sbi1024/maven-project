package ch02.dao;

import ch02.dto.BookDto;

import java.util.List;

public interface BookDao {
    List<BookDto> listBook();

    BookDto detailBook(int bookId);

    int insertBook(BookDto bookDto);

    int updateBook(BookDto bookDto);

    int deleteBook(int bookId);
}

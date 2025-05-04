package com.example.ebook.service.book;

import java.util.List;

import com.example.ebook.model.reponseDTO.BookResponseDTO;
import com.example.ebook.model.requestDTO.BookRequestDTO;

public interface BookService {
    BookResponseDTO createBook(BookRequestDTO request);

    BookResponseDTO getBookById(Long id);

    List<BookResponseDTO> getAllBooks();

    BookResponseDTO updateBook(Long id, BookRequestDTO request);

    void deleteBook(Long id);

}

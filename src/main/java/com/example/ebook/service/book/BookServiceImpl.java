package com.example.ebook.service.book;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ebook.model.Book;
import com.example.ebook.model.reponseDTO.BookResponseDTO;
import com.example.ebook.model.requestDTO.BookRequestDTO;
import com.example.ebook.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public BookResponseDTO createBook(BookRequestDTO request) {
        LocalDateTime now = LocalDateTime.now();
        Book book = Book.builder()
                .title(request.getTitle())
                .author(request.getAuthor())
                .description(request.getDescription())
                .genre(request.getGenre())
                .publishedDate(request.getPublishedDate())
                .price(request.getPrice())
                .stock(request.getStock())
                .createdAt(now)
                .build();
        return toDTO(bookRepository.save(book));
    }

    @Override
    public BookResponseDTO getBookById(Long id) {
        return bookRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public List<BookResponseDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookResponseDTO updateBook(Long id, BookRequestDTO request) {
        LocalDateTime now = LocalDateTime.now();
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setDescription(request.getDescription());
        book.setGenre(request.getGenre());
        book.setPublishedDate(request.getPublishedDate());
        book.setPrice(request.getPrice());
        book.setStock(request.getStock());
        book.setUpdatedAt(now);
        return toDTO(bookRepository.save(book));
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    private BookResponseDTO toDTO(Book book) {
        return BookResponseDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .description(book.getDescription())
                .genre(book.getGenre())
                .publishedDate(book.getPublishedDate())
                .price(book.getPrice())
                .stock(book.getStock())
                .createdAt(book.getCreatedAt())
                .updatedAt(book.getUpdatedAt())
                .build();
    }

}
